package semester6;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ConServlet")
public class ConServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Get form data
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String qualification = req.getParameter("qualification");
        String city = req.getParameter("city");
        String mobile = req.getParameter("mobile");

        // DB object
        DBTransaction db = new DBTransaction();

        boolean result = db.insertData(name, email, qualification, city, mobile);

        ServletContext context = getServletContext();

        if (result) {
            context.setAttribute("msg", "Your CV is successfully submitted");
        } else {
            context.setAttribute("msg", "Submission Failed");
        }

        resp.sendRedirect("CV.jsp");
    }
}