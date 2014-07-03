package websocket;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class EchoEndpointTest {
    @Test
    public void testOnMessage() throws Exception {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();

        TestClientEndpoint tce = new TestClientEndpoint("hello");
        container.connectToServer(tce, new URI("ws://localhost:8080/helloweb/echo"));

        assertThat(tce.get(), is("From server::: hello"));
    }

    @ClientEndpoint
    public static class TestClientEndpoint{
        private final CountDownLatch onMessageLatch = new CountDownLatch(1);
        private final String sendingText;
        private String receive;

        public TestClientEndpoint(String sendingText) {
            this.sendingText = sendingText;
        }

        @OnOpen
        public void onOpen(Session session) throws IOException{
            session.getBasicRemote().sendText(sendingText);
        }
        
        @OnMessage
        public void onMessage(String msg){
            this.receive = msg;
            onMessageLatch.countDown();
        }

        public String get() throws InterruptedException{
            onMessageLatch.await(3, TimeUnit.SECONDS);  //最大3秒待ち
            return this.receive;
        }
    }

}