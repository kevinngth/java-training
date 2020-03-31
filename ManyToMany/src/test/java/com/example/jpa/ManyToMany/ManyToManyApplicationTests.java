package com.example.jpa.ManyToMany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ManyToManyApplicationTests {
	@Autowired
	BookRepository bookRepo;
	@Autowired
	StoreRepository storeRepo;
	@Autowired
	EntityManager em;

	void flushAndClear() {
		em.flush();
		em.clear();
	}

	@Test
	void shouldAddBook() {
		bookRepo.save( new Book( "untitled", "no author", LocalDate.parse("2015-02-20") ) );
		flushAndClear();
		Book b = bookRepo.findByTitle("untitled").get( 0 );
		assertThat( b.getAuthor() ).isEqualTo( "no author" );
	}

	@Test
	void shouldAddStore() {
		storeRepo.save( new Store("ABC books", "11 Bourke Street", LocalTime.parse("10:30"), LocalTime.parse("22:30") ) );
		flushAndClear();
		Store s = storeRepo.findByName("ABC books").get( 0 );
		assertThat( s.getAddress() ).isEqualTo( "11 Bourke Street" );
	}

	@Test
	void shouldGetBooksBelongingToStore() {
		Store s = new Store("ABC books", "11 Bourke Street", LocalTime.parse("10:30"), LocalTime.parse("22:30") );
		Book b1 = new Book( "untitled", "no author", LocalDate.parse("2015-02-20") );
		Book b2 = new Book( "lean startup", "Eric", LocalDate.parse("2011-09-29") );
		s.addBook( b1 );
		s.addBook( b2 );
		storeRepo.save( s );
		flushAndClear();
		Store s2 = storeRepo.findByName("ABC books").get( 0 );
		assertThat( s2.getBooks().size() ).isEqualTo( 2 );
	}

	@Test
	void shouldGetStoresSellingThisBook() {
		Store s = new Store("ABC books", "11 Bourke Street", LocalTime.parse("10:30"), LocalTime.parse("22:30") );
		Book b1 = new Book( "untitled", "no author", LocalDate.parse("2015-02-20") );
		Book b2 = new Book( "lean startup", "Eric", LocalDate.parse("2011-09-29") );
		s.addBook( b1 );
		s.addBook( b2 );
		storeRepo.save( s );
		flushAndClear();
		Book b = bookRepo.findByTitle("untitled").get( 0 );
		Store s1 = b.getStores().get( 0 );
		assertThat( s1.getName() ).isEqualTo( "ABC books" );
	}
}
