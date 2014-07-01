package websocket;

import java.io.IOException;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class EchoEndpoint {

    @OnMessage
    public String onMessage(String message) throws IOException {
        return "From server::: " + message;
    }
    
}
