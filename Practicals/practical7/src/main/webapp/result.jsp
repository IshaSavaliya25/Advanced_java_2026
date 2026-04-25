<%@ page language="java" contentType="text/html" %>
<!DOCTYPE html>
<html>
<head>
    <title>Result</title>
</head>
<body>

<h2>Result</h2>

<%
    int num1 = Integer.parseInt(request.getParameter("num1"));
    int num2 = Integer.parseInt(request.getParameter("num2"));

    int add = num1 + num2;
    int sub = num1 - num2;
    int mul = num1 * num2;

    double div = 0;
    if(num2 != 0){
        div = (double) num1 / num2;
    }
%>

<p>Addition: <%= add %></p>
<p>Subtraction: <%= sub %></p>
<p>Multiplication: <%= mul %></p>

<%
    if(num2 != 0){
%>
<p>Division: <%= div %></p>
<%
} else {
%>
<p>Division: Cannot divide by zero</p>
<%
    }
%>

<br>
<a href="index.jsp">Go Back</a>

</body>
</html>