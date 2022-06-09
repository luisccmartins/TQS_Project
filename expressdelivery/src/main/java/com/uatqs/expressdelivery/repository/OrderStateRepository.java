package com.uatqs.expressdelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uatqs.expressdelivery.model.OrderState;

@Repository
public interface OrderStateRepository extends JpaRepository<OrderState,Integer> {
    List<OrderState> findAllByState();
    OrderState findOrderStateByOrderDescription(Integer order, String description);
}
