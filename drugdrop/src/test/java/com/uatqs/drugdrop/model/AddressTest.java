package com.uatqs.drugdrop.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class AddressTest {
    
    private Address address;

    @BeforeEach
    public void setUp(){
        address = new Address("Rua da Alameda", "3080", "Aveiro", "Portugal");
    }

    @Test
    public void findStreetAddress(){
        assertEquals("Rua da Alameda", address.getStreet());
    }

    @Test
    public void findPostalCode(){
        assertEquals("3080", address.getPostalCode());
    }

    @Test
    public void findCity(){
        assertEquals("Aveiro", address.getCity());
    }

    @Test
    public void findCountry(){
        assertEquals("Portugal", address.getCountry());
    }

}
