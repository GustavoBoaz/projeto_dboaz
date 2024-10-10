package com.dboaz.ms_auth.core.utils.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Utility class for handling value encryption and verification using BCrypt.
 * <p>
 * This class provides static methods to encrypt a plain-text value and to verify if a plain-text value
 * matches an encrypted (hashed) value. It uses the BCrypt hashing algorithm, which is a secure way
 * to store passwords as it includes a salt to protect against rainbow table attacks.
 * </p>
 *
 * @author GustavoBoaz
 * @since 1.0
 */
public class Crypt {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * Encrypts the provided plain-text value using the BCrypt algorithm.
     * <p>
     * The method generates a secure hash of the value that includes a random salt.
     * </p>
     *
     * @param value the plain-text value to be encrypted
     * @return the encrypted value (BCrypt hash) that can be safely stored
     */
    public static String encrypt(String value) {
        return encoder.encode(value);
    }

    /**
     * Verifies if a plain-text value matches the provided encrypted (hashed) value.
     * <p>
     * This method uses the {@code matches} method of {@code BCryptPasswordEncoder} to compare
     * the provided plain-text value with the encrypted value.
     * </p>
     *
     * @param rawValue       the plain-text value to be verified
     * @param encryptedValue the encrypted value (BCrypt hash) to compare with the raw value
     * @return {@code true} if the raw value matches the encrypted value, {@code false} otherwise
     */
    public static boolean isMatch(String rawValue, String encryptedValue) {
        return encoder.matches(rawValue, encryptedValue);
    }
}

