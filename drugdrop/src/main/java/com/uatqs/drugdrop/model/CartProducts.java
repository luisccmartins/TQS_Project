package com.uatqs.drugdrop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart_products")
public class CartProducts {

    @Id
    @Column(name="id_cart")
    private int id_cart;

    @Id
    @Column(name="drug_id")
    private int drug_id;

    @Column(name="quantity_products")
    private int quantity_products;

    public int getId_cart() {
        return id_cart;
    }

    public void setId_cart(int id_cart) {
        this.id_cart = id_cart;
    }

    public int getDrug_id() {
        return drug_id;
    }

    public void setDrug_id(int drug_id) {
        this.drug_id = drug_id;
    }

    public int getQuantity_products() {
        return quantity_products;
    }

    public void setQuantity_products(int quantity_products) {
        this.quantity_products = quantity_products;
    }

    
}
