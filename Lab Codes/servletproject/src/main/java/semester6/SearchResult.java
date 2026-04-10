package semester6;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SearchResult")
public class SearchResult extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<String> emailList = new ArrayList<>();
        ArrayList<String> dobList = new ArrayList<>();

        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect DB
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentdb",
                    "root",
                    ""
            );

            String dob = req.getParameter("dob");

            // Query
            String query = "SELECT name, email, dob FROM users WHERE dob=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, dob);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                nameList.add(rs.getString("name"));
                emailList.add(rs.getString("email"));
                dobList.add(rs.getString("dob"));
            }

            // Convert to array
            req.setAttribute("nameA", nameList.toArray(new String[0]));
            req.setAttribute("emailA", emailList.toArray(new String[0]));
            req.setAttribute("doblist", dobList.toArray(new String[0]));

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Forward to JSP
        RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
        rd.forward(req, resp);
    }
}