package com.training.book_store.app;

import com.training.book_store.app.model.Book;
import com.training.book_store.app.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
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
        bookService.addNewBook("Lord of the Ring", "J. R. R. Tolkien", "2012-11-15", 22.0);
        flushAndClear();
    }

    @Test
    void shouldAddNewBook() {
        List<Book> listOfBooks = bookService.searchTitle("Harry Potter");
        assertThat( listOfBooks.get( 0 ).getAuthor() ).isEqualTo("J. K. Rowling");
    }

    @Test
    void shouldShowBooksWithDiscount() {
        List<Book> happyHourBooks = bookService.applyDiscount( bookService.getAllBooks() );
        Book book = happyHourBooks.get( 0 );
        assertThat( book.getRrp() ).isEqualTo( 9.9 );
    }

    @Test
    void shouldGetDiscountsBasedOnHappyHour() {
        List<Book> allBooks = bookService.happyHourBooks();
        Book book = allBooks.get( 0 );
        assertThat( book.getRrp() ).isEqualTo( LocalDateTime.now().getHour() % 2 == 0 ? 9.9 : 11.0 );
    }
}
