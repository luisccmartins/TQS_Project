package com.uatqs.expressdelivery.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Rider {
    
    
    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "phone_number")
    private int phone_number;

    @Column(name = "email")
    private String email;

    @Column(name = "available")
    private boolean available;

    @Column(name = "ratings")
    @ElementCollection
    private List<Integer> ratings;

    @OneToMany(mappedBy = "rider")
    @JsonIgnore
    private List<Order> orders;
    
    public Rider(String first_name, String last_name, int phone_number, String email, boolean available) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.available = available;
    }

    public Rider(String first_name, String last_name, int phone_number, String email, boolean available,
            List<Integer> ratings, List<Order> orders) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.available = available;
        this.ratings = ratings;
        this.orders = orders;
    }

    public String getFirst_name() {
            return first_name;
        }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Integer> getRatings() {
        return ratings;
    }


    public void setRatings(List<Integer> ratings) {
        this.ratings = ratings;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
