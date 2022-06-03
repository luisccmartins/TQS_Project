package com.uatqs.expressdelivery.controller;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uatqs.expressdelivery.model.Rider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;  

@Controller
public class DashboardController {

@Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @GetMapping("/dashboard")
    public String getDashboard( Model model) {
      HttpSession session = httpSessionFactory.getObject();

      HashMap<Integer, String> hm = new HashMap<Integer, String>(); 
      Rider r1 = new Rider("Alexandre Canoa", 21, 915264812 , "XelaOFficial@reydacanoa.vz", false);
      Rider r2 = new Rider("Luis Martins", 27, 987254122, "luisccmartins@ua.pt", false);
      Rider r3 = new Rider("Pedro Ministro", 36, 234152637, "pedroMinistro@ua.pt", true);
      List<Rider> estafetas = new ArrayList<Rider>();
      estafetas.add(r1);
      estafetas.add(r2);
      estafetas.add(r3);
      //EstafetasController.findAllEstafetas();//estafetas controller tem de ser criado
      // for(Rider r : estafetas) {
      //   if(hm.containsKey(r.getEstafeta().getNumber())){
      //     hm.put(r.getEstafeta().getNumber(), hm.get(r.getEstafeta().getNumber()) + 1);

      //   }
      //   else{
      //     hm.put(r.getEstafeta().getNumber(), 1);
      //   }
      // }
      
      model.addAttribute("RidersList", estafetas);
      
      // for(Rider r : estafetas){
      //   int i = 0;
      //   hm.put(i, r.getName());
      //   i++;
      // }

      // model.addAttribute("RidersID", hm);


      // Map<String, Integer> graphData = new TreeMap<>();
      // for(String i : hm.keySet()) {
      //   graphData.put(i, hm.get(i));
      // }
      
      //model.addAttribute("chartData", graphData);
      return "EstafetasPerformance";
    }

    
}