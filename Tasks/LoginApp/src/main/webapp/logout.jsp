<%@ page import="javax.servlet.http.*" %>

<%
    HttpSession sessionObj = request.getSession(false);
    if (sessionObj != null) {
        sessionObj.invalidate();
    }

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("username".equals(c.getName())) {
                c.setValue("");
                c.setPath(request.getContextPath());
                c.setMaxAge(0);
                response.addCookie(c);
            }
        }
    }

    response.sendRedirect("login.jsp");
%>