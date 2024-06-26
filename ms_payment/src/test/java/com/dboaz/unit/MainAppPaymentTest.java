package com.dboaz.unit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dboaz.MainAppPayment;
import com.dboaz.properties.ApplicationProperties;

import org.junit.jupiter.api.Test;

class MainAppPaymentTest {
    private static final Logger LOGGER = LogManager.getLogger(MainAppPaymentTest.class);
    private static final String APP_NAME = ApplicationProperties.test("app.name");
    private static final String ENVIROMENT = ApplicationProperties.test("enviroment");

    @Test
    void testMainMethodExists() {
        LOGGER.info("[ INIT TEST [ app: {} | env: {} ] - testMainMethodExists ]", APP_NAME, ENVIROMENT);

        assertTrue(hasMainMethod(MainAppPayment.class), "O método main não foi encontrado na classe MainAppPayment");

        LOGGER.info("[ FINISH TEST [ app: {} | env: {} ] - testMainMethodExists ]", APP_NAME, ENVIROMENT);
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
