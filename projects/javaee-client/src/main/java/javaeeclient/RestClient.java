package javaeeclient;

import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class RestClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        JsonObject user = client.target("http://localhost:8080/helloweb/webresources/users/20")
                .request(MediaType.APPLICATION_JSON)
                .get(JsonObject.class);

        System.out.printf("%d -> %s\n", 
                user.getInt("id"), 
                user.getString("name"));
        
    }
}
