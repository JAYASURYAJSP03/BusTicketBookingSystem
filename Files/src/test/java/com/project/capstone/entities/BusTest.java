package com.project.capstone.entities;

import com.project.capstone.entity.Bus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BusTest {

    private Bus bus;

    @BeforeEach
    public void setUp() {
        bus = new Bus();
        bus.setBusName("Express");
        bus.setSource("City A");
        bus.setDestination("City B");
        bus.setPrice(30.0);
        bus.setDate("2023-12-01");
        bus.setTime("08:00 AM");
    }

    @Test
    public void testBusFields() {
        assertEquals("Express", bus.getBusName());
        assertEquals("City A", bus.getSource());
        assertEquals("City B", bus.getDestination());
        assertEquals(30.0, bus.getPrice());
        assertEquals("2023-12-01", bus.getDate());
        assertEquals("08:00 AM", bus.getTime());
    }
}
