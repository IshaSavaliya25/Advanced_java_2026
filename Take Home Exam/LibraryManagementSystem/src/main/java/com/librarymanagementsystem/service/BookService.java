package com.librarymanagementsystem.service;

import com.librarymanagementsystem.dao.BookDAO;
import com.librarymanagementsystem.entity.Book;

public class BookService {

    private BookDAO dao = new BookDAO();

    public boolean issueBook(int id) {
        return dao.issueBook(id);
    }

    public Book getBookById(int id) {
        return dao.getBook(id);
    }
}
