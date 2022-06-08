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
import com.uatqs.expressdelivery.repository.RiderRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.Column;
import javax.servlet.http.HttpSession;  

@Controller
public class DashboardController {

@Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @Autowired
  private RiderRepository riderRepository;

  @GetMapping("/dashboard")
    public String getDashboard( Model model) {
      List<Rider> estafetas = new ArrayList<Rider>();
      estafetas = riderRepository.findAll();
      model.addAttribute("RidersList", estafetas);
      return "EstafetasPerformance";
    }

    
}