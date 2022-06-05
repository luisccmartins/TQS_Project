package com.uatqs.expressdelivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.uatqs.expressdelivery.model.Admin;
import com.uatqs.expressdelivery.repository.AdminRepository;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ExpressDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpressDeliveryApplication.class, args);
	}


}
