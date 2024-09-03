package com.dboaz.unit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.dboaz.MainAppGateway;

class MainAppGatewayTest {

    @Test
    void testMainMethodExist() {
        String[] args = {};

        assertTrue(hasMainMethod(MainAppGateway.class));

        try {
            MainAppGateway.main(args);
        } catch (Exception e) {
            fail("Expected no exception to be thrown, but got: " + e.getMessage());
        }
    }

    private boolean hasMainMethod(Class<?> clazz) {
        try {
            clazz.getDeclaredMethod("main", String[].class);
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }
}
