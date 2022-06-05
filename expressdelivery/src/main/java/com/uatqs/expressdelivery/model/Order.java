package com.uatqs.expressdelivery.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Null;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "state")
    private OrderState state;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Rider rider;

    @ManyToOne
    private Store store;

    @OneToOne
    private Address address;

    @CreationTimestamp
    private Date date;

    @Column(name = "description")
    private String description;

    @Column(name = "client_phone_number")
    private int client_phone_number;

    public Order(int id, OrderState state, Rider rider, Store store, Address address, Date date, String description,
            int client_phone_number) {
        this.id = id;
        this.state = state;
        this.rider = rider;
        this.store = store;
        this.address = address;
        this.date = date;
        this.description = description;
        this.client_phone_number = client_phone_number;
    }

    

    public Order() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
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

    public void setStore(Store store) {
        this.store = store;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    

}
