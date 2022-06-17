package com.uatqs.drugdrop.service;

import java.util.List;

import com.uatqs.drugdrop.model.Drug;
import com.uatqs.drugdrop.model.Order;
import com.uatqs.drugdrop.model.OrderProducts;
import com.uatqs.drugdrop.repository.OrderProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductsService {

    @Autowired
    private OrderProductsRepository orderProductsRepository;

    @Autowired
    public OrderProductsService(OrderProductsRepository orderProductsRepository){
        this.orderProductsRepository = orderProductsRepository;
    }

    public long total() { return orderProductsRepository.count();}

}