package com.uatqs.expressdelivery.controller;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.uatqs.expressdelivery.model.Rider;
import com.uatqs.expressdelivery.repository.RiderRepository;

import javax.servlet.http.HttpSession;  

@Controller
public class AddRiderController {

  @Autowired
  private RiderRepository riderRepository;

  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @ModelAttribute("inputRider")
  public Rider getGreetingObject() {
    return new Rider();
  }

  @GetMapping("/addRider")
  public String getAddRiderPage(Model model){
    return "AddRider";
  }

  @PostMapping("/addRider")
  public String addNewRider(@ModelAttribute Rider inputRider, Model model) {

    String email = inputRider.getEmail();
    String name = inputRider.getName();
    Integer age = Integer.valueOf(inputRider.getAge());
    Integer phoneNumber = inputRider.getPhone_number();
    boolean available = false;

    Rider r = new Rider(name, age, phoneNumber, email, available);


    if (email == "" || name == "" || age == null || phoneNumber == null) {
      model.addAttribute("error", "All fields must be filled!");
      return "AddRider";
    }
    else{
      riderRepository.save(r);
      return "redirect:/dashboard";
    }
  }
}
