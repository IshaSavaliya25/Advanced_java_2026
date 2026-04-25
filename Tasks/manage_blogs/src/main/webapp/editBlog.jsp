<%@ page import="java.sql.*,com.blog.DBConnection" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    Connection con = DBConnection.getConnection();
    PreparedStatement ps = con.prepareStatement("SELECT * FROM blogs WHERE id=?");
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    rs.next();
%>

<html>
<head>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Edit Blog</h2>

<form action="editBlog" method="post" class="form">
    <input type="hidden" name="id" value="<%= id %>">

    <input type="text" name="title" value="<%= rs.getString("title") %>"><br>
    <textarea name="content"><%= rs.getString("content") %></textarea><br>

    <button type="submit">Update</button>
</form>

</body>
</html>