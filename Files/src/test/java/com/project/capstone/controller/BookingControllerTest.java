package com.project.capstone.controller;

import com.project.capstone.controller.BookingController;
import com.project.capstone.entity.Booking;
import com.project.capstone.entity.Bus;
import com.project.capstone.entity.User;
import com.project.capstone.repository.BusRepository;
import com.project.capstone.repository.UserRepository;
import com.project.capstone.service.BookingService;
import com.project.capstone.service.BusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookingControllerTest {

    @InjectMocks
    private BookingController bookingController;

    @Mock
    private BookingService bookingService;

    @Mock
    private BusRepository busRepository;

    @Mock
    private BusService busService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBooking() {
        Long busId = 1L;
        Bus bus = new Bus();
        bus.setBusName("Test Bus");

        when(busService.getById(busId)).thenReturn(bus);

        String viewName = bookingController.booking(busId, model);

        assertEquals("Booking", viewName);
        verify(model).addAttribute(eq("booking"), any(Booking.class));
    }

    @Test
    public void testBooked() {
        Booking booking = new Booking();
        Bus bus = new Bus();
        bus.setPrice(100.0);
        booking.setBus(bus);
        booking.setNoOfPersons(2);

        when(busRepository.findById(anyLong())).thenReturn(Optional.of(bus));
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(new User()));

        String viewName = bookingController.booked(booking, model);

        assertEquals("pay", viewName);
        verify(bookingService).save(booking);
    }
}

