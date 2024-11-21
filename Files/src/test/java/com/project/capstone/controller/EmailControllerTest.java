package com.project.capstone.controller;

import com.project.capstone.controller.EmailController;
import com.project.capstone.entity.Booking;
import com.project.capstone.repository.BookingRepository;
import com.project.capstone.service.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmailControllerTest {

    @InjectMocks
    private EmailController emailController;

    @Mock
    private EmailService emailService;

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessPayment() throws Exception {
        Booking booking = new Booking();
        booking.setId(1L);
        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));

        String viewName = emailController.processPayment("test@example.com", 1L, model);

        assertEquals("confirmation", viewName);
        verify(emailService).sendEmailWithAttachment(anyString(), anyString(), anyString());
        verify(model).addAttribute("message", "Payment successful! Confirmation email sent with your ticket.");
    }
}
