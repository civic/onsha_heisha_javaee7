package helloweb;

import javax.enterprise.context.RequestScoped;

/**
 * 挨拶
 */
@RequestScoped
public class Greeting {
    
    public String greet(String username){
        return "Hello World!" + (username == null ? "" : username);
    }
}
