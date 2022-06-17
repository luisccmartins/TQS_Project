package com.uatqs.expressdelivery.repository;

import com.uatqs.expressdelivery.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStateRepository extends JpaRepository<Order, Long> {

}
