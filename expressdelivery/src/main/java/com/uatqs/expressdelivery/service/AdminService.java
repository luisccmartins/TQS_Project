package com.uatqs.expressdelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.uatqs.expressdelivery.model.Admin;
import com.uatqs.expressdelivery.repository.AdminRepository;

@Service
public class AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
   }

    public long total() { return adminRepository.count();}

    public Admin getAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }
}
