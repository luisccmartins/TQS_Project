package com.uatqs.expressdelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uatqs.expressdelivery.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    List<Admin> findByName(String name);
    Admin findByEmail(String email);
}
