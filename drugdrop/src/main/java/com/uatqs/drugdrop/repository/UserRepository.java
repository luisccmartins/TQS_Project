package com.uatqs.drugdrop.repository;

import java.util.List;

import com.uatqs.drugdrop.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(Integer id);
    List<User> findByName(String name);
    User findByEmail(String email);
}
