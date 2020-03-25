package com.customer.accessingdatajpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
public abstract class Customer {

    @OneToMany( cascade = CascadeType.ALL )
    @JoinColumn( name = "customer_id" )
    private List<Account> accounts = new ArrayList<>();

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "postalCode", column = @Column),
            @AttributeOverride(name = "street", column = @Column),
            @AttributeOverride(name = "city", column = @Column)
    })
    private Address address;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String username;
    private String email;

    protected Customer() {}

    public Customer(String username, String email) {
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s']",
                id, username);
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
