package semester6;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;


@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {

    Connection con;

    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/books", "root", "");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        String title = req.getParameter("title");
        String author = req.getParameter("author");

        try {
            if(action.equals("add")) {
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO books(title, author) VALUES (?,?)");
                ps.setString(1, title);
                ps.setString(2, author);
                ps.executeUpdate();
                res.getWriter().println("Book Added");
            }

            else if(action.equals("delete")) {
                int id = Integer.parseInt(req.getParameter("id"));
                PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM books WHERE id=?");
                ps.setInt(1, id);
                ps.executeUpdate();
                res.getWriter().println("Book Deleted");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

