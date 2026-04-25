package com.user;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.*;
@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM users1 WHERE id=?"
            );

            ps.setInt(1, Integer.parseInt(req.getParameter("id")));
            ps.executeUpdate();

            res.sendRedirect("viewUsers");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
