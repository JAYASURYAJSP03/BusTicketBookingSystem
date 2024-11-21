package com.project.capstone.entities;
import com.project.capstone.entity.Role;
import com.project.capstone.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setName("Test User");
        user.setEmail("testuser@example.com");
        user.setPassword("password123");

        Role role = new Role();
        role.setRole("USER");

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
    }

    @Test
    public void testUserFields() {
        assertEquals("Test User", user.getName());
        assertEquals("testuser@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testUserRoles() {
        assertNotNull(user.getRoles());
        assertEquals(1, user.getRoles().size());
        assertEquals("USER", user.getRoles().iterator().next().getRole());
    }
}

