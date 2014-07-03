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
    private static final Map<String, Set<Session>> roomSessions = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("roomNo") String rn) throws IOException{
        this.roomNo = rn;
        synchronized(roomSessions){
            if (!roomSessions.containsKey(rn)){
                //初めて作成入る部屋用のSetを作成
                roomSessions.put(rn, new HashSet<Session>());
            }
            roomSessions.get(this.roomNo).add(session);
            //roomSessions.computeIfAbsent(this.roomNo, s -> new HashSet<>()).add(session); //jdk8
        }
    }

    @OnMessage
    public void onMessage(ChatMessage msg) throws IOException, EncodeException {
        for (Session session : roomSessions.get(this.roomNo)){
            session.getBasicRemote().sendObject(msg);
        }
    }
    
    @OnClose
    public void onClose(Session session) throws IOException{
        roomSessions.get(this.roomNo).remove(session);

    }
}
