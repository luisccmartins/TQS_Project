package com.uatqs.drugdrop.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.ObjectFactory;
import javax.servlet.http.HttpSession;  
import org.springframework.stereotype.Controller;

import com.uatqs.drugdrop.model.Drug;
import com.uatqs.drugdrop.model.LoginInput;
import com.uatqs.drugdrop.model.Order;
import com.uatqs.drugdrop.model.OrderProducts;
import com.uatqs.drugdrop.model.RegisterInput;
import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;
import com.uatqs.drugdrop.model.Address;
import com.uatqs.drugdrop.model.Store;
import com.uatqs.drugdrop.model.User;

import com.uatqs.drugdrop.repository.DrugRepository;
import com.uatqs.drugdrop.repository.LoginInputRepository;
import com.uatqs.drugdrop.repository.OrderProductsRepository;
import com.uatqs.drugdrop.repository.OrderRepository;
import com.uatqs.drugdrop.repository.StoreRepository;
import com.uatqs.drugdrop.repository.UserRepository;

import com.uatqs.drugdrop.service.DrugService;
import com.uatqs.drugdrop.service.LoginInputService;
import com.uatqs.drugdrop.service.OrderProductsService;
import com.uatqs.drugdrop.service.OrderService;
import com.uatqs.drugdrop.service.StoreService;
import com.uatqs.drugdrop.service.UserService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;


@Controller
public class DrugDropController {

  @Autowired
  private UserService userService;

  @Autowired
  private DrugRepository drugRepository;

  @Autowired
  private DrugService drugService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private StoreRepository storeRepository;

  @Autowired
  private OrderProductsRepository orderProductsRepository;

  @Autowired
  private OrderProductsService orderProductsService;

  @Autowired
  private StoreService storeService;

  @Autowired
  private LoginInputRepository loginInputRepository;

  @Autowired
  private LoginInputService loginInputService;

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private OrderService orderService;


