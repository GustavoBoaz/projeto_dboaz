package com.dboaz.utils.exceptions;

import java.util.Map;

import com.dboaz.utils.models.CustomAlert;

/**
 * Model Class for feature Global Custom Alert
 *
 * <p>
 * The {@code GlobalException} class is a custom exception designed to handle global errors 
 * in the system, particularly those related to custom alerts. This class leverages the 
 * builder pattern to allow for flexible and fluent construction of exceptions with 
 * detailed information, including a status code and an alert message.
 * 
 * Example usage:
 * 
 * <pre>
 * {@code
 *   CustomAlert alert = new CustomAlert(SystemCodeEnum.C0001DB, "Additional details");
 *   GlobalException exception = GlobalException.builder()
 *       .status(500)
 *       .alert(alert)
 *       .build();
 *   
 *   throw exception;
 * }
 * </pre>
 * 
 * The {@code GlobalException} can be used to encapsulate error details and convert 
 * them into a JSON representation for API responses, making it easier to standardize 
 * error handling across the application.
 * 
 * The exception can be mapped to JSON format using the {@link #toJson()} method, 
 * which returns a {@code Map<String, Object>} containing the error message, status, 
 * and alert details.
 * 
 * <b>Important:</b> When using this exception, always ensure that a corresponding 
 * {@code CustomAlert} is provided to give context to the error being handled.
 * </p>
 * 
 * @author GustavoBoaz
 * @version 1.0.0
 **/
public class GlobalException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    // Atributes
    private String message;
    private Integer status;
    private CustomAlert alert;

    // Construct Pattern - Builder
    public static GlobalException builder() { return new GlobalException(); }

    public GlobalException status(Integer status) { this.status = status; return this; }
    public GlobalException alert(CustomAlert alert) {
        this.alert = alert;
        this.message = alert.getCode().getProblem();
        return this;
    }

    public GlobalException build() { return this; }

    // Getters
    @Override public String getMessage() { return this.message; }
    public Integer getStatus() { return this.status; }
    public CustomAlert getAlert() { return this.alert; }

    // Mapper to Json
    public Map<String, Object> toJson() {
        return Map.of(
            "message", this.message,
            "status", this.status,
            "alert", this.alert
        );
    }
}