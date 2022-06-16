package com.uatqs.drugdrop.model;

import java.io.Serializable;

public class OrderProductsId implements Serializable{

    private long order_id;
    private long drug_id;

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
