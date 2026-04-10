package semester6;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class SearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/books", "root", "");

            String query = "SELECT * FROM books WHERE 1=1";

            if(title != null && !title.isEmpty()) {
                query += " AND title LIKE ?";
            }
            if(author != null && !author.isEmpty()) {
                query += " AND author LIKE ?";
            }

            PreparedStatement ps = con.prepareStatement(query);

            int index = 1;

            if(title != null && !title.isEmpty()) {
                ps.setString(index++, "%" + title + "%");
            }
            if(author != null && !author.isEmpty()) {
                ps.setString(index++, "%" + author + "%");
            }

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                out.println("ID: " + rs.getInt("id") + "<br>");
                out.println("Title: " + rs.getString("title") + "<br>");
                out.println("Author: " + rs.getString("author") + "<br>");
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
            out.println("Error occurred!");
        }
    }
}
