<!DOCTYPE html>
<html>
<head>
    <title>Edit Book</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(135deg, #667eea, #764ba2);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .card {
            background: white;
            padding: 30px;
            border-radius: 12px;
            width: 350px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        button {
            width: 100%;
            padding: 10px;
            background: #667eea;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background: #5a67d8;
        }
    </style>
</head>
<body>

<div class="card">
    <h2>Edit Book</h2>

    <form action="updateBook" method="post">
        <input type="hidden" name="id" value="${param.id}">

        <input type="text" name="title" value="${param.title}" required>
        <input type="text" name="author" value="${param.author}" required>
        <input type="number" name="quantity" value="${param.quantity}" required>

        <button type="submit">Update Book</button>
    </form>
</div>

</body>
</html>