package com.uatqs.drugdrop.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.uatqs.drugdrop.repository.UserRepository;
import com.uatqs.drugdrop.service.UserService;

public class LoginRegisterOrganizer {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public LoginEnum login(LoginInput loginInput) {
        User user = userRepository.findByEmail(loginInput.getEmail());
        if (user == null){
            return LoginEnum.NOT_REGISTERED;
        }else if (user.getPassword() != loginInput.getPassword()) {
            return LoginEnum.INVALID_LOGIN;
        }
        return LoginEnum.LOGIN_SUCCESSFUL;
    }

    public boolean register(RegisterInput registerInput) {
        if (userService.accountExists(registerInput.getEmail())){
            return false;
        } 
        User user = new User(registerInput.getName(), registerInput.getEmail(), registerInput.getPassword(), registerInput.getPhone_number());
        userRepository.save(user);
        return true;
    }
}
