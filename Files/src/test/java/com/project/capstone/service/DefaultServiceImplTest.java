package com.project.capstone.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.project.capstone.dto.UserRegisteredDTO;
import com.project.capstone.entity.Role;
import com.project.capstone.entity.User;
import com.project.capstone.repository.RoleRepository;
import com.project.capstone.repository.UserRepository;
import com.project.capstone.service.impl.DefaultUserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@SpringBootTest
class DefaultUserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private DefaultUserServiceImpl userService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoadUserByUsername_UserExists() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("encodedPassword");

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));

        UserDetails userDetails = userService.loadUserByUsername("test@example.com");

        assertEquals("test@example.com", userDetails.getUsername());
    }

    @Test
    void testLoadUserByUsername_UserNotFound() {
        when(userRepository.findByEmail("nonexistent@example.com")).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername("nonexistent@example.com"));
    }

    @Test
    void testSave_User() {
        UserRegisteredDTO dto = new UserRegisteredDTO("user@example.com", "User", "password", "USER");
        Role role = new Role();
        role.setRole("USER");

        when(roleRepository.findByRole("USER")).thenReturn(role);
        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");

        User savedUser = userService.save(dto);

        assertEquals("user@example.com", savedUser.getEmail());
        verify(userRepository, times(1)).save(any(User.class));
    }
}
