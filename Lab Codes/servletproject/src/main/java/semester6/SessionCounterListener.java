package semester6;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounterListener implements HttpSessionListener {

    private static int activeUsers = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeUsers++;
        System.out.println("Session Created. Active Users: " + activeUsers);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeUsers--;
        System.out.println("Session Destroyed. Active Users: " + activeUsers);
    }

    public static int getActiveUsers() {
        return activeUsers;
    }
}
