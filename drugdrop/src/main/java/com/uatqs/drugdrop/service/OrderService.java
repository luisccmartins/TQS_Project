package com.uatqs.drugdrop.service;

import java.util.List;

import com.uatqs.drugdrop.model.Order;
import com.uatqs.drugdrop.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public long total() { return orderRepository.count();}

    /*public List<Order> getOrderByUser_Id(int user_id){
        return orderRepository.findByUser_Id(user_id);
    }*/
    
}