  @Bean
public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate;
}

  // @Autowired
  // private ExpressDeliveryService service;


  @Autowired
  ObjectFactory<HttpSession> httpSessionFactory;

  @ModelAttribute("LoginInput")
  public LoginInput getGreetingObject() {
    return new LoginInput();
  }

  @ModelAttribute("RegisterInput")
  public RegisterInput getRegisterInput() {
    return new RegisterInput();
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
  public String greetingSubmit(@ModelAttribute LoginInput inputLogin, Model model) throws SQLException, ClassNotFoundException {
    String myDriver = "com.mysql.jdbc.Driver";
    String myUrl = "jdbc:mysql://localhost:3306/drugdrop";
    Class.forName(myDriver);
    Connection conn = DriverManager.getConnection(myUrl, "drugdrop", "drugdrop");
      
    Statement st = conn.createStatement();

    st.executeUpdate(" DELETE FROM login_info");
    st.executeUpdate(" DELETE FROM order_products");

    conn.close();
    HttpSession session = httpSessionFactory.getObject();
    String email = inputLogin.getEmail();
    String password = inputLogin.getPassword();

    if (email == "" || password == "") {
      model.addAttribute("error", "All fields must be filled!");
      return "login";
    }

    if(email.endsWith("@store.pt")){
      Store store = storeService.getStoreByEmail(email);
      if(store != null && (store.getPassword().equals(password))) {
        session.setAttribute("email", email);
        session.setAttribute("name", store.getName());
        model.addAttribute("name", store.getName());
        model.addAttribute("email", email);
        LoginInput loginInput = new LoginInput(email, password);
        loginInputRepository.saveAndFlush(loginInput);
        return "redirect:/storeIndex";
      }
    }else{
      User user = userService.getUserByEmail(email);
      if(user != null && (user.getPassword().equals(password))) {
        session.setAttribute("email", email);
        session.setAttribute("name", user.getName());
        model.addAttribute("name", user.getName());
        model.addAttribute("email", email);
        LoginInput loginInput = new LoginInput(email, password);
        loginInputRepository.saveAndFlush(loginInput);
        return "redirect:/userIndex";
      }
    }
    model.addAttribute("error", "Email and/or password incorrect!");
    return "login";
  }

  @GetMapping("/register")
  public String getRegisterPage(Model model) {
    return "register";
  }

  @PostMapping("/register")
  public String postRegisterForm(@ModelAttribute RegisterInput RegisterInput, Model model) {

    String name = RegisterInput.getName();
    Integer phoneNumber = RegisterInput.getPhone_number();
    String email = RegisterInput.getEmail();
    String password = RegisterInput.getPassword();
    String address = RegisterInput.getAddress();
    int length = String.valueOf(phoneNumber).length();

    User user = new User(name, email, password, phoneNumber, address);

    if (email == "" || name == "" || phoneNumber == null || password == "" || address == "") {
      model.addAttribute("error", "All fields must be filled!");
      return "register";
    }else if(length > 9 || length < 9){
      model.addAttribute("errorPhone", "Please insert a valid phone number");
      return "register";
    }else{
      userRepository.save(user);
      return "redirect:/";
    }
  }

  @GetMapping("/registerStore")
  public String getRegisterPageStore(Model model) {
    return "registerStore";
  }

  @PostMapping("/registerStore")
  public String postRegisterFormStore(@ModelAttribute RegisterInput RegisterInput, Model model) {

    String name = RegisterInput.getName();
    String email = RegisterInput.getEmail();
    String password = RegisterInput.getPassword();
    String address = RegisterInput.getAddress();

    Store store = new Store(name, address, email, password);

    if (email == "" || name == "" || password == "" || address == "") {
      model.addAttribute("error", "All fields must be filled!");
      return "registerStore";
    }else{
      storeRepository.save(store);
      return "redirect:/";
    }
  }


    @GetMapping("/userIndex")
    public String getDashboard( Model model) {
      List<Drug> medicamentos = new ArrayList<Drug>();
      medicamentos = drugRepository.findAll();
      model.addAttribute("DrugsList", medicamentos);

      List<OrderProducts> medicamentosOrderProducts = new ArrayList<OrderProducts>();
      medicamentosOrderProducts = orderProductsRepository.findAll();
      List<LinkedHashMap<String,String>> luisMartins = new ArrayList<LinkedHashMap<String,String>>();
      for (OrderProducts drug : medicamentosOrderProducts){
        LinkedHashMap<String,String> namePrice = new LinkedHashMap<String,String>();
        Drug drug2add = drugService.getDrugById(drug.getDrug_id());
        String name = drug2add.getName();
        Double price = drug2add.getPrice();
        namePrice.put("name", name);
        namePrice.put("price", price.toString());
        luisMartins.add(namePrice);
      }

      List<LoginInput> login = new ArrayList<LoginInput>();
      login = loginInputRepository.findAll();
      User user = userService.getUserByEmail(login.get(0).getEmail());
      model.addAttribute("user", user);

      model.addAttribute("OrderProductsList", luisMartins);

      return "userIndex";
    }

    @GetMapping("/storeIndex")
    public String getDashboardStore( Model model) {
      List<LoginInput> login = new ArrayList<LoginInput>();
      login = loginInputRepository.findAll();
      String email = login.get(0).getEmail();
      Integer store_logIn = storeService.getStoreByEmail(email).getId();
      Store stores = storeRepository.findById(store_logIn);
      Set<Drug> druglist = stores.getDruglist();

      Store store = storeService.getStoreByEmail(login.get(0).getEmail());
      model.addAttribute("store", store);
    
      model.addAttribute("DrugsList", druglist);
      return "storeIndex";
    }


  @GetMapping("/addDrug")
  public String addDrug(Model model){
    return "addDrug";
  }

  @PostMapping("/addDrug")
  public String addNewDrug(@ModelAttribute Drug inputDrug, Model model) throws ClassNotFoundException, SQLException {
    List<LoginInput> login = new ArrayList<LoginInput>();
    login = loginInputRepository.findAll();
    System.out.println(login);
    String email = login.get(0).getEmail();
    System.out.println(email);
    Integer store_logIn = storeService.getStoreByEmail(email).getId();

    String name = inputDrug.getName();
    String description = inputDrug.getDescription();
    Double price = inputDrug.getPrice();
    Drug r = new Drug(name, description, price);


    if (name == "" || description == "" || price == null) {
      model.addAttribute("error", "All fields must be filled!");
      return "addDrug";
    }
    else{
      drugRepository.save(r);
      String myDriver = "com.mysql.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/drugdrop";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "drugdrop", "drugdrop");
      
      Statement st = conn.createStatement();

      st.executeUpdate("INSERT INTO stores_drugs(store_id, drugs_id) "
          +"VALUES ("+store_logIn+"," + r.getId() + ")");

      conn.close();

      return "redirect:/storeIndex";
    }
  }

  @GetMapping("/profile")
  public String getProfile(Model model) {
    List<LoginInput> login = new ArrayList<LoginInput>();
    login = loginInputRepository.findAll();
    User user = userService.getUserByEmail(login.get(0).getEmail());
    model.addAttribute("user", user);
    return "userProfile";
  }

  @GetMapping("/storeProfile")
  public String getStoreProfile(Model model) {
    List<LoginInput> login = new ArrayList<LoginInput>();
    login = loginInputRepository.findAll();
    Store store = storeService.getStoreByEmail(login.get(0).getEmail());
    model.addAttribute("store", store);
    return "storeProfile";
  }

  @GetMapping("/logout")
  public String logout(Model model) throws SQLException, ClassNotFoundException {
    List<LoginInput> login = new ArrayList<LoginInput>();
    login = loginInputRepository.findAll();
    String email = login.get(0).getEmail();
    String myDriver = "com.mysql.jdbc.Driver";
    String myUrl = "jdbc:mysql://localhost:3306/drugdrop";
    Class.forName(myDriver);
    Connection conn = DriverManager.getConnection(myUrl, "drugdrop", "drugdrop");
      
    Statement st = conn.createStatement();
    st.executeUpdate(" DELETE FROM login_info WHERE email='"+ email + "'");

    conn.close();

    return "redirect:/";
  }

  @PostMapping("/deleteDrug/{id}")
  public String deleteRider(@PathVariable long id) throws SQLException, ClassNotFoundException{
    String myDriver = "com.mysql.jdbc.Driver";
    String myUrl = "jdbc:mysql://localhost:3306/drugdrop";
    Class.forName(myDriver);
    Connection conn = DriverManager.getConnection(myUrl, "drugdrop", "drugdrop");
      
    Statement st = conn.createStatement();
    st.executeUpdate(" DELETE FROM stores_drugs WHERE drugs_id="+ id);

    conn.close();
    drugRepository.deleteById(id);
    return "redirect:/storeIndex";
  }

  @PostMapping("/addToCart/{id}")
  public String addToCartaddToCart(@PathVariable Long id) throws SQLException, ClassNotFoundException{

    Integer order_id = 1;

    OrderProducts orderProducts = new OrderProducts(order_id, id);

    orderProductsRepository.save(orderProducts);
    return "redirect:/userIndex";
  }

  @GetMapping("/deleteFromCart")
  public String deleteFromCart() throws SQLException, ClassNotFoundException{
    String myDriver = "com.mysql.jdbc.Driver";
    String myUrl = "jdbc:mysql://localhost:3306/drugdrop";
    Class.forName(myDriver);
    Connection conn = DriverManager.getConnection(myUrl, "drugdrop", "drugdrop");
      
    Statement st = conn.createStatement();
    st.executeUpdate(" DELETE FROM order_products");

    conn.close();
    orderProductsRepository.deleteAll();
    return "redirect:/userIndex";
  }

  @GetMapping("/myOrders")
  public String getOrders( Model model) {
    List<LoginInput> login = new ArrayList<LoginInput>();
    login = loginInputRepository.findAll();
    User user = userService.getUserByEmail(login.get(0).getEmail());
    model.addAttribute("user", user);

    List<Order> orders = new ArrayList<Order>();
    List<Order> ordersToSend = new ArrayList<Order>();

    //orders = orderRepository.findByUser_Id(user.getId());

    orders = orderRepository.findAll();
    for (Order order : orders){
      if (order.getUser_id()==user.getId()){
        ordersToSend.add(order);
      }
    }

    model.addAttribute("Orders", ordersToSend);
    model.addAttribute("NumberOrders", ordersToSend.size());

    return "myOrders";
  }

  @GetMapping("/makeOrder")
  public String makeOrder() throws SQLException, ClassNotFoundException{
    List<LoginInput> login = new ArrayList<LoginInput>();
    login = loginInputRepository.findAll();
    User user = userService.getUserByEmail(login.get(0).getEmail());
    int userId = user.getId();

    String description = "";
    Double totalPrice = 0.0;
    //LinkedHashMap<String,Double> namePrice = new LinkedHashMap<String,Double>();
    for (OrderProducts product : orderProductsRepository.findAll()){
      long drugId = product.getDrug_id();
      Drug drug2add = drugService.getDrugById(drugId);
      String name = drug2add.getName();
      Double price = drug2add.getPrice();
      //namePrice.put(name, price);
      description = description + "[ " + name + " ]";
      totalPrice += price;

    }

    Order order = new Order(description,totalPrice,"CREATED",userId);
    orderRepository.save(order);

    String myDriver = "com.mysql.jdbc.Driver";
    String myUrl = "jdbc:mysql://localhost:3306/drugdrop";
    Class.forName(myDriver);
    Connection conn = DriverManager.getConnection(myUrl, "drugdrop", "drugdrop");
      
    Statement st = conn.createStatement();
    st.executeUpdate(" DELETE FROM order_products");

    conn.close();
    orderProductsRepository.deleteAll();
    connectionToExpressDelivery(order.getId(), user);
    return "redirect:/myOrders";
  }

  private void connectionToExpressDelivery(Integer order_id, User user){
    List<Order> orders = orderRepository.findAll();
    Order correctOrder = orders.get(order_id -1);

    Map<String, Object> request = Map.of("store", 1,"client_phone_number", user.getPhone_number(),"description", correctOrder.getDescription(),"destination", user.getAddress());

    ResponseEntity<Integer> response = restTemplate().postForEntity("http://localhost:9010/api/order", request, Integer.class);
}
}