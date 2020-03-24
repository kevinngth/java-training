package com.customer.accessingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CustomerRepository {

    @Autowired
    EntityManager em;


    void create(String firstName, String lastName, String email) {
        Customer c = new Customer(firstName, lastName, email);
        em.persist(c);
        em.flush();
        em.clear();
    }

    List<Customer> all() {
        Query query = em.createQuery("SELECT c FROM Customer c");
        List<Customer> result = query.getResultList();
        em.flush();
        em.clear();
        return result;
    }

    List<Customer> findByLastName(String lastName) {
        Query query = em.createQuery("FROM Customer WHERE lastName=:name");
        query.setParameter("name", lastName);
        return (List<Customer>) query.getResultList();
    }


    public void update(Customer c2) {
        Query query = em.createQuery("UPDATE Customer SET firstName = :fn, lastName = :ln, email = :email WHERE id = :id");
        query.setParameter("id", c2.getId());
        query.setParameter("fn", c2.getFirstName());
        query.setParameter("ln", c2.getLastName());
        query.setParameter("email", c2.getEmail());
        query.executeUpdate();
        em.flush();
        em.clear();
    }

    public void delete(Customer c) {
        Query query = em.createQuery("DELETE FROM Customer c WHERE c.id = :id");
        query.setParameter("id", c.getId()).executeUpdate();
        em.flush();
        em.clear();
    }
}