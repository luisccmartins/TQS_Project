package com.example.expressdelivery.Model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class OrderTest {

    private Order order;

    @Test
    public void getId() {
        order = new Order(1,1,"Descricao",987654321,"Destination");
        assertEquals(1,order.getId());
    }

    @Test
    public void getState() {
        order = new Order(1,1,"Descricao",987654321,"Destination");
        assertEquals("CREATED",order.getState());
    }

    @Test
    public void setState() {
        order = new Order(1,1,"Descricao",987654321,"Destination");
        order.setState("PICKEDUP");
        assertEquals("PICKEDUP",order.getState());
    }

    @Test
    public void getDescription() {
        order = new Order(1,1,"Descricao",987654321,"Destination");
        assertEquals("Descricao",order.getDescription());
    }

    @Test
    public void getClient_phone_number() {
        order = new Order(1,1,"Descricao",987654321,"Destination");
        assertEquals(987654321,order.getClient_phone_number());
    }

    @Test
    public void getDestination() {
        order = new Order(1,1,"Descricao",987654321,"Destination");
        assertEquals("Destination",order.getDestination());
    }
}