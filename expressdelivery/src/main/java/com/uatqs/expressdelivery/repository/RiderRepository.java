package com.uatqs.expressdelivery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uatqs.expressdelivery.model.Rider;

@Repository
public interface RiderRepository extends JpaRepository<Rider,Long>{
    Rider findByName(String name);
    Rider findByEmail(String email);
    Rider findRiderById(Integer rider_id);
}
