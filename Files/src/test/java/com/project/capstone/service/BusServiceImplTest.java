package com.project.capstone.service;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.project.capstone.entity.Bus;
import com.project.capstone.repository.BusRepository;
import com.project.capstone.service.impl.BusServiceImpl;
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
class BusServiceImplTest {

    @Mock
    private BusRepository busRepository;

    @InjectMocks
    private BusServiceImpl busService;

    @Test
    void testGetAllBuses() {
        List<Bus> busList = Arrays.asList(new Bus(), new Bus());

        when(busRepository.findAll()).thenReturn(busList);

        List<Bus> result = busService.getAllBuses();

        assertEquals(2, result.size());
    }

    @Test
    void testSaveBus() {
        Bus bus = new Bus();
        busService.saveBus(bus);

        verify(busRepository, times(1)).save(bus);
    }

    @Test
    void testGetById() {
        Bus bus = new Bus();
        bus.setId(1L);

        when(busRepository.findById(1L)).thenReturn(Optional.of(bus));

        Bus result = busService.getById(1L);

        assertNotNull(result);
    }

    @Test
    void testDeleteById() {
        busService.deleteById(1L);

        verify(busRepository, times(1)).deleteById(1L);
    }
}
