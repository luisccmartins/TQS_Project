package com.uatqs.drugdrop.model;

import java.util.Iterator;
import java.util.List;

public class CartImpl implements Iterable<CartProductsImpl> {

    private int id_cart;

    private int user_id_cart;

    private List<CartProductsImpl> cart_products;

    private Double price;

    @Override
    public Iterator<CartProductsImpl> iterator() {
        return cart_products.iterator();
    }

    public int getId_cart() {
        return id_cart;
    }

    public void setId_cart(int id_cart) {
        this.id_cart = id_cart;
    }

    public int getUser_id_cart() {
        return user_id_cart;
    }

    public void setUser_id_cart(int user_id_cart) {
        this.user_id_cart = user_id_cart;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    


}
