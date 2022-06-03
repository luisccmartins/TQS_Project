package com.uatqs.expressdelivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.uatqs.expressdelivery.model.Admin;
import com.uatqs.expressdelivery.repository.AdminRepository;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ExpressDeliveryApplication {

	@Autowired
	private static AdminRepository adminRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExpressDeliveryApplication.class, args);
	}

	public void run(String...args) throws Exception {
		Admin admin = new Admin("Admin", "admin@expressdelivery.com", "admin");
		adminRepository.save(admin);
		//Instrucoes instrucao = new Instrucoes(1, employee, "Adicionar jogo da Liga Portuguesa - Porto x Boavista", "24 jan 2022");
		//instrucoesRepository.save(instrucao);
	}

}
