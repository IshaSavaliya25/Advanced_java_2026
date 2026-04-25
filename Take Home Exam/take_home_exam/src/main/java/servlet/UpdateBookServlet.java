package servlet;

import dao.BookDAO;
import model.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        BookDAO dao = new BookDAO();

        Book book = new Book();
        book.setBookId(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setQuantity(quantity);

        dao.updateBook(book);

        response.sendRedirect("viewBooks");
    }
}