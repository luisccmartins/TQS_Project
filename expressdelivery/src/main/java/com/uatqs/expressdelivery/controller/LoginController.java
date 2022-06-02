package com.uatqs.expressdelivery.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uatqs.expressdelivery.model.Admin;
import com.uatqs.expressdelivery.model.LoginInput;
import com.uatqs.expressdelivery.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.ObjectFactory;


import javax.servlet.http.HttpSession;  

import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

  @Autowired
  private AdminService adminService;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @ModelAttribute("LoginInput")
  public LoginInput getGreetingObject() {
    return new LoginInput();
  }

  @GetMapping("/")
  public String getAskIdentifier(Model model) {
    return "login2";
  }

  @PostMapping("/")
  public String greetingSubmit(@ModelAttribute LoginInput inputLogin, Model model) {
    HttpSession session = httpSessionFactory.getObject();
    String email = inputLogin.getEmail();
    String password = inputLogin.getPassword();

    if (email == "" || password == "") {
      model.addAttribute("error", "All fields must be filled!");
      return "login2";
    }

    Admin admin = adminService.getAdminByEmail(email);
    
    if(admin != null && (admin.getPassword().equals(password))) {
      session.setAttribute("email", email);
      session.setAttribute("name", admin.getName());
      model.addAttribute("name", admin.getName());
      model.addAttribute("email", email);
      return "admin";
    }

    model.addAttribute("error", "Email and/or password incorrect!");
    return "login2";
  }
}
