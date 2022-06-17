package com.uatqs.drugdrop.repository;

import java.util.List;
import java.util.Optional;

import com.uatqs.drugdrop.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(Integer id);
    User findByName(String name);
    User findByEmail(String email);
    boolean existsByEmail(String email);
}
