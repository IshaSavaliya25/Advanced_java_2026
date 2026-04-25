<%@ page import="java.sql.*" %>

<html>
<head>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<h1>Admin Dashboard</h1>

<a href="addUser.jsp" class="btn">Add User</a>

<table>
    <tr>
        <th>ID</th><th>Name</th><th>Email</th><th>Role</th><th>Actions</th>
    </tr>

    <%
        ResultSet rs = (ResultSet) request.getAttribute("users");

        while(rs.next()){
    %>

    <tr>
        <td><%= rs.getInt("id") %></td>
        <td><%= rs.getString("name") %></td>
        <td><%= rs.getString("email") %></td>
        <td><%= rs.getString("role") %></td>

        <td>
            <a href="editUser.jsp?id=<%= rs.getInt("id") %>" class="edit">Edit</a>
            <a href="deleteUser?id=<%= rs.getInt("id") %>" class="delete">Delete</a>
        </td>
    </tr>

    <% } %>

</table>

</body>
</html>