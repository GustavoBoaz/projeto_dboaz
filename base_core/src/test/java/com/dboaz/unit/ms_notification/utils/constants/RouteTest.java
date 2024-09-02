package com.dboaz.unit.ms_notification.utils.constants;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dboaz.ms_notification.utils.constants.Route;

class RouteTest {

    @Test
    void testGetInfo() {
        Route route = new Route();

        assertEquals(Route.GET_INFO, route.getInfo(), "The method getInfo dont return " + Route.GET_INFO);
    }
}
