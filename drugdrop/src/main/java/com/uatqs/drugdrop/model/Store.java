package com.uatqs.drugdrop.model;

import javax.persistence.*;

@Entity
@Table(name = "Stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name")
    private String name;

    @OneToOne
    private Address address;

    public Store(String name, Address address){
        this.name = name;
        this.address = address;
    }

    public Store(){

    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    
}
