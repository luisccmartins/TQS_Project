package com.example.expressdelivery.Controller;

import org.json.JSONObject;
import com.example.expressdelivery.Model.Rider;
import com.example.expressdelivery.Model.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AppController {
    @POST("/api/rider/login")
    Call<Rider> riderLogin(@Body JSONObject jsonObject);

    @POST("/api/rider/signup")
    Call<Rider> riderSignup(@Body JSONObject jsonObject);

    @GET("/api/rider/orders")
    Call<List<Order>> getOrders();

    @GET("/api/rider/orders/created")
    Call<List<Order>> getCreatedOrders();

    @GET("/api/rider/orders/pickedup")
    Call<List<Order>> getPickedupOrders();

    @GET("/api/rider/orders/delivered")
    Call<List<Order>> getDeliveredOrders();

    @PUT("/api/rider/orders/{order_id}/{rider_id}")
    Call<String> acceptOrder(@Path("order_id") String order_id,@Path("rider_id") String rider_id);

    @PUT("/api/rider/orders/update/{order_id}/{rider_id}/{state}")
    Call<String> updateOrderStatus(@Path("order_id") String order_id,@Path("rider_id") String rider_id,@Path("state") String state);
}
