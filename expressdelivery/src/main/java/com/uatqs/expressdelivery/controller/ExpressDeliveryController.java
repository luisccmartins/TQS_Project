package com.uatqs.expressdelivery.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uatqs.expressdelivery.model.Admin;
import com.uatqs.expressdelivery.model.LoginInput;
import com.uatqs.expressdelivery.model.Order;
import com.uatqs.expressdelivery.service.AdminService;
import com.uatqs.expressdelivery.service.ExpressDeliveryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.ObjectFactory;
import javax.servlet.http.HttpSession;  
import org.springframework.stereotype.Controller;
import com.uatqs.expressdelivery.model.Rider;
import com.uatqs.expressdelivery.repository.RiderRepository;

import java.util.ArrayList;

import java.util.List;


@Controller
public class ExpressDeliveryController {

  @Autowired
  private AdminService adminService;

  @Autowired
  private RiderRepository riderRepository;

  @Autowired
  private ExpressDeliveryService service;


  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @ModelAttribute("LoginInput")
  public LoginInput getGreetingObject() {
    return new LoginInput();
  }

  @ModelAttribute("inputRider")
  public Rider getGreetingObjectRider() {
    return new Rider();
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
      return "redirect:/dashboard";
    }

    model.addAttribute("error", "Email and/or password incorrect!");
    return "login2";
  }


  @GetMapping("/dashboard")
    public String getDashboard( Model model) {
      List<Rider> estafetas = new ArrayList<Rider>();
      estafetas = riderRepository.findAll();
      model.addAttribute("RidersList", estafetas);
      return "EstafetasPerformance";
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

  @GetMapping("/deliveries")
  public String getDeliveries(Model model){
    List<Order> orders = service.getAllCompletedOrders();
    model.addAttribute("totalOrders", orders);
    model.addAttribute("riderName", service.getRidersByOrder(orders));
    return "Estatisticas";
  }

  @GetMapping("/profiles")
  public String getRiderProfiles(Model model){
    List<Rider> riders = service.getAllRiders();
    model.addAttribute("riders", riders);
    return "RiderProfile";
  }

  @PostMapping("/deleteRider/{id}")
    public String deleteRider(@PathVariable long id){
      riderRepository.deleteById(id);
      return "redirect:/profiles";
    }
}
