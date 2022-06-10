package com.uatqs.expressdelivery.repository;

import java.util.List;
import java.util.Optional;

import com.uatqs.expressdelivery.model.Order;
import com.uatqs.expressdelivery.model.Rider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(int ind);
    List<Order> findByState(String state);
    Optional<Order> findByRider(Rider tider);
}
