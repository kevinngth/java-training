package com.customer.accessingdatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class CustomerRepositoryTests {
    @Autowired
    CustomerRepository repo;
    @Autowired
    EntityManager em;

    @Test
    void shouldFindCustomer() {
        repo.create("Aaron", "Ang", "aa@gmail.com");
        List<Customer> cList = repo.findByLastName("Ang");
        Customer c2 = cList.get( 0 );
        assertThat( c2.getFirstName() ).isEqualTo( "Aaron" );
    }

    @Test
    void shouldUpdateCustomer() {
        repo.create("Aaron", "Ang", "aa@gmail.com");
        List<Customer> cList = repo.findByLastName("Ang");
        Customer c2 = cList.get( 0 );
        assertThat( c2.getEmail() ).isEqualTo( "aa@gmail.com" );
        c2.setEmail("aaron-ang@gmail.com");
        repo.update(c2);
        Customer c3 = repo.findByLastName("Ang").get( 0 );
        assertThat( c3.getEmail() ).isEqualTo( "aaron-ang@gmail.com" );
    }

    @Test
    void shouldGetAllCustomers() {
		Customer c = new Customer("Aaron", "Ang", "aa@gmail.com");
		Customer c2 = new Customer("Aaron", "Ong", "ao@gmail.com");
		Customer c3 = new Customer("Aaron", "Tan", "at@gmail.com");
		Customer c4 = new Customer("Aaron", "Lim", "al@gmail.com");
		Customer c5 = new Customer("Ben", "Lim", "bl@gmail.com");
		Customer c6 = new Customer("Charlie", "Lim", "cl@gmail.com");
		Customer[] cAll = {c, c2, c3, c4, c5, c6};
		for (Customer customer : cAll) {
			repo.create(customer.getFirstName(), customer.getLastName(), customer.getEmail());
		}
		em.flush();
		em.clear();
		int result = repo.all().size();
        assertThat( result ).isEqualTo( 6 );
    }

    @Test
    void shouldDeleteCustomer() {
        Customer c = new Customer("Aaron", "Ang", "aa@gmail.com");
        Customer c2 = new Customer("Aaron", "Ong", "ao@gmail.com");
        Customer c3 = new Customer("Aaron", "Tan", "at@gmail.com");
        Customer c4 = new Customer("Aaron", "Lim", "al@gmail.com");
        Customer c5 = new Customer("Ben", "Lim", "bl@gmail.com");
        Customer c6 = new Customer("Charlie", "Lim", "cl@gmail.com");
        Customer[] cAll = {c, c2, c3, c4, c5, c6};
        for (Customer customer : cAll) {
            repo.create(customer.getFirstName(), customer.getLastName(), customer.getEmail());
        }
        Customer c7 = repo.findByLastName("Ong").get( 0 );
        repo.delete(c7);
        assertThat( repo.all().size() ).isEqualTo( 5 );
    }

//	@Test
//	@Transactional
//	void shouldReturnAllCustomersWithSameFirstName() {
//		Customer c = new Customer("Aaron", "Ang", "aa@gmail.com");
//		Customer c2 = new Customer("Aaron", "Ong", "ao@gmail.com");
//		Customer c3 = new Customer("Aaron", "Tan", "at@gmail.com");
//		Customer c4 = new Customer("Aaron", "Lim", "al@gmail.com");
//		Customer c5 = new Customer("Ben", "Lim", "bl@gmail.com");
//		Customer c6 = new Customer("Charlie", "Lim", "cl@gmail.com");
//		Customer[] cAll = {c, c2, c3, c4, c5, c6};
//		for (Customer customer : cAll) {
//			repo.create(customer.getFirstName(), customer.getLastName(), customer.getEmail());
//		}
//	}

}
