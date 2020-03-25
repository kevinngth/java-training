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

    void create(Customer c) {
        em.persist(c);
    }

    public List<Customer> findAll() {
        Query query = em.createQuery("SELECT c FROM Customer c");
        List<Customer> result = query.getResultList();
        return result;
    }

    public List<Customer> findBy(String attributeName, String attributeValue) {
        String queryString = "FROM Customer WHERE " + attributeName + "= :attributeValue";
        Query query = em.createQuery( queryString );
        query.setParameter("attributeValue", attributeValue);
        return (List<Customer>) query.getResultList();
    }


    public void update(Customer c) {
        em.merge(c);
    }

    public void delete(Customer c) {
        em.remove( c );
    }

    public List<Customer> getRichCustomers(long threshold) {
        Query q = em.createQuery("SELECT c FROM Customer c JOIN c.accounts a GROUP BY c.id HAVING SUM(a.balance) > :threshold ");
        q.setParameter("threshold", threshold);
        List<Customer> result = q.getResultList();
        return result;
    }

    public List<Customer> sortByWealth() {
        Query q = em.createQuery("SELECT c FROM Customer c JOIN c.accounts a GROUP BY c.id ORDER BY SUM(a.balance) DESC");
        List<Customer> result = q.getResultList();
        return result;
    }
}