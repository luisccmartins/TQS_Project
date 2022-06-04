package com.uatqs.expressdelivery.controller;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uatqs.expressdelivery.model.Admin;
import com.uatqs.expressdelivery.model.Rider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;  

@Controller
public class AddRiderController {

@Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @ModelAttribute("inputRider")
  public Rider getGreetingObject() {
    return new Rider();
  }

  @GetMapping("addRider")
  public String addNewRider(@ModelAttribute Rider inputRider, Model model) {
    HttpSession session = httpSessionFactory.getObject();
    String email = inputRider.getEmail();
    String name = inputRider.getName();
    String age = String.valueOf(inputRider.getAge());
    String phoneNumber = String.valueOf(inputRider.getPhone_number());

    if (email == "" || name == "" || age == "" || phoneNumber == "") {
      model.addAttribute("error", "All fields must be filled!");
      return "addRider";
    }
    else{
      boolean available = true;
      Rider r1 = new Rider(name, Integer.parseInt(age), Integer.parseInt(phoneNumber), email, available);
      return "redirect:/dashboard";
    }
  }
}
