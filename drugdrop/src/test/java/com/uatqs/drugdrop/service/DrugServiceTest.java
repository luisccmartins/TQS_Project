package com.uatqs.drugdrop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.uatqs.drugdrop.model.Drug;
import com.uatqs.drugdrop.repository.DrugRepository;

import org.junit.jupiter.api.BeforeAll;

@ExtendWith(MockitoExtension.class)
public class DrugServiceTest {

    @InjectMocks
    private DrugService drugService;
    
    @Mock(lenient = true)
    private DrugRepository drugRepository;

    private static Drug drug;


    @BeforeAll
    public static void setUp() {
        drug = new Drug();
        drug.setId(10);
        drug.setName("Ilvico");
        drug.setDescription("Cura depressões pré-exames");
        drug.setPrice(21.99);
    }

    @Test
    public void getDrugById() {
        Mockito.when(drugRepository.findById(drug.getId())).thenReturn(drug);
        Drug drugs = drugService.getDrugById(drug.getId());

        assertEquals("Ilvico", drugs.getName());
        assertEquals(10, drugs.getId());

    }

    @Test
    public void getDrugByName() {
        Mockito.when(drugService.getDrugByName(drug.getName())).thenReturn(drug);

        assertEquals("Ilvico", drug.getName());
        assertEquals(10, drug.getId());
    }

    @Test
    public void getErrorWhenInvalidId() {
        Mockito.when(drugRepository.findById(101)).thenReturn(null);
        Drug result = drugService.getDrugById(101);

        assertEquals(null, result);
    }

}
