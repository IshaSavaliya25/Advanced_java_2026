<%@ page import="java.sql.*,com.blog.DBConnection" %>

<html>
<head>
    <title>Blog Manager</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<h1>Blog Manager</h1>

<a href="addBlog.jsp" class="btn">Add Blog</a>

<div class="container">

    <%
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();

            // ✅ Check connection first
            if (con == null) {
    %>
    <h2 style="color:red; text-align:center;">❌ Database Connection Failed</h2>
    <%
    } else {
        st = con.createStatement();
        rs = st.executeQuery("SELECT * FROM blogs ORDER BY id DESC");

        while (rs.next()) {
    %>

    <div class="card">
        <h2><%= rs.getString("title") %></h2>
        <p><%= rs.getString("content") %></p>
        <small>
            By <%= rs.getString("username") %> |
            <%= rs.getTimestamp("published_at") %>
        </small>

        <br><br>
        <a href="editBlog.jsp?id=<%= rs.getInt("id") %>" class="edit">Edit</a>
    </div>

    <%
            }
        }

    } catch (Exception e) {
    %>
    <h2 style="color:red; text-align:center;">⚠️ Error: <%= e.getMessage() %></h2>
    <%
        } finally {
            try { if (rs != null) rs.close(); } catch(Exception e) {}
            try { if (st != null) st.close(); } catch(Exception e) {}
            try { if (con != null) con.close(); } catch(Exception e) {}
        }
    %>

</div>

</body>
</html>