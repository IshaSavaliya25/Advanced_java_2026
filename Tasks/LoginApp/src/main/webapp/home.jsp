<%@ page session="true" %>
<%@ page import="javax.servlet.http.Cookie" %>

<%
    String user = (String) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String usernameFromCookie = "";

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if (c.getName().equals("username")) {
                usernameFromCookie = c.getValue();
            }
        }
    }

%>

<!DOCTYPE html>
<html>
<head>
    <title>Home</title>

    <style>
        body {
            margin: 0;
            font-family: Arial;
            background: #f4f6f9;
        }

        .navbar {
            background: #667eea;
            color: white;
            padding: 15px 20px;
            display: flex;
            justify-content: space-between;
        }

        .container {
            padding: 40px;
            text-align: center;
        }

        .card {
            background: white;
            padding: 30px;
            border-radius: 10px;
            display: inline-block;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
        }

        .logout {
            color: white;
            text-decoration: none;
            background: #ff4d4d;
            padding: 8px 12px;
            border-radius: 5px;
        }

        .logout:hover {
            background: #e60000;
        }
    </style>
</head>

<body>

<div class="navbar">
    <div>My App</div>
    <a class="logout" href="<%= request.getContextPath() %>/LogoutServlet">Logout</a>
</div>

<div class="container">
    <div class="card">
        <h2>Welcome, <%= user %></h2>
        <p><b>Cookie Username:</b> <%= usernameFromCookie %></p>
    </div>
</div>

</body>
</html>