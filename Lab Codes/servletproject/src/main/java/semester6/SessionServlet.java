package semester6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        // Session ID
        String sessionId = session.getId();

        // Visit counter
        Integer count = (Integer) session.getAttribute("count");

        if (count == null) {
            count = 1;
        } else {
            count++;
        }

        session.setAttribute("count", count);

        out.println("<h2>Session Tracking Example</h2>");
        out.println("<p>Session ID: " + sessionId + "</p>");
        out.println("<p>Visit Count: " + count + "</p>");

        // Active users from listener
        out.println("<p>Active Users: " + SessionCounterListener.getActiveUsers() + "</p>");
    }
}