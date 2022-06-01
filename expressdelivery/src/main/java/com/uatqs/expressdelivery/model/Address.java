package com.uatqs.expressdelivery.model;

import javax.persistence.*;

@Entity
public class Address {

    private String street;
    private String postalCode;
    private String city;
    private String country;

    @OneToOne(mappedBy = "address")
    private Store store;

    @OneToOne(mappedBy = "address")
    private Order order;

    public Address(String street, String postalCode, String city, String country, Store store, Order order) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.store = store;
        this.order = order;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    
}
