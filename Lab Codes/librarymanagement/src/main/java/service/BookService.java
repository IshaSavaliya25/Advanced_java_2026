package service;

import com.library.Entity.Book;
import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public void saveBook(Book book) {
        repo.save(book);
    }

    public Book getBookById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteBook(int id) {
        repo.deleteById(id);
    }
}

