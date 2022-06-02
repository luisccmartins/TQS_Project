package com.uatqs.expressdelivery.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class RiderTest {
    
    private Rider rider1, rider2;

    @BeforeEach
    public void setUp(){
        rider1 = new Rider("Pedro", "Porro", 960970980, "pedroporro@expressdelivery.com", true);
        rider2 = new Rider("João", "Félix", 960970910, "feliz@expressdelivery.com", false);
    }

    @Test
    public void testFindRider(){
        assertEquals("pedroporro@expressdelivery.com", rider1.getEmail());
        assertEquals(false, rider2.isAvailable());
    }
}
