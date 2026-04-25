package servlet;

import dao.BookDAO;
import model.Book;
import model.BookBean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

public class ViewBooksServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        BookDAO dao = new BookDAO();
        List<Book> books = dao.getAllBooks();
        request.setAttribute("bookList", books);

        List<BookBean> beanList = new ArrayList<>();

        for (Book b : books) {
            BookBean bean = new BookBean();
            bean.setBookId(b.getBookId());
            bean.setTitle(b.getTitle());
            bean.setAuthor(b.getAuthor());
            bean.setQuantity(b.getQuantity());
            beanList.add(bean);
        }

        request.setAttribute("bookList", beanList);

        RequestDispatcher rd = request.getRequestDispatcher("viewBooks.jsp");
        rd.forward(request, response);
    }
}