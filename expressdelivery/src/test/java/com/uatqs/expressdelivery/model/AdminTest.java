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
    public void testFindAdminByEmail(){
        assertEquals("admin@expressdelivery.com", admin.getEmail());
    }

    @Test
    public void testFindAdminByName(){
        assertEquals("Admin", admin.getName());
    }

    @Test
    public void testFindAdminByPassword(){
        assertEquals("admin", admin.getEmail());
    }

}
