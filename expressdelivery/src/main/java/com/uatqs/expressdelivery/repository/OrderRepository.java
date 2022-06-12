package com.uatqs.expressdelivery.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import com.uatqs.expressdelivery.model.Order;
import com.uatqs.expressdelivery.model.Rider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findById(int ind);
    List<Order> findByState(String state);
    List<Order> findByStateAndRider(String state, long rider_id);
    Optional<Order> findByRider(Rider rider);
    List<Order> findByStateAndTimestampBetween(String state, Timestamp begin, Timestamp end);
    Order findByRating(long rating);
}
