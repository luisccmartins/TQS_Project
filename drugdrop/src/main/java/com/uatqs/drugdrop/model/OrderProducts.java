package com.uatqs.drugdrop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_products")
public class OrderProducts implements Serializable {
    
    @Id
    private int order_id;
    @Id
    @Column(name="drug_id")
    private int drug_id;

    @Column(name="quantity_products")
    private int quantity_products;
}
