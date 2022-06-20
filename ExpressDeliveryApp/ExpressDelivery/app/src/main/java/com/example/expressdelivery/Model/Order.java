package com.example.expressdelivery.Model;

import java.sql.Timestamp;
import java.util.Date;

public class Order {
    private Integer id;

    private Integer store_id;

    private String description;

    private int client_phone_number;

    private String destination;

    private String state;


    public Order(int id, int store_id, String description, int client_phone_number, String destination) {
        this.id = id;
        this.store_id = store_id;
        this.description = description;
        this.client_phone_number = client_phone_number;
        this.destination = destination;
        this.state = "CREATED";
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

    /*
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
    }*/

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


    /*
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
    */

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
