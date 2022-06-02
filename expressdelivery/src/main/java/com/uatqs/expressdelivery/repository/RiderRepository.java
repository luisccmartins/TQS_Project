package com.uatqs.expressdelivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uatqs.expressdelivery.model.Rider;

@Repository
public interface RiderRepository extends JpaRepository<Rider,Long>{
    Optional<Rider> findByName(String name);
    Optional<Rider> findByEmail(String email);
}
