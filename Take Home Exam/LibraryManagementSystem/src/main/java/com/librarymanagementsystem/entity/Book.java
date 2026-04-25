package com.librarymanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private int bookId;

    @NotBlank(message = "Title required")
    private String title;

    private String author;
    private int isbn;
    private int availablecopies;

    @Temporal(TemporalType.DATE)
    private Date publishyear;

    // Many books belong to one category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getIsbn() { return isbn; }
    public void setIsbn(int isbn) { this.isbn = isbn; }

    public int getAvailablecopies() { return availablecopies; }
    public void setAvailablecopies(int availablecopies) { this.availablecopies = availablecopies; }

    public Date getPublishyear() { return publishyear; }
    public void setPublishyear(Date publishyear) { this.publishyear = publishyear; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}