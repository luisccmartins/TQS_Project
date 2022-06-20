package com.uatqs.expressdelivery.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.uatqs.expressdelivery.model.Admin;
import com.uatqs.expressdelivery.repository.AdminRepository;
import com.uatqs.expressdelivery.service.ExpressDeliveryService;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class AdminServiceUnitTest {

    @InjectMocks
    private ExpressDeliveryService service;
    
    @Mock( lenient = true)
    private AdminRepository adminRepository;

    @BeforeEach
    public void setUp() {
        Admin admin = new Admin("Admin 1", "admin@expressdelivery.com", "admin");
        Mockito.when(adminRepository.findByEmail(admin.getEmail())).thenReturn(admin);
        Mockito.when(adminRepository.findByEmail("wrongadmin@expressdelivery.com")).thenReturn(null);
    }

    @Test
    public void getAdminByCorrectEmail() {
        Admin correctAdmin = service.getAdminByEmail("admin@expressdelivery.com");
        assertThat(correctAdmin.getEmail()).isEqualTo("admin@expressdelivery.com");
    }
}
