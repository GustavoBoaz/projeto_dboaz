package com.dboaz.unit.utils.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dboaz.utils.enums.SystemCodeEnum;
import com.dboaz.utils.models.CustomAlert;

class CustomAlertTest {

    @Test
    void testCustomAlertWithC0001DB() {
        // Arrange
        SystemCodeEnum code = SystemCodeEnum.C0001DB;
        
        // Act
        CustomAlert alert = new CustomAlert(code);
        
        // Assert
        assertEquals(code, alert.getCode());
        assertEquals(code.getAction(), alert.getAction());
    }

    @Test
    void testCustomAlertWithC0002DB() {
        // Arrange
        SystemCodeEnum code = SystemCodeEnum.C0002DB;
        
        // Act
        CustomAlert alert = new CustomAlert(code);
        
        // Assert
        assertEquals(code, alert.getCode());
        assertEquals(code.getAction(), alert.getAction());
    }
}
