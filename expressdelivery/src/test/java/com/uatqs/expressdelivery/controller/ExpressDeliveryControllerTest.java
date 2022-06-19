package com.uatqs.expressdelivery.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.uatqs.expressdelivery.model.Admin;
import com.uatqs.expressdelivery.repository.RiderRepository;
import com.uatqs.expressdelivery.service.AdminService;
import com.uatqs.expressdelivery.service.ExpressDeliveryService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ExpressDeliveryController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ExpressDeliveryControllerTest {
    
    @MockBean
    private ExpressDeliveryService expressDeliveryService;

    @MockBean
    private AdminService adminService;

    @MockBean
    private RiderRepository riderRepository;

    @Autowired
    private MockMvc mvc;

    private Admin admin;

    @BeforeEach
    public void setUp(){

        String name = "Admin 1";
        String email = "admin@expressdelivery.com";
        String password = "admin";
        admin = new Admin(name, email, password);

    }

    @Test
    public void loginSuccessfulAdmin() throws Exception {

        Mockito.when(expressDeliveryService.getAdminByEmail(admin.getEmail())).thenReturn(admin);
        //when(expressDeliveryService.getAdminByEmail("wrong_email")).thenReturn(null);

        mvc.perform(post("/")
                .param("email", admin.getEmail())
                .param("password", admin.getPassword()))
                .andExpect(status().isOk())
                .andExpect(view().name("login2"));
    }

    @Test
    public void loginInsuccessful() throws Exception {
        Admin admin = new Admin("Admin 10", "wrongadmin@expressdelivery.com", "wrong");

        Mockito.when(expressDeliveryService.getAdminByEmail("wrongadmin@expressdelivery.com")).thenReturn(null);

        mvc.perform(post("/")
                .param("email", admin.getEmail())
                .param("password", admin.getPassword()))
                .andExpect(status().isOk())
                .andExpect(view().name("login2"));


    }
}
