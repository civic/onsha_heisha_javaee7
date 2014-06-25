package helloweb;

/**
 * 挨拶
 */
public class Greeting {
    
    public String greet(String username){
        return "Hello World! " + (username == null ? "" : username);
    }
}
