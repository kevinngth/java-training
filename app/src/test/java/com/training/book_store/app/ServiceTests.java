package com.training.book_store.app;

import com.training.book_store.app.model.Book;
import com.training.book_store.app.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class ServiceTests {
    @Autowired
    BookService bookService;
    @Autowired
    EntityManager em;

    void flushAndClear() {
        em.flush();
        em.clear();
    }

    @BeforeEach
    void setup() {
        bookService.addNewBook("Harry Potter", "J. K. Rowling", "2015-02-20", 11.0);
    }

    @Test
    void shouldAddNewBook() {
        flushAndClear();
        List<Book> listOfBooks = bookService.searchTitle("Harry Potter");
        assertThat( listOfBooks.get( 0 ).getAuthor() ).isEqualTo("J. K. Rowling");
    }

    @Test
    void shouldShowBooksOnDiscount() {
        List<Book> happyHourBooks = bookService.getHappyHourBooks();
        Book book = happyHourBooks.get( 0 );
        assertThat( book.getRrp() ).isEqualTo( 9.9 );
    }
}
