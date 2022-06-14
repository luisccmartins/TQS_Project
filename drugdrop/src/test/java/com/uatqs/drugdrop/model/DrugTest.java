package com.uatqs.drugdrop.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class DrugTest {

    private Drug drug;

    @BeforeEach
    public void setUp(){
        drug = new Drug("Paracetamol", "O fármaco necessário para a sua época de exames", 6.99);
    }

    @Test
    public void findDrugName(){
        assertEquals("Paracetamol", drug.getName());
    }

    @Test
    public void findDrugDescription(){
        assertEquals("O fármaco necessário para a sua época de exames", drug.getDescription());
    }

    @Test
    public void findDrugPrice(){
        assertEquals(6.99, drug.getPrice());
    }

}
