package com.uatqs.expressdelivery.repository;

import java.util.Optional;

import com.uatqs.expressdelivery.model.Order;
import com.uatqs.expressdelivery.model.OrderState;
import com.uatqs.expressdelivery.model.Rider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(int ind);
    Optional<Order> findByState(OrderState state);
    Optional<Order> findByRider(Rider tider);
}
