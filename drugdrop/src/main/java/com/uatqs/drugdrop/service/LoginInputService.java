package com.uatqs.drugdrop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uatqs.drugdrop.model.LoginInput;
import com.uatqs.drugdrop.model.Store;
import com.uatqs.drugdrop.model.User;
import com.uatqs.drugdrop.repository.LoginInputRepository;

@Service
public class LoginInputService {

    @Autowired
    private LoginInputRepository loginInputRepository;

    @Autowired
    public LoginInputService(LoginInputRepository loginInputRepository){
        this.loginInputRepository = loginInputRepository;
    }

    public long total() { return loginInputRepository.count();}

    public LoginInput getStoreByEmail(String email){
        return loginInputRepository.findByEmail(email);
    }

    public LoginInput getUserByEmail(String email){
        return loginInputRepository.findByEmail(email);
    }
}
