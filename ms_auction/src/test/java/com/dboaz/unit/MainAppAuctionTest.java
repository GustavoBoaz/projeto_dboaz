package com.dboaz.unit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.dboaz.MainAppAuction;

class MainAppAuctionTest {

    @Test
    public void testMainMethodExist() {
        assertTrue(hasMainMethod(MainAppAuction.class));
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
