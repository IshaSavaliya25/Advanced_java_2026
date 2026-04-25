<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
    <style>
        body {
            font-family: Arial;
            background: #f4f6f9;
            margin: 0;
        }
        .navbar {
            background: #667eea;
            color: white;
            padding: 15px;
            text-align: center;
            font-size: 20px;
        }
        .container {
            width: 400px;
            margin: 40px auto;
            background: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
        }
        input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
        }
        button {
            width: 100%;
            padding: 10px;
            background: #667eea;
            color: white;
            border: none;
        }
        a {
            display: block;
            margin-top: 15px;
            text-align: center;
        }
    </style>
</head>
<body>

<div class="navbar">Library Management System</div>

<div class="container">
    <h3>Add New Book</h3>

    <form action="addBook" method="post">
        Title: <input type="text" name="title"><br>
        Author: <input type="text" name="author"><br>
        Quantity: <input type="number" name="quantity"><br>
        <button type="submit">Add</button>
    </form>

    <a href="viewBooks">View Books</a>
</div>

</body>
</html>