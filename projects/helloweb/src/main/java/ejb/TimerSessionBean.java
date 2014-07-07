package ejb;

import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class TimerSessionBean {

    @Schedule(hour = "*", minute = "*", second = "*/10", persistent = false)
    public void myTimer() {
        System.out.println("Timer event: " + new Date());
    }

}
