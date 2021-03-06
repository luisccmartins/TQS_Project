package com.uatqs.expressdelivery.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.uatqs.expressdelivery.model.Address;
import com.uatqs.expressdelivery.model.Admin;
import com.uatqs.expressdelivery.model.Order;
import com.uatqs.expressdelivery.model.Rider;
import com.uatqs.expressdelivery.model.Store;
import com.uatqs.expressdelivery.repository.AdminRepository;
import com.uatqs.expressdelivery.repository.OrderRepository;
import com.uatqs.expressdelivery.repository.RiderRepository;
import com.uatqs.expressdelivery.repository.StoreRepository;

@Service
public class ExpressDeliveryService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RiderRepository riderRepository;

    @Autowired
    private StoreRepository storeRepository;


    @Autowired
    public ExpressDeliveryService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
   }

    public long total() { return adminRepository.count();}

    public Admin getAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getAllCreatedOrders() {
        return orderRepository.findByState("CREATED"); 
    }

    public List<Order> getAllPickedUpOrders() {
        return orderRepository.findByState("PICKEDUP"); 
    }

    public List<Order> getAllDeliveredOrders() {
        return orderRepository.findByState("DELIVERED");
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

    public Rider getRider(String email){
        return riderRepository.findByEmail(email);
    }

    public Double getAverageRatingsRiders(){
        double ratings = 0.0;
        List<Rider> riders = riderRepository.findAll();
        if (riders.size()==0){
            return 0.0;
        }
        for (Rider rider : riders){
            ratings += rider.getRatingsAverage();
        }
        ratings = ratings/riders.size();
        return ratings;
        /*
        List<Order> orders = orderRepository.findByState("DELIVERED");
        for(Order order : orders){
            ratings += order.getRating();
        }
        if(orders.size() > 0)
            return ratings / orders.size();
        else
            return 0.0;
        */
    }

    public Double getAverageRatingsPerRider(Rider rider){
        double ratings = 0.0;
        List<Order> orders = orderRepository.findByStateAndRider("DELIVERED", rider.getId());
        for(Order order : orders){
            ratings += order.getRating();
        }
        if(orders.size() > 0)
            return ratings / orders.size();
        else
            return 0.0;
    }

    public int getNumberDeliveriesPerDay(){
        long currentTime = System.currentTimeMillis();
        return orderRepository.findByStateAndTimestampBetween("DELIVERED", new Timestamp(currentTime - 86400000), new Timestamp(currentTime)).size();
    }

    public Rider createNewRider(String name, int phone_number, int age, String email, String password) {
        if (riderRepository.findByEmail(email) != null) {
            System.out.println("Rider already registered");
            return null;
        } else {
            Rider rider = new Rider(name, phone_number, age, email, password);
            return riderRepository.save(rider);
        }
    }

    public Rider loginRider(String email){
        return riderRepository.findByEmail(email);
    }

    public boolean riderHasAccount(String email, String password){
        Rider rider = riderRepository.findByEmail(email);
        if (rider==null){
            return false;
        }
        if (rider.getEmail().equals(email) && rider.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }

    }

    public Integer addOrder(String state, Integer phone_number, Timestamp timestamp) {
        Order order;
        Order order2 = new Order("CREATED", phone_number, timestamp);
        order = orderRepository.save(order2);
        return order.getId();
    }

    private void updateDeliveryStatus(String state, int order_id) throws Exception {
        URL url = new URL("http://localhost:9014/order/" + order_id + "/state/" + state);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.getInputStream().close();
    }

    public String acceptOrderRider(Integer order_id, Rider rider_id) throws Exception {
        Order order = orderRepository.findById(order_id);
        order.setRider(rider_id);
        order.setState("PICKEDUP");
        orderRepository.save(order);
        updateDeliveryStatus("PICKEDUP",order_id);
        return "Rider has picked up the order";

    }

    public String riderUpdateOrderState(Integer order_id, String rider_email, String state) throws Exception {
        Order order = orderRepository.findById(order_id);
        Rider rider = riderRepository.findByEmail(rider_email);
        order.setState(state);
        orderRepository.save(order);
        updateDeliveryStatus(state,order_id);
        return "Status of Order Changed";
    }

    public String riderUpdateOrderState(Integer order_id, Integer rider_id, String state) throws Exception {
        Order order = orderRepository.findById(order_id);
        Rider rider = riderRepository.findRiderById(rider_id);
        order.setState(state);

        if(state.equals("DELIVERED")){
            long currentTime = System.currentTimeMillis();
            long days = TimeUnit.DAYS.toMillis(Calendar.DAY_OF_MONTH - 1L);
            long months = TimeUnit.HOURS.toMillis(Calendar.HOUR_OF_DAY);

            int rating = 0;
            SecureRandom r = new SecureRandom();
            rating = (r.nextInt(11));           //give a random rating from 0 to 10
            order.setRating(rating);            //add to order

            List<Order> monthlyOrders = orderRepository.findByStateAndTimestampBetween("DELIVERED", new Timestamp(currentTime - days - months), new Timestamp(currentTime));    //talvez alterar para todas as encomendas e n??o s?? as deste m??s
            int counter = 0;
            for(Order orderMonthly : monthlyOrders){
                Order thisorder = orderRepository.findById(orderMonthly.getId());
                if(thisorder.getRider().getId() == rider_id){
                    counter += 1;
                    int ratingOfOrder = thisorder.getRating();
                    rating += ratingOfOrder;
                    rider.ratings.add(rating);
                }
            }
            if (counter == 0) {
                rider.ratings.add(rating);
            } else {
                rider.setRatingsAverage(Double.valueOf(rating)/Double.valueOf(counter));
            }
        }
        orderRepository.save(order);
        updateDeliveryStatus(state,order_id);
        return "Status of Order Changed";
    }

    public Integer createOrder(int store, int client_phone_number, String description, String destination) {
        Order order;
        order = orderRepository.save( new Order(store,description,client_phone_number,destination));
        return order.getId();
    }

}
