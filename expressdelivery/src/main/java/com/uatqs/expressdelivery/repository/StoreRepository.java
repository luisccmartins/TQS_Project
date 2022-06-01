package com.uatqs.expressdelivery.repository;

import java.util.Optional;

import com.uatqs.expressdelivery.model.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByName(String name);
}
