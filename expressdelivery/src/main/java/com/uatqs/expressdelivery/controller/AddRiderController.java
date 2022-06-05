package com.uatqs.expressdelivery.controller;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.uatqs.expressdelivery.model.Rider;
import javax.servlet.http.HttpSession;  

@Controller
public class AddRiderController {

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
    String age = String.valueOf(inputRider.getAge());
    Integer phoneNumber = Integer.valueOf(inputRider.getPhone_number());

    if (email == "" || name == "" || age == "" || phoneNumber == null) {
      model.addAttribute("error", "All fields must be filled!");
      return "AddRider";
    }
    else{
      //boolean available = true;
      //Rider r1 = new Rider(name, Integer.parseInt(age), Integer.parseInt(phoneNumber), email, available);
      return "redirect:/dashboard";
    }
  }
}
