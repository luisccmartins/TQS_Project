package com.uatqs.drugdrop.repository;

import java.util.List;

import com.uatqs.drugdrop.model.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findById(Integer id);
    List<Store> findByName(String name);
}
