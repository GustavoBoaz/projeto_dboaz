package com.dboaz.unit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import com.dboaz.MainAppAuth;

@ActiveProfiles("test")
class MainAppAuthTest {

    @Test
    void testMainMethodExist() {
        assertTrue(hasMainMethod(MainAppAuth.class));
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
