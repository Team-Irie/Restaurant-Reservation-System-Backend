package com.gryffindor.project2.services;

import com.gryffindor.models.User;
import com.gryffindor.repositories.UserRepository;
import com.gryffindor.services.UserService;
import com.gryffindor.types.UserType;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest{

    @InjectMocks
    UserService userService;
    @Mock
    UserRepository userRepository;
    private List<User> users = new ArrayList<>();;
    private User user ;
    @BeforeEach
    public void run() {
        user = new User(12,"john","Cary","jon@gmail.com","jon123", UserType.CUSTOMER,"467-456-5679");
        User user2 = new User(13,"henry","Cary","hen@gmail.com","jon123", UserType.CUSTOMER,"467-456-5679");
        users.add(user);
        users.add(user2);
    }

    @Test
    public void getAllUserTest() {
        when(userRepository.findAll()).thenReturn(users);
        List<User> response = userService.getAllUsers();
        assertEquals(2, response.size());
        assertEquals("john", response.get(0).getFirstName());
        assertEquals("henry", response.get(1).getFirstName());
    }

    @Test
    public  void getByUserIdTest() {
        when(userRepository.getById(Mockito.anyInt())).thenReturn(user);
        User result = userService.getUserById(12);
        assertEquals("john", result.getFirstName());
    }

    @Test
    public void getUserByEmailAndPasswordTest(){
        when(userRepository.getUserByEmailAndPassword(Mockito.anyString(),Mockito.anyString())).thenReturn(user);
        User result = userService.getUserByEmailAndPassword("email1", "pass1");
        assertEquals("john", result.getFirstName());
    }
}
