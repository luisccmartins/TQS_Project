package com.uatqs.expressdelivery.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.MySQLContainer;

import com.uatqs.expressdelivery.model.Admin;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@DataJpaTest
public class AdminRepositoryTest {
    
    private Admin admin1, admin2;

    @Autowired
    private AdminRepository adminRepository;

    @Container
    public static MySQLContainer container = new MySQLContainer("mysql:8.0.29")
            .withUsername("expressdelivery")
            .withPassword("expressdelivery")
            .withDatabaseName("expressdelivery");

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
    }

    @BeforeEach
    public void setUp(){
        admin1 = new Admin("admin", "admin@expressdelivery.com", "admin");
        admin2 = new Admin("admin", "admin2@expressdelivery.com", "admin2");
        adminRepository.save(admin1);
        adminRepository.save(admin2);
    }

    @Test
    public void testFindAdmin(){
        List<Admin> admins = adminRepository.findByName("admin");
        assertEquals("admin@expressdelivery.com", admins.get(0).getEmail());
        assertEquals("admin2@expressdelivery.com", admins.get(1).getEmail());
        assertThat(admins).hasSize(2);
    }

    @Test
    public void testInvalidAdmin(){
        List<Admin> admins = adminRepository.findByName("administrador");
        assertThat( admins ).isEmpty();
    }

    @AfterEach
    public void cleanUp() {
        adminRepository.deleteAll();
    }
}
