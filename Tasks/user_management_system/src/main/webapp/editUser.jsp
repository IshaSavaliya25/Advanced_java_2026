<%@ page import="java.sql.*,com.user.DBConnection" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));

    Connection con = DBConnection.getConnection();

    if (con == null) {
        out.println("<h2 style='color:red;'>Database Connection Failed</h2>");
        return;
    }

    PreparedStatement ps = con.prepareStatement("SELECT * FROM user1 WHERE id=?");
    ps.setInt(1, id);

    ResultSet rs = ps.executeQuery();

    if (!rs.next()) {
        out.println("<h2>User not found</h2>");
        return;
    }
%>

<html>
<head>
    <title>Edit User</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="form-container">
    <h2>Edit User</h2>

    <form action="updateUser" method="post">
        <input type="hidden" name="id" value="<%= id %>">

        <input type="text" name="name" value="<%= rs.getString("name") %>" required>
        <input type="email" name="email" value="<%= rs.getString("email") %>" required>
        <input type="text" name="password" value="<%= rs.getString("password") %>" required>

        <select name="role">
            <option value="user" <%= rs.getString("role").equals("user") ? "selected" : "" %>>User</option>
            <option value="admin" <%= rs.getString("role").equals("admin") ? "selected" : "" %>>Admin</option>
        </select>

        <button type="submit">Update User</button>
    </form>

    <a href="viewUsers" class="back">⬅ Back</a>
</div>

</body>
</html>