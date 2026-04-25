package com.blog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.*;

@WebServlet("/addBlog")
public class AddBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String username = req.getParameter("username");

        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO blogs(title, content, username) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, content);
            ps.setString(3, username);

            ps.executeUpdate();
            res.sendRedirect("index.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}