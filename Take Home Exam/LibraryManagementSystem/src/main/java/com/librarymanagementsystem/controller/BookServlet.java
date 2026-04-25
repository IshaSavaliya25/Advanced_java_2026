package com.librarymanagementsystem.controller;

import com.librarymanagementsystem.service.BookService;
import com.librarymanagementsystem.entity.Book;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookServlet extends HttpServlet {

    private BookService bookService = new BookService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int bookId = Integer.parseInt(request.getParameter("bookId"));

        boolean issued = bookService.issueBook(bookId);

        HttpSession session = request.getSession();

        if (issued) {
            List<Book> issuedBooks = (List<Book>) session.getAttribute("issuedBooks");

            if (issuedBooks == null) {
                issuedBooks = new ArrayList<>();
            }

            Book book = bookService.getBookById(bookId);
            issuedBooks.add(book);

            session.setAttribute("issuedBooks", issuedBooks);

            RequestDispatcher rd = request.getRequestDispatcher("issueSuccess.jsp");
            rd.forward(request, response);

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }
}