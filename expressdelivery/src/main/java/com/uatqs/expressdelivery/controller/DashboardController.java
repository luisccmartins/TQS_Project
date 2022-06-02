package main.java.com.uatqs.expressdelivery.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;  

@Controller
public class DashboardController {

@Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @Autowired
  private StatisticsController statisticsController;

  @GetMapping("/dashboard")
    public String getDashboard( Model model) {
      HttpSession session = httpSessionFactory.getObject();

      HashMap<String, Integer> hm = new HashMap<String, Integer>(); 
      List<Estafeta> estafetas = EstafetasController.findAllEstafetas();//estafetas controller tem de ser criado
      for(Estafeta e : estafetas) {
        if(hm.containsKey(e.getEstafeta().getNumber())){
          hm.put(p.getEstafeta().getNumber(), hm.get(p.getEstafeta().getNumber()) + 1);

        }
        else{
          hm.put(p.getEstafeta().getNumber(), 1);
        }
      }

      Map<String, Integer> graphData = new TreeMap<>();
      for(String i : hm.keySet()) {
        graphData.put(i, hm.get(i));
      }
      
      model.addAttribute("chartData", graphData);
      return "/dashboard";
    }

    
}
