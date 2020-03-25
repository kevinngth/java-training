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

    void flushAndClear() {
        em.flush();
        em.clear();
    }

    @Test
    void shouldFindCustomer() {
        repo.create( new Customer("Aaron", "Ang", "aa@gmail.com") );
        flushAndClear();
        Customer c = repo.findBy("lastName","Ang").get( 0 );
        assertThat( c.getFirstName() ).isEqualTo( "Aaron" );
    }

    @Test
    void shouldUpdateCustomer() {
        repo.create(new Customer("Aaron", "Ang", "aa@gmail.com"));
        flushAndClear();
        Customer c = repo.findBy("lastName","Ang").get( 0 );
        assertThat( c.getEmail() ).isEqualTo( "aa@gmail.com" );
        c.setEmail("aaron-ang@gmail.com");
        repo.update(c);
        flushAndClear();
        Customer c2 = repo.findBy("lastName","Ang").get( 0 );
        assertThat( c2.getEmail() ).isEqualTo( "aaron-ang@gmail.com" );
    }

    @Test
    void shouldGetAllCustomers() {
		Customer c1 = new Customer("Aaron", "Ang", "aa@gmail.com");
		Customer c2 = new Customer("Aaron", "Ong", "ao@gmail.com");
		Customer c3 = new Customer("Aaron", "Tan", "at@gmail.com");
		Customer c4 = new Customer("Aaron", "Lim", "al@gmail.com");
		Customer c5 = new Customer("Ben", "Lim", "bl@gmail.com");
		Customer c6 = new Customer("Charlie", "Lim", "cl@gmail.com");
		Customer[] cAll = {c1, c2, c3, c4, c5, c6};
		for (Customer c : cAll) {
			repo.create(c);
		}
		flushAndClear();
		int result = repo.findAll().size();
        assertThat( result ).isEqualTo( 6 );
    }

    @Test
    void shouldDeleteCustomer() {
        Customer c1 = new Customer("Aaron", "Ang", "aa@gmail.com");
        c1.addAccount(new Account("Savings", 10100));
        Customer c2 = new Customer("Aaron", "Ong", "ao@gmail.com");
        c2.addAccount(new Account("Savings", 100));
        Customer c3 = new Customer("Aaron", "Tan", "at@gmail.com");
        c3.addAccount(new Account("Savings", 22100));
        Customer c4 = new Customer("Aaron", "Lim", "al@gmail.com");
        c4.addAccount(new Account("Savings", 35100));
        Customer c5 = new Customer("Ben", "Lim", "bl@gmail.com");
        c5.addAccount(new Account("Savings", 1100));
        Customer c6 = new Customer("Charlie", "Lim", "cl@gmail.com");
        c6.addAccount(new Account("Savings", 2100));
        Customer[] cAll = {c1, c2, c3, c4, c5, c6};
        for (Customer c : cAll) {
            repo.create(c);
        }
        flushAndClear();
        Customer c7 = repo.findBy("lastName","Ong").get( 0 );
        repo.delete(c7);
        flushAndClear();
        assertThat( repo.findAll().size() ).isEqualTo( 5 );
    }

    @Test
    void shouldAddNewAccount() {
        Customer c = new Customer("Aaron", "Ang", "aa@gmail.com");
        c.addAccount(new Account("Savings", 100));
        repo.create(c);
        flushAndClear();
        Customer c3 = repo.findBy("email","aa@gmail.com").get( 0 );
        assertThat(c3.getAccounts().size()).isGreaterThan( 0 );
    }

    @Test
    void shouldDepositMoney() {
        Customer c = new Customer("Aaron", "Ang", "aa@gmail.com");
        c.addAccount(new Account("Savings", 100));
        repo.create(c);
        flushAndClear();
        Customer c2 = repo.findBy("email","aa@gmail.com").get( 0 );
        Account a2 = c2.getAccounts().get( 0 );
        assertThat(a2.getBalance()).isEqualTo( 100 );
        a2.deposit(200);
        repo.update(c2);
        flushAndClear();
        Account a3 = repo.findBy("email","aa@gmail.com").get( 0 ).getAccounts().get( 0 );
        assertThat(a3.getBalance()).isEqualTo( 300 );
    }

    @Test
    void shouldWithdrawMoney() {
        Customer c = new Customer("Aaron", "Ang", "aa@gmail.com");
        c.addAccount(new Account("Savings", 100));
        repo.create(c);
        flushAndClear();
        Customer c2 = repo.findBy("email","aa@gmail.com").get( 0 );
        Account a2 = c2.getAccounts().get( 0 );
        assertThat(a2.getBalance()).isEqualTo( 100 );
        a2.withdraw(50);
        repo.update(c2);
        flushAndClear();
        Account a3 = repo.findBy("email","aa@gmail.com").get( 0 ).getAccounts().get( 0 );
        assertThat(a3.getBalance()).isEqualTo( 50 );
    }

    @Test
    void shouldGetRichCustomersBasedOnAnyAccount() {
        Customer c1 = new Customer("Aaron", "Ang", "aa@gmail.com");
        c1.addAccount(new Account("Current", 6000));
        Customer c2 = new Customer("Aaron", "Ong", "ao@gmail.com");
        c2.addAccount(new Account("Savings", 100));
        Customer c3 = new Customer("Aaron", "Tan", "at@gmail.com");
        c3.addAccount(new Account("Savings", 22100));
        Customer c4 = new Customer("Aaron", "Lim", "al@gmail.com");
        c4.addAccount(new Account("Savings", 35100));
        Customer c5 = new Customer("Ben", "Lim", "bl@gmail.com");
        c5.addAccount(new Account("Savings", 1100));
        Customer c6 = new Customer("Charlie", "Lim", "cl@gmail.com");
        c3.addAccount(new Account("Current", 2200));
        Customer[] cAll = {c1, c2, c3, c4, c5, c6};
        for (Customer c : cAll) {
            repo.create(c);
        }
        flushAndClear();
        assertThat( repo.getRichCustomers( 10000 ) ).hasSize( 2 );
    }

    @Test
    void shouldGetRichCustomersBasedOnTotalBalance() {
        Customer c1 = new Customer("Aaron", "Ang", "aa@gmail.com");
        c1.addAccount(new Account("Savings", 5100));
        c1.addAccount(new Account("Current", 6000));
        Customer c2 = new Customer("Aaron", "Ong", "ao@gmail.com");
        c2.addAccount(new Account("Savings", 100));
        Customer c3 = new Customer("Aaron", "Tan", "at@gmail.com");
        c3.addAccount(new Account("Savings", 22100));
        c3.addAccount(new Account("Current", 100));
        Customer c4 = new Customer("Aaron", "Lim", "al@gmail.com");
        c4.addAccount(new Account("Savings", 35100));
        Customer c5 = new Customer("Ben", "Lim", "bl@gmail.com");
        c5.addAccount(new Account("Savings", 1100));
        Customer c6 = new Customer("Charlie", "Lim", "cl@gmail.com");
        c3.addAccount(new Account("Current", 2200));
        c6.addAccount(new Account("Savings", 2100));
        Customer[] cAll = {c1, c2, c3, c4, c5, c6};
        for (Customer c : cAll) {
            repo.create(c);
        }
        flushAndClear();
        assertThat( repo.getRichCustomers( 10000 ) ).hasSize( 3 );
    }

    @Test
    void shouldSortByCustomerWealth() {
        Customer c1 = new Customer("Aaron", "Ang", "aa@gmail.com");
        c1.addAccount(new Account("Savings", 5100));
        c1.addAccount(new Account("Current", 6000));
        Customer c2 = new Customer("Aaron", "Ong", "ao@gmail.com");
        c2.addAccount(new Account("Savings", 100));
        Customer c3 = new Customer("Aaron", "Tan", "at@gmail.com");
        c3.addAccount(new Account("Savings", 22100));
        c3.addAccount(new Account("Current", 100));
        Customer c4 = new Customer("Aaron", "Lim", "al@gmail.com");
        c4.addAccount(new Account("Savings", 35100));
        Customer c5 = new Customer("Ben", "Lim", "bl@gmail.com");
        c5.addAccount(new Account("Savings", 1100));
        Customer c6 = new Customer("Charlie", "Lim", "cl@gmail.com");
        c3.addAccount(new Account("Current", 2200));
        c6.addAccount(new Account("Savings", 2100));
        Customer[] cAll = {c1, c2, c3, c4, c5, c6};
        for (Customer c : cAll) {
            repo.create(c);
        }
        flushAndClear();
        List<Customer> customers = repo.sortByWealth();
        assertThat( customers.get( 0 ).getEmail() ).isEqualTo("al@gmail.com");
        assertThat( customers.get( 1 ).getEmail() ).isEqualTo("at@gmail.com");
        assertThat( customers.get( 2 ).getEmail() ).isEqualTo("aa@gmail.com");
        assertThat( customers.get( 3 ).getEmail() ).isEqualTo("cl@gmail.com");
        assertThat( customers.get( 4 ).getEmail() ).isEqualTo("bl@gmail.com");
        assertThat( customers.get( 5 ).getEmail() ).isEqualTo("ao@gmail.com");
    }

    @Test
    void shouldGetCustomerAddress() {
        Customer c = new Customer("Aaron", "Ang", "aa@gmail.com");
        Address a = new Address("sesame street","city hall", 123456);
        c.setAddress( a );
        repo.create( c );
        flushAndClear();
        Customer c2 = repo.findBy("lastName","Ang").get( 0 );
        assertThat(c2.getAddress()).isEqualToComparingFieldByField(a);
    }

    @Test
    void shouldUpdateCustomerAddress() {
        Customer c = new Customer("Aaron", "Ang", "aa@gmail.com");
        Address a = new Address("sesame street","city hall", 123456);
        c.setAddress( a );
        repo.create( c );
        flushAndClear();
        Customer c2 = repo.findBy("lastName","Ang").get( 0 );
        Address a2 = new Address("Bourke Street", "Melbourne", 654321);
        c2.setAddress(a2);
        repo.update(c2);
        flushAndClear();
        Customer c3 = repo.findBy("lastName","Ang").get( 0 );
        assertThat(c3.getAddress()).isEqualToComparingFieldByField(a2);
    }
}
