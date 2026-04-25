package com.library.controller;

import com.library.Entity.Book;
import service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class BookDAO {

    private final BookService service;

    public BookDAO(BookService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewBooks(Model model) {
        model.addAttribute("Books", service.getAllBooks());
        return "View Book";
    }

    @GetMapping("/add")
    public String addBooks(Model model) {
        model.addAttribute("Books", new Book());
        return "Add Book";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book) {
        service.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("book", service.getBookById(id));
        return "edit-book";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.deleteBook(id);
        return "redirect:/";
    }
}


