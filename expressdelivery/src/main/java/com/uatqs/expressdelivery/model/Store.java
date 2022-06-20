package com.uatqs.expressdelivery.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Store")
public class Store {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL , orphanRemoval = true, fetch = FetchType.LAZY)
    private Address address;

    //@OneToMany(mappedBy = "store", cascade = CascadeType.ALL , orphanRemoval = true, fetch = FetchType.LAZY)
    //private Set<Order> orders;

    public Store(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Store(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Store() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    
}
