package com.uatqs.expressdelivery.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Rider")
public class Rider {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private int phone_number;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    @Column(name = "available")
    private boolean available;

    @Column(name = "ratings")
    @ElementCollection
    private List<Integer> ratings = new ArrayList<Integer>();

    @Column(name = "ratingsAverage")
    public Double ratingsAverage;

    @OneToMany(mappedBy = "rider",cascade = CascadeType.MERGE )
    @JsonIgnore
    private List<Order> orders;
    
    public Rider(String name, int age, int phone_number, String email, boolean available) {
        this.age = age;
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.available = available;
    }


    public Rider(String name, int phone_number, String email, boolean available,
            List<Integer> ratings, List<Order> orders) {
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.available = available;
        this.ratings = ratings;
        this.orders = orders;
    }

    

    public Rider() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public Order getOrders() {
        return orders.get(8);
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


    public void setRatingsAverage(Double ratingsAverage) {
        this.ratingsAverage = ratingsAverage;
    }


}
