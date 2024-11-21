package com.project.capstone.controller;
import com.project.capstone.controller.LoginController;
import com.project.capstone.dto.UserLoginDTO;
import com.project.capstone.service.DefaultUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    @Mock
    private DefaultUserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLogin() {
        String viewName = loginController.login();

        assertEquals("login", viewName);
    }
}
