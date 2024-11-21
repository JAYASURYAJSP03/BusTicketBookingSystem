package com.project.capstone.controller;

import com.project.capstone.dto.UserRegisteredDTO;
import com.project.capstone.service.DefaultUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RegistrationControllerTest {

    private MockMvc mockMvc;
    private DefaultUserService userService;
    private RegistrationController registrationController;

    @BeforeEach
    void setUp() {
        userService = Mockito.mock(DefaultUserService.class);
        registrationController = new RegistrationController(userService);

        // Set up view resolver to find the correct views
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(registrationController)
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    void testShowRegistrationForm() throws Exception {
        mockMvc.perform(get("/registration"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"))
                .andExpect(model().attributeExists("user"));
    }

    @Test
    void testRegisterUserAccount() throws Exception {
        mockMvc.perform(post("/registration")
                        .flashAttr("user", new UserRegisteredDTO("testuser", "test@example.com", "password")))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));

        verify(userService, times(1)).save(any(UserRegisteredDTO.class));
    }
}
