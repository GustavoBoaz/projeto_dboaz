package com.dboaz.unit.utils.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.NoHandlerFoundException;

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
            .alert(new CustomAlert(SystemCodeEnum.C001DB))
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
        assertEquals(SystemCodeEnum.C001DB, alert.getCode(), "The alert code is not valid");
        assertEquals("Try a connection at another time", alert.getAction(), "The alert action is not valid");
    }

    @Test
    void testHandleGlobalException() {
        // Arrange
        var handler = new GlobalExceptionHandler();
        var exception = GlobalException.builder()
            .status(404)
            .alert(new CustomAlert(SystemCodeEnum.C002DB))
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
        assertEquals(SystemCodeEnum.C002DB, alert.getCode(), "The alert code is not valid");
        assertEquals("The resource is not available", alert.getAction(), "The alert action is not valid");
    }

    @Test
    void testHandleNotFoundException() {
        // Arrange
        var handler = new GlobalExceptionHandler();
        var exception = new NoHandlerFoundException("GET", "/invalid-url", null);

        // Act
        ResponseEntity<Map<String, Object>> response = handler.handleNotFoundException(exception);
        var alert = (CustomAlert) response.getBody().get("alert");

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        assertNotNull(response.getBody().get("message"), "The response doesn't contain message");
        assertNotNull(response.getBody().get("status"), "The response doesn't contain status");
        assertNotNull(response.getBody().get("alert"), "The response doesn't contain alert");

        // Validate alert fields
        assertEquals(SystemCodeEnum.C002DB, alert.getCode(), "The alert code is not valid");
        assertEquals("The resource is not available", alert.getAction(), "The alert action is not valid");
    }
}
