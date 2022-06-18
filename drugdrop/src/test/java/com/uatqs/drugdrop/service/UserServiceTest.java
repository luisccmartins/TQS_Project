package com.uatqs.drugdrop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.uatqs.drugdrop.model.User;
import com.uatqs.drugdrop.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;
    
    @Mock(lenient = true)
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setId(21);
        user.setName("User 21");
        user.setEmail("user21@drugdrop.pt");
        user.setPassword("user21");
        user.setAddress("Red Bull Ring");
        user.setPhone_number(910444929);
    }

    @Test
    public void getUserByName() {
        Mockito.when(userRepository.findByName(user.getName())).thenReturn(user);
        User userResult  = userService.getUserByName(user.getName());

        assertEquals(user.getName(), userResult.getName());
        assertEquals(user.getEmail(), userResult.getEmail());
        assertEquals(user.getPassword(), userResult.getPassword());
        assertEquals(user.getPhone_number(), userResult.getPhone_number());
        assertEquals("Red Bull Ring", userResult.getAddress());
    }

    @Test
    public void getErrorWhenInvalidName() {
        Mockito.when(userRepository.findByName("Wrong User")).thenReturn(null);
        User userResult = userService.getUserByName("Wrong User");

        assertEquals(null, userResult);
    }

    @Test
    public void getUserByEmail() {
        Mockito.when(userRepository.findByEmail(user.getEmail())).thenReturn(user);
        User userResult  = userService.getUserByEmail(user.getEmail());

        assertEquals(user.getName(), userResult.getName());
        assertEquals(user.getEmail(), userResult.getEmail());
        assertEquals(user.getPassword(), userResult.getPassword());
        assertEquals(user.getPhone_number(), userResult.getPhone_number());
        assertEquals("Red Bull Ring", userResult.getAddress());
    }

    @Test
    public void getErrorWhenInvalidEmail() {
        Mockito.when(userRepository.findByEmail("wrongemail@drugdrop.pt")).thenReturn(null);
        User userResult = userService.getUserByEmail("wrongemail@drugdrop.pt");

        assertEquals(null, userResult);
    }

}
