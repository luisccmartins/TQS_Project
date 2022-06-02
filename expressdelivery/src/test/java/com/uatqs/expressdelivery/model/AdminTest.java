package com.uatqs.expressdelivery.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class AdminTest {
    
    private Admin admin;

    @BeforeEach
    public void setUp(){
        admin = new Admin("Admin", "admin@expressdelivery.com", "admin");
    }

    @Test
    public void testFindAdmin(){
        assertEquals("admin@expressdelivery.com", admin.getEmail());
    }
}
