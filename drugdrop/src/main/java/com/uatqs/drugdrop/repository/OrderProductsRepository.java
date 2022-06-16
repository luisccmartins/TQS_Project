package com.uatqs.drugdrop.repository;

import java.util.List;

import com.uatqs.drugdrop.model.Drug;
import com.uatqs.drugdrop.model.Order;
import com.uatqs.drugdrop.model.OrderProducts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductsRepository extends JpaRepository<OrderProducts, Long> {
    
}