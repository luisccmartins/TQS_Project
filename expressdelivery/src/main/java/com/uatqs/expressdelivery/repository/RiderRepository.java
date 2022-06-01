package com.uatqs.expressdelivery.repository;

import java.util.Optional;

import com.uatqs.expressdelivery.model.Rider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long>{
    Optional<Rider> findByEmail(String email);
}
