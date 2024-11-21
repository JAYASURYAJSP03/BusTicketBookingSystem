package com.project.capstone.controller;

import com.project.capstone.controller.HomeController;
import com.project.capstone.dto.FindDto;
import com.project.capstone.entity.Bus;
import com.project.capstone.service.BusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class HomeControllerTest {

    @InjectMocks
    private HomeController homeController;

    @Mock
    private BusService busService;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFind() {
        String viewName = homeController.find(model);

        assertEquals("searchBuses", viewName);
        verify(model).addAttribute(eq("findDto"), any(FindDto.class));
    }

    @Test
    public void testFindBus() {
        FindDto findDto = new FindDto();
        findDto.setSource("Source");
        findDto.setDestination("Destination");
        findDto.setDate("2024-11-21");

        when(busService.find(anyString(), anyString(), anyString())).thenReturn(List.of(new Bus()));

        String viewName = homeController.findBus(findDto, model);

        assertEquals("searchBuses", viewName);
        verify(model).addAttribute(eq("findBuses"), anyList());
    }
}
