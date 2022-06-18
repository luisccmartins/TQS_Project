package com.uatqs.drugdrop.repository;

import java.util.List;

import com.uatqs.drugdrop.model.Drug;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {
    Drug findById(long id);
    Drug findByName(String name);
}
