package helloweb;

import javax.enterprise.context.RequestScoped;

/**
 * くだけた挨拶
 */
@RequestScoped
@Informal
public class InformalGreeting extends Greeting{
    @Override
    public String greet(String username) {
        return "Yo! " + (username == null ? "" : username);
    }
}
