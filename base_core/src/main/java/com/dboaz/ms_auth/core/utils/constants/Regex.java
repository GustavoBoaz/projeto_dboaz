package com.dboaz.ms_auth.core.utils.constants;

/**
 * The {@code Regex} class contains regular expression patterns for validating login and password.
 * <p>
 * These patterns can be used to ensure that logins and passwords meet the specified security requirements.
 * </p>
 * 
 * @author GustavoBoaz
 * @since 1.0
 */
public class Regex {

    /**
     * Regular expression pattern for validating login.
     * The login must be at least 8 characters lowercase letters, numbers, - _ .,  followed by "@dboaz.app".
     */
    public static final String LOGIN = "^[a-z0-9_.-]{8,}@dboaz.app$";

    /**
     * Regular expression pattern for validating email.
     * The email must be at least 8 letters followed by "@".
     */
    public static final String EMAIL = "^(?=.*[@]).{10,}$";
    
    /**
     * Regular expression pattern for validating password.
     * The password must be at least 15 characters long, containing at least one lowercase letter,
     * one uppercase letter, one digit, and one special character !?@#$%&.
     */    
    public static final String PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!?@#$%&]).{15,}$";
}
