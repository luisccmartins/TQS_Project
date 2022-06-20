package com.uatqs.expressdelivery.model;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String postalCode;
    private String city;
    private String country;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL , orphanRemoval = true, fetch = FetchType.LAZY)
    private Store store;

    //@OneToOne(mappedBy = "address", cascade = CascadeType.ALL , orphanRemoval = true, fetch = FetchType.LAZY)
    //private Order order;

    public Address(String street, String postalCode, String city, String country, Store store, Order order) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.store = store;
        //this.order = order;
    }

    public Address(String street, String postalCode, String city, String country) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }


    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    /*public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }*/
    
    
}
