package com.uatqs.drugdrop.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.uatqs.drugdrop.model.Drug;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DrugDropController.class)
@AutoConfigureMockMvc(addFilters = false)
public class DrugDropControllerTest {

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private StoreRepository storeRepository;

    @MockBean
    private StoreService storeService;

    @MockBean
    private DrugRepository drugRepository;

    @MockBean
    private DrugService drugService;

    @MockBean
    private LoginInputRepository loginInputRepository;

    @MockBean
    private LoginInputService loginInputService;

    @MockBean
    private OrderProductsRepository orderProductsRepository;

    @MockBean
    private OrderProductsService orderProductsService;

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private OrderService orderService;

    @Autowired
    private MockMvc mvc;


    private User user, wrongUser;

    private Store store;

    private Drug drug;

    @BeforeEach
    public void setUp(){

        String name = "User 1";
        String email = "user1@drugdrop.pt";
        String password = "user1";
        Integer phone_number = 960111000;
        String address = "Rua do Departamento da Água de Coco";
        user = new User(name, email, password, phone_number, address);

        wrongUser = new User();
        wrongUser.setName("User 50");
        wrongUser.setEmail("user50drugdrop.pt");
        wrongUser.setPassword("user50");
        wrongUser.setPhone_number(960111555);
        wrongUser.setAddress("Rua do Departamento de Artes");

        store = new Store();
        store.setEmail("store4@store.pt");
        store.setPassword("store4");
        store.setName("Store 4");
        store.setAddress("Rua da Store 4");

        drug = new Drug();
        drug.setName("Ibuprofeno");
        drug.setPrice(2.99);
    }

    @Test
    public void loginInsuccessful() throws Exception{
        
        Mockito.when(userService.getUserByName(wrongUser.getName())).thenReturn(wrongUser);

        mvc.perform(post("/")
                    .param("email", wrongUser.getEmail())
                    .param("password", wrongUser.getPassword()))
                    .andExpect(status().isOk())
                    .andExpect(view().name("login"));
    }

    @Test
    public void registerAccount() throws Exception{
        
        mvc.perform(post("/registerStore")
                    .param("email", store.getEmail())
                    .param("password", store.getPassword())
                    .param("name", store.getName())
                    .param("address", store.getAddress()))
                    .andExpect(redirectedUrl("/"))
                    .andExpect(view().name("redirect:/"));
    }

    @Test
    public void loginSuccessful() throws Exception{

        Mockito.when(userService.getUserByEmail(user.getEmail())).thenReturn(user);
        
        mvc.perform(post("/")
                    .param("email", user.getEmail() )
                    .param("password", user.getPassword() ))
                    .andExpect(redirectedUrl("/userIndex"))
                    .andExpect(view().name("redirect:/userIndex"));
    }
}
