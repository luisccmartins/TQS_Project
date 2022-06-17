package com.uatqs.drugdrop.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class OrderTest {

    private Order order;

    @BeforeEach
    public void setUp(){
        order = new Order("3 caixas de Paracetamol", 19.60, "COMPLETED");
    }

    @Test
    public void findOrderDescription(){
        assertEquals("3 caixas de Paracetamol", order.getDescription());
    }

    @Test
    public void findDrugPrice(){
        assertEquals(19.60, order.getPrice());
    }

    @Test
    public void fingDrugState(){
        assertEquals("COMPLETED", order.getState());
    }

}
