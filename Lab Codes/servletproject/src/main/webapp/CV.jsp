<%@ page import="javax.servlet.*" %>
<html>
<head>
    <title>CV Form</title>
</head>
<body>

<h2>Enter Your CV Details</h2>

<form action="ConServlet" method="post">
    Name: <input type="text" name="name" required><br><br>
    Email: <input type="email" name="email" required><br><br>
    Qualification: <input type="text" name="qualification" required><br><br>
    City: <input type="text" name="city" required><br><br>
    Mobile: <input type="text" name="mobile" required><br><br>

    <input type="submit" value="Submit">
</form>

<hr>

<%
    ServletContext context = application;
    String msg = (String) context.getAttribute("msg");

    if (msg != null) {
%>
<h3><%= msg %></h3>
<%
        context.removeAttribute("msg");
    }
%>

</body>
</html>