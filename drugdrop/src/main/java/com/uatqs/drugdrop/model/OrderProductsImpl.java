package com.uatqs.drugdrop.model;

import java.util.Date;

public class OrderProductsImpl {

    private int order_id;

    private Drug drug;

    private int quantity_products;

    private Date order_update;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public Date getOrder_update() {
        return order_update;
    }

    public void setOrder_update(Date order_update) {
        this.order_update = order_update;
    }

    
}
