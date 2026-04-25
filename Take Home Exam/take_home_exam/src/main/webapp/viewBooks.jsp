<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Books</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f4f6f9;
        }
        .container {
            width: 85%;
            margin: 40px auto;
            background: white;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            text-align: center;
        }
        th {
            background: #667eea;
            color: white;
        }
        tr:nth-child(even) {
            background: #f9f9f9;
        }
        tr:hover {
            background: #eef1ff;
        }
        .btn {
            padding: 6px 12px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 13px;
        }
        .edit-btn {
            background: #28a745;
            color: white;
        }
        .edit-btn:hover {
            background: #218838;
        }
        .delete-btn {
            background: #dc3545;
            color: white;
        }
        .delete-btn:hover {
            background: #c82333;
        }
        .top-link {
            display: inline-block;
            margin-bottom: 15px;
            text-decoration: none;
            color: #667eea;
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="container">

    <a class="top-link" href="addBook.jsp">Back to Add Book</a>

    <h2>Book List</h2>

    <table>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Quantity</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="b" items="${bookList}">
            <tr>
                <td>${b.bookId}</td>
                <td>${b.title}</td>
                <td>${b.author}</td>
                <td>${b.quantity}</td>

                <!-- EDIT -->
                <td>
                    <form action="editBook.jsp" method="get">
                        <input type="hidden" name="id" value="${b.bookId}">
                        <input type="hidden" name="title" value="${b.title}">
                        <input type="hidden" name="author" value="${b.author}">
                        <input type="hidden" name="quantity" value="${b.quantity}">
                        <button class="btn edit-btn">Edit</button>
                    </form>
                </td>

                <!-- DELETE -->
                <td>
                    <form action="deleteBook" method="post">
                        <input type="hidden" name="id" value="${b.bookId}">
                        <button class="btn delete-btn"
                                onclick="return confirm('Delete this book?')">
                            Delete
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>

    </table>

</div>

</body>
</html>