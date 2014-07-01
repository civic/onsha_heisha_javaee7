package websocket;

import java.util.Date;

public class ChatMessage {
    private Date timestamp;
    private String talk;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }


    
}
