package com.dboaz.unit.utils.exceptions;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.dboaz.utils.enums.SystemCodeEnum;
import com.dboaz.utils.exceptions.GlobalException;
import com.dboaz.utils.models.CustomAlert;

class GlobalExceptionTest {

    @Test
    void testGlobalExceptionBuilderWithStatusAndAlert() {
        // Arrange
        Integer status = 404;
        CustomAlert alert = new CustomAlert(SystemCodeEnum.C002DB);

        // Act
        GlobalException exception = GlobalException.builder()
            .status(status)
            .alert(alert)
            .build();

        // Assert
        assertEquals("Not found", exception.getMessage());
        assertEquals(status, exception.getStatus());
        assertEquals(alert, exception.getAlert());
    }

    @Test
    void testGlobalExceptionToJson() {
        // Arrange
        Integer status = 500;
        CustomAlert alert = new CustomAlert(SystemCodeEnum.C001DB);
        GlobalException exception = GlobalException.builder()
            .status(status)
            .alert(alert)
            .build();

        // Act
        Map<String, Object> jsonMap = exception.toJson();

        // Assert
        assertEquals("Internal server error", jsonMap.get("message"));
        assertEquals(status, jsonMap.get("status"));
        assertEquals(alert, jsonMap.get("alert"));
    }

    @Test
    void testGlobalExceptionWithoutAlert() {
        // Arrange
        Integer status = 400;

        // Act
        GlobalException exception = GlobalException.builder()
            .status(status)
            .build();

        // Assert
        assertNull(exception.getMessage());
        assertEquals(status, exception.getStatus());
        assertNull(exception.getAlert());
    }
}
