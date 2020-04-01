package com.training.book_store.app.service;

import com.training.book_store.app.model.Book;
import com.training.book_store.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class BookService {
    @Autowired
    BookRepository bookRepo;

    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void addNewBook(String title, String author, String rawDatePublished, Double rrp) {
        LocalDate datePublished = LocalDate.parse(rawDatePublished);
        Book b = new Book(title, author, datePublished, rrp);
        bookRepo.save( b );
    }

    public List<Book> searchTitle(String title) {
        return bookRepo.findByTitle(title);
    }

    public List<Book> getHappyHourBooks() {
        double DISCOUNT = 0.9;
        List<Book> bookList = (List<Book>) bookRepo.findAll();
        for (Book book : bookList) {
            book.setRrp(book.getRrp() * DISCOUNT);
        }
        return bookList;
    }
}
