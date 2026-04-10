package semester6;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;
@WebServlet("/Seaech")
public class Welcome extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        out.println("<h2>Servlet Programming");
    }

}
