package com.uatqs.drugdrop.model;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "state")
    private String state;

    @Column(name = "store_id")
    private double store_id;

    public Order(String description, double price, String state) {
        this.state = state;
        this.description = description;
        this.price = price;
    }

    public Order(){

    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getStore_id() {
        return store_id;
    }

    public void setStore_id(double store_id) {
        this.store_id = store_id;
    }

    

}