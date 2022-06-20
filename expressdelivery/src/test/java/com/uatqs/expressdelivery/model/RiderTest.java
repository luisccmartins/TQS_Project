package com.uatqs.expressdelivery.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class RiderTest {
    
    private Rider rider1, rider2;

    @BeforeEach
    public void setUp(){
        rider1 = new Rider("Pedro Porro", 22, 960970980, "pedroporro@expressdelivery.com", true);
        rider2 = new Rider("João Félix", 21, 960970910, "feliz@expressdelivery.com", false);
    }

    @Test
    public void testFindRider(){
        assertEquals("pedroporro@expressdelivery.com", rider1.getEmail());
        assertEquals(false, rider2.isAvailable());
    }

    @Test
    public void testFindRiderByName(){
        assertEquals("Pedro Porro", rider1.getName());
        assertEquals("João Félix", rider2.getName());
    }

    @Test
    public void testFindRiderByAge(){
        assertEquals(22, rider1.getAge());
        assertEquals(21, rider2.getAge());
    }

    @Test
    public void testFindRiderByPhoneNumber(){
        assertEquals(960970980, rider1.getPhone_number());
        assertEquals(960970910, rider2.getPhone_number());
    }
}
