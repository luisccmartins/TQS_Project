package com.uatqs.drugdrop.service;

import java.util.List;

import com.uatqs.drugdrop.model.Store;
import com.uatqs.drugdrop.repository.StoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    public long total() { return storeRepository.count();}

    public List<Store> getStoreByName(String name){
        return storeRepository.findByName(name);
    }

    public Store getStoreById(Integer id){
        return storeRepository.findById(id);
    }
    
}
