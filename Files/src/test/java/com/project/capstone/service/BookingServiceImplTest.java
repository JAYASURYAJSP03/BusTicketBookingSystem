package com.project.capstone.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.project.capstone.entity.Booking;
import com.project.capstone.repository.BookingRepository;
import com.project.capstone.repository.UserRepository;
import com.project.capstone.service.impl.BookingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class BookingServiceImplTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    void testSaveBooking() {
        Booking booking = new Booking();
        bookingService.save(booking);

        verify(bookingRepository, times(1)).save(booking);
    }

    @Test
    void testGetAllById() {
        List<Booking> bookings = Arrays.asList(new Booking(), new Booking());

        when(userRepository.findBookingsByUserId(1L)).thenReturn(bookings);

        List<Booking> result = bookingService.getAllById(1L);

        assertEquals(2, result.size());
    }

    @Test
    void testGetById() {
        Booking booking = new Booking();
        booking.setId(1L);

        when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));

        Booking result = bookingService.getById(1L);

        assertNotNull(result);
    }
}
