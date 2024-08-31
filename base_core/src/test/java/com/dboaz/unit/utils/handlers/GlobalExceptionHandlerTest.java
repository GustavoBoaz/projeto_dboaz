package com.dboaz.unit.utils.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dboaz.utils.enums.SystemCodeEnum;
import com.dboaz.utils.exceptions.GlobalException;
import com.dboaz.utils.handlers.GlobalExceptionHandler;
import com.dboaz.utils.models.CustomAlert;

class GlobalExceptionHandlerTest {

    @Test
    void testHandleGenericException() {
        // Arrange
        var handler = new GlobalExceptionHandler();
        var exception = GlobalException.builder()
            .status(500)
            .alert(new CustomAlert(SystemCodeEnum.C0001DB))
            .build();

        // Act
        ResponseEntity<Map<String, Object>> response = handler.handleGenericException(exception);
        var alert = (CustomAlert) response.getBody().get("alert");
        
        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

        assertNotNull(response.getBody().get("message"), "The response dont contain message");
        assertNotNull(response.getBody().get("status"), "The response dont contain status");
        assertNotNull(response.getBody().get("alert"), "The response dont contain alert");

        // Validate alert fields
        assertEquals(SystemCodeEnum.C0001DB, alert.getCode(), "The alert code is not valid");
        assertEquals("Try a connection at another time", alert.getAction(), "The alert action is not valid");
    }

    @Test
    void testHandleGlobalException() {
        // Arrange
        var handler = new GlobalExceptionHandler();
        var exception = GlobalException.builder()
            .status(404)
            .alert(new CustomAlert(SystemCodeEnum.C0002DB))
            .build();

        // Act
        ResponseEntity<Map<String, Object>> response = handler.handleGlobalException(exception);
        var alert = (CustomAlert) response.getBody().get("alert");
        
        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        assertNotNull(response.getBody().get("message"), "The response dont contain message");
        assertNotNull(response.getBody().get("status"), "The response dont contain status");
        assertNotNull(response.getBody().get("alert"), "The response dont contain alert");

        // Validate alert fields
        assertEquals(SystemCodeEnum.C0002DB, alert.getCode(), "The alert code is not valid");
        assertEquals("Certify your request", alert.getAction(), "The alert action is not valid");
    }
}
