package com.blog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/blogs")
public class BlogServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Blog> blogList = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            if (con == null) {
                throw new Exception("Database connection failed");
            }

            String sql = "SELECT * FROM blogs ORDER BY id DESC";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Blog b = new Blog();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setContent(rs.getString("content"));
                b.setUsername(rs.getString("username"));
                b.setPublishedAt(rs.getTimestamp("published_at"));

                blogList.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("blogs", blogList);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
}