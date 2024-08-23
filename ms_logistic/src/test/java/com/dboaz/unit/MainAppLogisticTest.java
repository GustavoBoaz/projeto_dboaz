package com.dboaz.unit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.dboaz.MainAppLogistic;

class MainAppLogisticTest {

    @Test
    public void testMainMethodExist() {
        assertTrue(hasMainMethod(MainAppLogistic.class));
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
