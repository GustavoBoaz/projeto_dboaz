package com.dboaz.unit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.dboaz.MainAppPayment;

class MainAppPaymentTest {

    @Test
    void testMainMethodExist() {
        String[] args = {};

        assertTrue(hasMainMethod(MainAppPayment.class));

        try {
            MainAppPayment.main(args);
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
