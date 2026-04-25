package dao;

import model.Book;
import util.HibernateUtil;
import org.hibernate.*;

import java.util.List;

public class BookDAO {

    // SAVE
    public void saveBook(Book book) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.save(book);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // LIST
    public List<Book> getAllBooks() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Book", Book.class).list();
        }
    }

    // UPDATE
    public void updateBook(Book book) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.update(book);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }

    // DELETE
    public void deleteBook(int id) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Book book = session.get(Book.class, id);
            if (book != null) {
                session.delete(book);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }
}