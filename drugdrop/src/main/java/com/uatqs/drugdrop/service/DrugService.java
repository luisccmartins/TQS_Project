package com.uatqs.drugdrop.service;

import java.util.List;

import com.uatqs.drugdrop.model.Drug;
import com.uatqs.drugdrop.repository.DrugRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugService {

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    public DrugService(DrugRepository drugRepository){
        this.drugRepository = drugRepository;
    }

    public long total() { return drugRepository.count();}

    public Drug getDrugByName(String name){
        return drugRepository.findByName(name);
    }

    public Drug getDrugById(long id){
        return drugRepository.findById(id);
    }
    
}
