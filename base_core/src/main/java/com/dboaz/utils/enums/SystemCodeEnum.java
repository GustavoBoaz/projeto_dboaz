package com.dboaz.utils.enums;

/**
 * Enum for feature Global Custom alert
 *
 * <p>
 * The {@code SystemCodeEnum} is designed to define standard system codes with associated
 * problem descriptions and recommended actions. This enum is particularly useful for
 * handling and categorizing error messages across the system.
 *
 * Example usage:
 *
 * <pre>
 * {@code
 *   SystemCodeEnum code = SystemCodeEnum.C0001DB;
 *   String problem = code.getProblem(); // "Internal server error"
 *   String action = code.getAction();   // "Try a connection at another time"
 * }
 * </pre>
 *
 * You can also use this enum in exception handling or logging to standardize
 * error messages and suggested user actions.
 *
 * Whenever a new error or potential business-related error needs to be mapped
 * in the system, it is important to add a new code to this enum. This ensures
 * consistency in how errors are handled and reported across the application.
 * </p>
 *
 * @author GustavoBoaz
 * @version 1.0.0
 **/
public enum SystemCodeEnum {
    C001DB("Internal server error", "Try a connection at another time"),
    C002DB("Not found", "The resource is not available"),
    C020DB("Failed generate key pair", "Contact team developer");

private final String problem;
    private final String action;

    private SystemCodeEnum(String problem, String action) {
        this.problem = problem;
        this.action = action;
    }

    public String getProblem() {
        return this.problem;
    }

    public String getAction() {
        return this.action;
    }
}
