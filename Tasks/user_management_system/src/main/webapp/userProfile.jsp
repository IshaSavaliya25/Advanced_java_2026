<%
    String name = (String) session.getAttribute("user");
    String role = (String) session.getAttribute("role");

    if (name == null) {
        response.sendRedirect("login.jsp");
    }
%>

<html>
<head>
    <title>User Profile</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="profile-card">
    <h2>Welcome, <%= name %></h2>
    <p><strong>Role:</strong> <%= role %></p>

    <p>This is your personal dashboard.</p>

    <a href="login.jsp" class="logout">Logout</a>
</div>

</body>
</html>