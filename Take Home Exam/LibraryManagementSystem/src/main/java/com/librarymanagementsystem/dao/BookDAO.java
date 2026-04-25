package com.librarymanagementsystem.dao;

import com.librarymanagementsystem.entity.Book;
import com.librarymanagementsystem.util.HibernateUtil;
import org.hibernate.*;

public class BookDAO {

    public Book getBook(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(Book.class, id);
    }

    public boolean issueBook(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Book book = session.get(Book.class, id);

        if (book.getAvailablecopies() > 0) {
            book.setAvailablecopies(book.getAvailablecopies() - 1);
            session.update(book);
            tx.commit();
            session.close();
            return true;
        }

        session.close();
        return false;
    }

    public void returnBook(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Book book = session.get(Book.class, id);
        book.setAvailablecopies(book.getAvailablecopies() + 1);

        session.update(book);
        tx.commit();
        session.close();
    }
}