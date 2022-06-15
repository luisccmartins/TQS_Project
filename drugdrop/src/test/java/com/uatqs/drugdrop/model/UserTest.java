package com.uatqs.drugdrop.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class UserTest {

    private User user;
    private Address address;

    @BeforeEach
    public void setUp(){
        address = new Address("Rua da Alameda", "3080", "Aveiro", "Portugal");
        user = new User("ProfJam", "mario@drugdrop.pt", "aguaDeCoco");
    }

    @Test
    public void findUserName(){
        assertEquals("ProfJam", user.getName());
    }

    @Test
    public void findUserMail(){
        assertEquals("mario@drugdrop.pt", user.getEmail());
    }

    @Test
    public void findUserPassword(){
        assertEquals("aguaDeCoco", user.getPassword());
    }

    @Test
    public void findUserAddress(){
        assertEquals("Rua da Alameda", address.getStreet());
        assertEquals("3080", address.getPostalCode());
        assertEquals("Aveiro", address.getCity());
        assertEquals("Portugal", address.getCountry());

    }
}
