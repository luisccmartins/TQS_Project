package com.uatqs.expressdelivery.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "state")
    private String state;

    @JoinColumn(name = "rider")
    @ManyToOne(cascade = CascadeType.ALL)
    private Rider rider;

    @JoinColumn(name = "store")
    @ManyToOne(cascade = CascadeType.ALL)
    private Store store;

    @Column(name="store_id")
    private Integer store_id;

    @JoinColumn(name = "address")
    @OneToOne(cascade = CascadeType.ALL , orphanRemoval = true, fetch = FetchType.LAZY)
    private Address address;

    @CreationTimestamp
    private Date date;

    @Column(name = "description")
    private String description;

    @Column(name = "client_phone_number")
    private int client_phone_number;

    @Column(name = "rating")
    private int rating;

    @Column(name="timestamp")
    private Timestamp timestamp;

    @Column(name = "destination")
    private String destination;

    public Order(int id, String state, Rider rider, Store store, Address address, Date date, String description,
            int client_phone_number, int rating, Timestamp timestamp) {
        this.id = id;
        this.state = state;
        this.rider = rider;
        this.store = store;
        this.address = address;
        this.date = date;
        this.description = description;
        this.client_phone_number = client_phone_number;
        this.rating = rating;
        this.timestamp = timestamp;
    }

    
    public Order(String state, Store store, Address address, int client_phone_number, Timestamp timestamp) {
        this.state = state;
        this.store = store;
        this.address = address;
        this.client_phone_number = client_phone_number;
        this.timestamp = timestamp;
    }

    


    public Order(int store_id, String description, int client_phone_number, String destination) {
        this.store_id = store_id;
        this.description = description;
        this.client_phone_number = client_phone_number;
        this.destination = destination;
    }


    public Order() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Store getStore() {
        return store;
    }

    public String getStoreName(){
        return store.getName();
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAddressName(){
        return address.getStreet();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getClient_phone_number() {
        return client_phone_number;
    }

    public void setClient_phone_number(int client_phone_number) {
        this.client_phone_number = client_phone_number;
    }



    public int getRating() {
        return rating;
    }



    public void setRating(int rating) {
        this.rating = rating;
    }



    public Timestamp getTimestamp() {
        return timestamp;
    }



    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }


    public Integer getStore_id() {
        return store_id;
    }


    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }


    public String getDestination() {
        return destination;
    }


    public void setDestination(String destination) {
        this.destination = destination;
    }

    

}
