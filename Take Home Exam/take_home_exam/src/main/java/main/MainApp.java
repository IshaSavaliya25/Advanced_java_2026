package main;

import dao.BookDAO;
import model.Book;

public class MainApp {
    public static void main(String[] args) {

        BookDAO dao = new BookDAO();

        dao.saveBook(new Book("Java Programming", "James Gosling", 10));

        dao.getAllBooks().forEach(b ->
                System.out.println(b.getBookId() + " " + b.getTitle())
        );

        Book book = dao.getAllBooks().get(0);
        book.setQuantity(20);
        dao.updateBook(book);

        dao.deleteBook(2);
    }
}