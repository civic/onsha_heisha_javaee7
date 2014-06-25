package jaxrs;

import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("users")
public class UsersResource {

    @Context
    private UriInfo context;

    @GET
    @Produces("application/json")
    public List<User> getUsers() {
        return Arrays.asList(new User(10, "Taro"), new User(20, "John"));
    }

    @GET
    @Path("{userid}")
    @Produces("application/json")
    public User getUser(@PathParam("userid") int userid) {

        if (userid == 10) {
            return new User(10, "Taro");
        } else if (userid == 20){
            return new User(20, "John");
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

}
