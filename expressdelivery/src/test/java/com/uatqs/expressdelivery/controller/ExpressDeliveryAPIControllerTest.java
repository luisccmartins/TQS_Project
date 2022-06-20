package com.uatqs.expressdelivery.controller;

import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.uatqs.expressdelivery.model.Rider;
import com.uatqs.expressdelivery.service.ExpressDeliveryService;

@WebMvcTest
public class ExpressDeliveryAPIControllerTest {

    @MockBean
    ExpressDeliveryService service;
    
    @Autowired
    MockMvc mvc;

    Map<String, Object> loginRequest;
    Map<String, Object> signUpRequest;

    private Rider rider;

    @BeforeEach
    public void setUp() {
        loginRequest = new HashMap<>();
        loginRequest.put("email","pedroporrito@expressdelivery.com");
        loginRequest.put("password","pedroporritos");

        signUpRequest = new HashMap<>();
        signUpRequest.put("email","joaofeliz@expressdelivery.com");
        signUpRequest.put("password","joaofeliz");
        signUpRequest.put("firstname","João");
        signUpRequest.put("lastname","Félix");
        signUpRequest.put("telephone","930921312");

        rider = new Rider("Pedro Porro", 22, 960999111, "pedroporrito@expressdelivery.com", false);
    }

    
}
