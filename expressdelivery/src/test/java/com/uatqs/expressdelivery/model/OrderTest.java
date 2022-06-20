package com.uatqs.expressdelivery.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    
    private Order order;

    @BeforeEach
    public void setUp(){
        order = new Order(1, "3 caixas de Paracetamol", 966555444, "Universidade de Aveiro");
    }

    @Test
    public void findOrderById(){
        assertEquals(1, order.getId());
    }

    @Test
    public void findOrderByDescription(){
        assertEquals("3 caixas de Paracetamol", order.getDescription());
    }

    @Test
    public void findOrderByPhoneNumber(){
        assertEquals(966555444, order.getClient_phone_number());
    }

    @Test
    public void findOrderByDestination(){
        assertEquals("Universidade de Aveiro", order.getDestination());
    }
}
