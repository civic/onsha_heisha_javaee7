package websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/chat/{roomNo}", 
        decoders={ChatMessageDecoder.class}, 
        encoders = {ChatMessageEncoder.class})
public class ChatEndpoint {
    private String roomNo;
    private static final Map<String, Set<Session>> roomSession = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("roomNo") String rn) throws IOException{
        this.roomNo = rn;
        synchronized(roomSession){
            if (!roomSession.containsKey(rn)){
                roomSession.put(rn, new HashSet<Session>());
            }
            roomSession.get(this.roomNo).add(session);
        }
    }

    @OnMessage
    public void onMessage(ChatMessage msg) throws IOException, EncodeException {
        for (Session session : roomSession.get(this.roomNo)){
            session.getBasicRemote().sendObject(msg);
        }
    }
    
    @OnClose
    public void onClose(Session session) throws IOException{
        roomSession.get(this.roomNo).remove(session);

    }
}
