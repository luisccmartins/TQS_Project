package com.uatqs.drugdrop.model;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.uatqs.drugdrop.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class LoginResgisterOrganizerTest {

    @InjectMocks
    private LoginRegisterOrganizer loginRegisterOrganizer;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testLoginSuccessful(){
        User user = new User("ProfJam", "profjam@drugdrop.pt", "aguaDeCoco", 960123759);
        LoginInput loginInput = new LoginInput("profjam@drugdrop.pt", "aguaDeCoco");

        when(userRepository.findByEmail(any())).thenReturn(null);
        when(userRepository.findByEmail("profjam@drugdrop.pt")).thenReturn(user);

        LoginEnum loginEnum = loginRegisterOrganizer.login(loginInput);
        assertThat(loginEnum).isEqualTo(LoginEnum.LOGIN_SUCCESSFUL);
    }

    @Test
    public void testLoginInvalid(){
        User user = new User("ProfJam", "profjam@drugdrop.pt", "aguaDeCoco", 960123759);
        LoginInput loginInput = new LoginInput("profjam@drugdrop.pt", "touBem");

        when(userRepository.findByEmail(any())).thenReturn(null);
        when(userRepository.findByEmail("profjam@drugdrop.pt")).thenReturn(user);

        LoginEnum loginEnum = loginRegisterOrganizer.login(loginInput);
        assertThat(loginEnum).isEqualTo(LoginEnum.INVALID_LOGIN);
    }

    @Test
    public void testLoginNotRegistered(){
        LoginInput loginInput = new LoginInput("profjam@drugdrop.pt", "aguaDeCoco");

        when(userRepository.findByEmail(any())).thenReturn(null);

        LoginEnum loginEnum = loginRegisterOrganizer.login(loginInput);
        assertThat(loginEnum).isEqualTo(LoginEnum.NOT_REGISTERED);
    }

}
