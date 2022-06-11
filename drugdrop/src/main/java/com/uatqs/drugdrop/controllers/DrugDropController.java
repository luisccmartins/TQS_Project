package com.uatqs.drugdrop.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.ObjectFactory;
import javax.servlet.http.HttpSession;  
import org.springframework.stereotype.Controller;

import com.uatqs.drugdrop.model.Drug;
import com.uatqs.drugdrop.model.LoginInput;
import com.uatqs.drugdrop.model.Order;
import com.uatqs.drugdrop.model.Address;
import com.uatqs.drugdrop.model.Store;
import com.uatqs.drugdrop.model.User;

import com.uatqs.drugdrop.repository.DrugRepository;
import com.uatqs.drugdrop.repository.StoreRepository;
import com.uatqs.drugdrop.repository.UserRepository;

import com.uatqs.drugdrop.service.DrugService;
import com.uatqs.drugdrop.service.StoreService;
import com.uatqs.drugdrop.service.UserService;

import java.util.ArrayList;

import java.util.List;


@Controller
public class DrugDropController {

  @Autowired
  private UserService userService;

  @Autowired
  private DrugRepository drugRepository;

  // @Autowired
  // private ExpressDeliveryService service;


  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @ModelAttribute("LoginInput")
  public LoginInput getGreetingObject() {
    return new LoginInput();
  }

  @ModelAttribute("inputDrug")
  public Drug getGreetingObjectRider() {
    return new Drug();
  }


  @GetMapping("/")
  public String getAskIdentifier(Model model) {
    return "login";
  }

  @PostMapping("/")
  public String greetingSubmit(@ModelAttribute LoginInput inputLogin, Model model) {
    HttpSession session = httpSessionFactory.getObject();
    String email = inputLogin.getEmail();
    String password = inputLogin.getPassword();

    if (email == "" || password == "") {
      model.addAttribute("error", "All fields must be filled!");
      return "login";
    }

    User user = userService.getUserByEmail(email);

    if(user != null && (user.getPassword().equals(password))) {
      session.setAttribute("email", email);
      session.setAttribute("name", user.getName());
      model.addAttribute("name", user.getName());
      model.addAttribute("email", email);
      return "redirect:/index";
    }

    model.addAttribute("error", "Email and/or password incorrect!");
    return "login";
  }


  @GetMapping("/index")
    public String getDashboard( Model model) {
      List<Drug> medicamentos = new ArrayList<Drug>();
      medicamentos = drugRepository.findAll();
      model.addAttribute("DrugsList", medicamentos);
      return "index";
    }


  @GetMapping("/addDrug")
  public String getAddRiderPage(Model model){
    return "AddDrug";
  }

  @PostMapping("/addDrug")
  public String addNewRider(@ModelAttribute Drug inputDrug, Model model) {

    String name = inputDrug.getName();
    String description = inputDrug.getDescription();
    Double price = inputDrug.getPrice();

    Drug r = new Drug(name, description, price);


    if (name == "" || description == "" || price == null) {
      model.addAttribute("error", "All fields must be filled!");
      return "AddRider";
    }
    else{
      drugRepository.save(r);
      return "redirect:/index";
    }
  }

  // @GetMapping("/deliveries")
  // public String getDeliveries(Model model){
  //   List<Order> orders = service.getAllCompletedOrders();
  //   model.addAttribute("totalOrders", orders);
  //   model.addAttribute("employeesNames", service.getRidersByOrder(orders));
  //   return "Estatísticas";
  // }
}