package websocket;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class ChatMessageEncoder implements Encoder.Text<ChatMessage>{

    @Override
    public String encode(ChatMessage msg) throws EncodeException {
        JsonObject json = Json.createObjectBuilder()
                .add("timestamp", msg.getTimestamp().getTime())
                .add("talk", msg.getTalk())
                .build();

        return json.toString();
    }

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    
}
