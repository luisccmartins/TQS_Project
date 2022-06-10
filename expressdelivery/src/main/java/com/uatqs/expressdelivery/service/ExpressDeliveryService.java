package com.uatqs.expressdelivery.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.uatqs.expressdelivery.model.Admin;
import com.uatqs.expressdelivery.model.Order;
import com.uatqs.expressdelivery.model.Rider;
import com.uatqs.expressdelivery.repository.AdminRepository;
import com.uatqs.expressdelivery.repository.OrderRepository;
import com.uatqs.expressdelivery.repository.RiderRepository;

@Service
public class ExpressDeliveryService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RiderRepository riderRepository;


    @Autowired
    public ExpressDeliveryService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
   }

    public long total() { return adminRepository.count();}

    public Admin getAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    public List<Order> getAllCreatedOrders() {
        return orderRepository.findByState("CREATED"); 
    }

    public List<Order> getAllPickedUpOrders() {
        return orderRepository.findByState("PICKED UP"); 
    }

    public List<Order> getAllCompletedOrders() {
        return orderRepository.findByState("COMPLETED");
    }

    public Map<Integer, String> getRidersByOrder(List<Order> orders){
        Map<Integer,String> ridersNames = new HashMap<>();
        for(Order order: orders){
            Rider rider = riderRepository.findByName(order.getRider().getName());
            String riderName = rider.getName();
            ridersNames.put(order.getId(), riderName);
        }
        return ridersNames;
    }

    public List<Rider> getAllRiders(){
        return riderRepository.findAll();
    }

    public Double getAverageRatingsRiders(){
        double ratings = 0.0;
        List<Order> orders = orderRepository.findByState("COMPLETED");
        for(Order order : orders){
            ratings += order.getRating();
        }
        if(orders.size() > 0)
            return ratings / orders.size();
        else
            return 0.0;
    }
}
