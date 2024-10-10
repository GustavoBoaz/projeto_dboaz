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
    // RANGE resources in application ---- //
    C001DB("Internal server error", "Try a connection at another time"),
    C002DB("Not found", "The resource is not available"),
    C003DB("Command not found", "Provide valid command type operation"),
    C004DB("Query not found", "Provide valid query type operation"),
    C005DB("The resource login is already registered in the system", "Try another login"),
    C020DB("Failed generate key pair", "Contact team developer"),
    // RANGE Validations ---- //
    C030DB("Field cannot be null or blank", "Fix field"),
    C031DB("It must be at least 5 characters long, lowercase, and follow the format 'example@dboaz.app'.", "Fix login format"),
    C032DB("It must contain at least 15 characters, including uppercase, lowercase, numbers, and special characters.", "Fix password format"),
    C033DB("Role cannot be null", "Provide existing roles"),
    C034DB("Role does not exist", "Provide existing roles"),
    C035DB("Invalid security key", "Provide valid keys"),
    C036DB("Null pointer",  "Provide valid key"),
    // RANGE Authentication and Authorization ---- //
    C040DB("Invalid credentials", "Provide valid login and password"),
    C041DB("Internal error Jwt", "Contact team developer"),
    C042DB("Account account already exist", "Choose anoher email");

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
