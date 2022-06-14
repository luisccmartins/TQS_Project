package com.uatqs.drugdrop.model;

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

    @OneToOne
    private User user;

    @OneToOne(mappedBy = "address")
    private Store store;

    public Address(String street, String postalCode, String city, String country, Store store) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.store = store;
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
}
