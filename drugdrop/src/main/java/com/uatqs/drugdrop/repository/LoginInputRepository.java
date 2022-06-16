package com.uatqs.drugdrop.repository;

import org.springframework.stereotype.Repository;

import com.uatqs.drugdrop.model.LoginInput;
import com.uatqs.drugdrop.model.Store;
import com.uatqs.drugdrop.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LoginInputRepository extends JpaRepository<LoginInput, Long> {
    LoginInput findByEmail(String email);
}
