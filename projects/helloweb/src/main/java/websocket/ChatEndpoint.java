package websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat/{roomNo}")
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
    public void onMessage(String message) throws IOException {
        for (Session session : roomSession.get(this.roomNo)){
            session.getBasicRemote().sendText(message);
        }
    }
    
    @OnClose
    public void onClose(Session session) throws IOException{
        roomSession.get(this.roomNo).remove(session);

    }
}
