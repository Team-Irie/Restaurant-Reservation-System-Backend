package com.gryffindor.project2.controllers;

import com.gryffindor.controllers.UserController;
import com.gryffindor.models.User;
import com.gryffindor.services.UserService;
import com.gryffindor.types.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @InjectMocks
    UserController userController;
    @Mock
    HttpServletRequest request;
    @Mock
    UserService userService;
    private List<User> users = new ArrayList<>();;
    private User user ;
    @BeforeEach
    void setUp() {
        user = new User(12,"john","Cary","jon@gmail.com","jon123", UserType.CUSTOMER,"467-456-5679");
        User user2 = new User(13,"henry","Cary","hen@gmail.com","jon123", UserType.CUSTOMER,"467-456-5679");
        users.add(user);
        users.add(user2);
    }
    @Test
    public void getAllUserTest() {
        when(userService.getAllUsers()).thenReturn(users);
        List<User> result = userController.getAllUsers();
        assertEquals(2, result.size());
    }
    @Test
    public void getUserByIdTest() {
        when(userService.getUserById(Mockito.anyInt())).thenReturn(user);
        User result = userController.getUserById(12);
        assertNotNull(result);
        assertEquals(12, result.getUserId());
    }
}
