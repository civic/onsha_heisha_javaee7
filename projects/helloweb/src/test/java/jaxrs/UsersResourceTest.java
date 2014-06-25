package jaxrs;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class UsersResourceTest {
    @Test
    public void testGetUser() {
        Client client = ClientBuilder.newClient();
        User user = client.target("http://localhost:8080/helloweb/webresources/users/20")
                .request(MediaType.APPLICATION_JSON)
                .get(User.class);

        assertThat(user.getId(), is(20));
        assertThat(user.getName(), is("John"));
    }
    
    @Test
    public void testGetUsers() {
        Client client = ClientBuilder.newClient();
        List<User> list = client.target("http://localhost:8080/helloweb/webresources/users")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<User>>(){});

        assertThat(list.size(), is(2));
        assertThat(list.get(0).getId(), is(10));
        assertThat(list.get(0).getName(), is("Taro"));
            
    }
}
