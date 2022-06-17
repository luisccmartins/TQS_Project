package com.uatqs.drugdrop.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.uatqs.drugdrop.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    //List<Order> findByUser_Id(int user_id);
    
}
