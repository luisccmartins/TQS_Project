package com.uatqs.drugdrop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="order_products")
@IdClass(OrderProductsId.class)
public class OrderProducts implements Serializable {
    
    @Id
    private long order_id;
    @Id
    @Column(name="drug_id")
    private long drug_id;

    public OrderProducts(long order_id, long drug_id) {
        this.order_id = order_id;
        this.drug_id = drug_id;
    }

    public OrderProducts(){}


    public long getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public long getDrug_id() {
        return this.drug_id;
    }

    public void setDrug_id(long drug_id) {
        this.drug_id = drug_id;
    }


}
