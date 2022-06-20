package com.uatqs.drugdrop.repository;

import org.springframework.stereotype.Repository;

import com.uatqs.drugdrop.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    //List<Order> findByUser_Id(int user_id);
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "UPDATE orders SET state=:state WHERE id=:id")
    void changeStateOfDelivery(Integer id, String state);
    
}
