package com.user;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin") && password.equals("123")) {

            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            Cookie ck = new Cookie("username", username);
            ck.setMaxAge(60 * 60); // 1 hour
            response.addCookie(ck);

            response.sendRedirect("home.jsp");

        } else {

            request.setAttribute("error", "Invalid Username or Password");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }
}