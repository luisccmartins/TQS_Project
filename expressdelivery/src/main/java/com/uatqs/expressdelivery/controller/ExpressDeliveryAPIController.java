package com.uatqs.expressdelivery.controller;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.uatqs.expressdelivery.model.Address;
import com.uatqs.expressdelivery.model.Order;
import com.uatqs.expressdelivery.model.Rider;
import com.uatqs.expressdelivery.model.Store;
import com.uatqs.expressdelivery.service.ExpressDeliveryService;

@RestController
@RequestMapping("/api")
public class ExpressDeliveryAPIController {

    @Autowired
    private ExpressDeliveryService service;

    @PostMapping("/rider/signup")
    public Rider createRiderAccount(@RequestBody Map<String, Object> requestBody){
        LinkedHashMap map = (LinkedHashMap) requestBody.get("nameValuePairs");
        String name = (String) map.get("name");
        Integer phone_number = (Integer) map.get("phone_number");
        Integer age = (Integer) map.get("age");
        String email = (String) map.get("email");
        String password = (String) map.get("password");
        return service.createNewRider(name, phone_number, age, email, password);
    }

    @PostMapping("/rider/login")
    public Rider loginRider(@RequestBody Map<String, Object> requestBody){
        String email = (String) requestBody.get("email");
        String password = (String) requestBody.get("password");
        if (!service.riderHasAccount(email, password)){
            return null;
        }else{
            return service.getRider(email);
        }
        
    }

    @PostMapping("/addOrder")
    public Integer addOrder(@RequestBody Map<String, Object> requestBody){
        String state = "CREATED";
        Store store = (Store) requestBody.get("store");
        Address address = (Address) requestBody.get("address");
        Integer client_telephone = (Integer) requestBody.get("client_telephone");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return service.addOrder(state,store, address, client_telephone, timestamp);
    }

    @GetMapping("/rider/orders")
    public List<Order> getCreatedOrders(){
        return service.getAllCreatedOrders();
    }

    @PutMapping("/rider/orders/{order_id}/{rider_id}")
    public String riderAcceptOrder(@PathVariable Integer order_id, @PathVariable Rider rider_id) throws Exception{
       return service.acceptOrderRider(order_id,rider_id);
    }

    @PutMapping("/rider/orders/update/{order_id}/{rider_id}/{state}")
    public String riderUpdateOrderStatus(@PathVariable Integer order_id, @PathVariable Integer rider_id, @PathVariable String state) throws Exception{
        return service.riderUpdateOrderState(order_id,rider_id, state);
    }

    @PostMapping("/order")
    public Integer order(@RequestBody Map<String, Object> request){
        int store = (Integer) request.get("store");
        int client_phone_number = (Integer) request.get("client_phone_number");
        String description = (String) request.get("description");
        String destination = (String) request.get("destination");
        return service.createOrder(store, client_phone_number, description, destination);
    }
    
}
