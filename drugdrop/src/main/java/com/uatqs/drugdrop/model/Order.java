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

    @Column(name = "user_id")
    private int user_id;


    public Order(String description, double price, String state) {
        this.state = state;
        this.description = description;
        this.price = price;
    }

    public Order(String description, double price, String state, int user_id) {
        this.state = state;
        this.description = description;
        this.price = price;
        this.user_id = user_id;
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

    public double getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    

}