<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%!
    // Compare numbers
    public String compare(int a, int b) {
        if (a > b) {
            return a + " is greater than " + b;
        } else if (a < b) {
            return a + " is less than " + b;
        } else {
            return "Both numbers are equal";
        }
    }

    // Even or Odd
    public String evenOdd(int a) {
        return (a % 2 == 0) ? a + " is Even" : a + " is Odd";
    }

    // Maximum
    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Minimum
    public int min(int a, int b) {
        return (a < b) ? a : b;
    }

    // Positive / Negative / Zero
    public String checkSign(int a) {
        if (a > 0) return a + " is Positive";
        else if (a < 0) return a + " is Negative";
        else return a + " is Zero";
    }
%>

<html>
<head>
    <title>Result</title>
</head>
<body>

<h2>Result</h2>

<%
    int num1 = Integer.parseInt(request.getParameter("num1"));
    int num2 = Integer.parseInt(request.getParameter("num2"));
%>

<p><b>Number 1:</b> <%= num1 %></p>
<p><b>Number 2:</b> <%= num2 %></p>

<hr>

<h3>Comparison:</h3>
<p><%= compare(num1, num2) %></p>

<h3>Even / Odd:</h3>
<p><%= evenOdd(num1) %></p>
<p><%= evenOdd(num2) %></p>

<h3>Maximum & Minimum:</h3>
<p>Maximum number is: <%= max(num1, num2) %></p>
<p>Minimum number is: <%= min(num1, num2) %></p>

<h3>Sign Check:</h3>
<p><%= checkSign(num1) %></p>
<p><%= checkSign(num2) %></p>

</body>
</html>