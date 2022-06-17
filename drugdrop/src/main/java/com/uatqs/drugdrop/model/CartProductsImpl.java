package com.uatqs.drugdrop.model;

public class CartProductsImpl {

    private int id_cart;

    private Drug drug;

    private int quantity_products;

    public int getId_cart() {
        return id_cart;
    }

    public void setId_cart(int id_cart) {
        this.id_cart = id_cart;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public int getQuantity_products() {
        return quantity_products;
    }

    public void setQuantity_products(int quantity_products) {
        this.quantity_products = quantity_products;
    }

}
