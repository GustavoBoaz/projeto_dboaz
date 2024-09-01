package com.dboaz.utils.handlers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dboaz.utils.enums.SystemCodeEnum;
import com.dboaz.utils.exceptions.GlobalException;
import com.dboaz.utils.models.CustomAlert;

/**
 * Global Exception Handler for managing exceptions across the application.
 *
 * <p>
 * The {@code GlobalExceptionHandler} class is annotated with {@link ControllerAdvice}, 
 * making it a centralized point for handling exceptions in a Spring Boot application. 
 * This handler intercepts exceptions thrown by any controller across all modules that 
 * depend on this class, ensuring consistent and standardized error responses.
 * 
 * Example usage:
 *
 * <pre>
 * {@code
 *   @ExceptionHandler(GlobalException.class)
 *   public ResponseEntity<Map<String, Object>> handleGlobalException(GlobalException ex) {
 *       return ResponseEntity.status(ex.getStatus()).body(ex.toJson());
 *   }
 * }
 * </pre>
 * 
 * This class defines two primary exception handlers:
 * 
 * 1. **GlobalException Handler**: Captures and processes exceptions of type {@link GlobalException}. 
 *    It converts the exception details into a JSON response with the appropriate HTTP status code.
 * 
 * 2. **Generic Exception Handler**: Captures any other unhandled exceptions, wraps them into a 
 *    {@link GlobalException} with a generic internal server error code, and returns a standardized 
 *    error response.
 * 
 * This handler ensures that any unhandled exceptions in your application are caught and converted 
 * into meaningful error messages, which are returned to the client in a consistent format.
 * 
 * <b>Note:</b> As this handler is part of the global error-handling mechanism, it will affect 
 * all modules that depend on it, ensuring that error handling is centralized and uniform across 
 * the entire application.
 * </p>
 *
 * @author GustavoBoaz
 * @version 1.0.0
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles generic exceptions not specifically caught by other handlers.
     *
     * @param ex the exception to handle
     * @return a {@link ResponseEntity} containing a generic error response in JSON format
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        var exception = GlobalException.builder()
            .status(500)
            .alert(new CustomAlert(SystemCodeEnum.C0001DB))
            .build();

        return ResponseEntity.status(500).body(exception.toJson());
    }

    /**
     * Handles exceptions of type {@link GlobalException}.
     *
     * @param ex the {@link GlobalException} to handle
     * @return a {@link ResponseEntity} containing the error details in JSON format
     */
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(GlobalException ex) {
        return ResponseEntity.status(ex.getStatus()).body(ex.toJson());
    }
}