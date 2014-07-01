package websocket;

import java.util.Date;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class ChatMessageDecorder implements Decoder.Text<ChatMessage> {

    @Override
    public ChatMessage decode(String s) throws DecodeException {
        ChatMessage msg = new ChatMessage();
        msg.setTimestamp(new Date());   //デコード時点の日時
        msg.setTalk(s);
        return msg;
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }
    
}
