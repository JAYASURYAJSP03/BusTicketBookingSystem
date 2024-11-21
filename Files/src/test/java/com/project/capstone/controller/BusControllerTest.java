package com.project.capstone.controller;

import com.project.capstone.controller.BusController;
import com.project.capstone.entity.Bus;
import com.project.capstone.service.BusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BusControllerTest {

    @InjectMocks
    private BusController busController;

    @Mock
    private BusService busService;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllBuses() {
        String viewName = busController.getAllBuses(model);

        assertEquals("AllBuses", viewName);
        verify(busService).getAllBuses();
    }

    @Test
    public void testAddPage() {
        String viewName = busController.addPage(model);

        assertEquals("AddBus", viewName);
        verify(model).addAttribute(eq("bus"), any(Bus.class));
    }
}
