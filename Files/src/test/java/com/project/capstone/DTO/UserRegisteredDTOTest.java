package com.project.capstone.DTO;

import com.project.capstone.dto.UserRegisteredDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegisteredDTOTest {

    private UserRegisteredDTO userRegisteredDTO;

    @BeforeEach
    public void setUp() {
        userRegisteredDTO = new UserRegisteredDTO();
        userRegisteredDTO.setName("John Doe");
        userRegisteredDTO.setEmail_id("john.doe@example.com");
        userRegisteredDTO.setPassword("password123");
        userRegisteredDTO.setRole("USER");
    }

    @Test
    public void testUserRegisteredDTOFields() {
        assertEquals("John Doe", userRegisteredDTO.getName());
        assertEquals("john.doe@example.com", userRegisteredDTO.getEmail_id());
        assertEquals("password123", userRegisteredDTO.getPassword());
        assertEquals("USER", userRegisteredDTO.getRole());
    }

    @Test
    public void testUserRegisteredDTOParameterizedConstructor() {
        UserRegisteredDTO user = new UserRegisteredDTO("john.doe@example.com", "John Doe", "password123", "USER");
        assertEquals("John Doe", user.getName());
        assertEquals("john.doe@example.com", user.getEmail_id());
        assertEquals("password123", user.getPassword());
        assertEquals("USER", user.getRole());
    }
}
