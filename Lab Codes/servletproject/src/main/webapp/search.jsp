<%@ page import="java.util.*" %>

<html>
<head>
    <title>Search User by DOB</title>
</head>
<body>

<h2>Search User by DOB</h2>

<form action="SearchResult" method="post">
    Enter DOB:
    <input type="date" name="dob" required>
    <input type="submit" value="Search">
</form>

<hr>

<%
    String[] names = (String[]) request.getAttribute("nameA");
    String[] emails = (String[]) request.getAttribute("emailA");
    String[] dobs = (String[]) request.getAttribute("doblist");

    if (names != null && names.length > 0) {
%>
<h3>Results:</h3>
<%
    for (int i = 0; i < names.length; i++) {
%>
<p>
    Name: <%= names[i] %><br>
    Email: <%= emails[i] %><br>
    DOB: <%= dobs[i] %><br>
</p>
<%
    }
} else if (names != null) {
%>
<p>No data found ❌</p>
<%
    }
%>

</body>
</html>