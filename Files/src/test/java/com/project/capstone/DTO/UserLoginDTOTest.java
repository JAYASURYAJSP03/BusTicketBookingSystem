package com.project.capstone.DTO;

import com.project.capstone.dto.UserLoginDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserLoginDTOTest {

    private UserLoginDTO userLoginDTO;

    @BeforeEach
    public void setUp() {
        userLoginDTO = new UserLoginDTO();
        userLoginDTO.setUsername("johndoe");
        userLoginDTO.setPassword("password123");
    }

    @Test
    public void testUserLoginDTOFields() {
        assertEquals("johndoe", userLoginDTO.getUsername());
        assertEquals("password123", userLoginDTO.getPassword());
    }

    @Test
    public void testUserLoginDTONoArgsConstructor() {
        UserLoginDTO userLogin = new UserLoginDTO();
        assertNull(userLogin.getUsername());
        assertNull(userLogin.getPassword());
    }
}
