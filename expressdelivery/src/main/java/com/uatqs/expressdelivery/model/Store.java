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

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "store")
    private Set<Order> orders;

    public Store(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
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
