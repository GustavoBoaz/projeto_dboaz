package com.dboaz.ms_auth.core.interfaces;

import com.dboaz.ms_auth.core.domain.Account;
import com.dboaz.utils.exceptions.GlobalException;

/**
 * The {@code ValidationDto} interface defines the contract for validation and conversion operations
 * for Data Transfer Objects (DTOs) in the system.
 * <p>
 * Implementations of this interface are responsible for validating the data contained within the DTO
 * and converting it into an {@code Account} object. This ensures that all incoming data from external
 * sources is properly validated before being processed by the system.
 * </p>
 *
 * <p>DTOs implementing this interface should not contain any business logic. Instead, they should focus
 * on data validation and conversion to ensure the integrity and correctness of the data being processed.</p>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * public class SomeDto implements ValidationDto {
 *     private String id;
 *     private String email;
 *
 *     @Override
 *     public Account validate() throws GlobalException {
 *         // Perform validation logic
 *         if (id == null || !isValidUUID(id)) {
 *             throw new GlobalException("Invalid ID");
 *         }
 *         if (email == null || !isValidEmail(email)) {
 *             throw new GlobalException("Invalid email");
 *         }
 *         // Convert to Account object
 *         return Account.builder().id(id).email(email).build();
 *     }
 * }
 * }</pre>
 *
 * <p>In this example, the {@code SomeDto} class implements the {@code ValidationDto} interface,
 * providing a concrete implementation of the {@code validate} method to ensure the data is valid
 * and converting it into an {@code Account} object.</p>
 *
 * @author GustavoBoaz
 * @since 1.0
 */
public interface ValidationDto {

    /**
     * Validates the data according to the implementation's specific rules.
     * <p>
     * This method should be called to ensure that the data meets all necessary validation criteria.
     * If the validation fails, a {@code GlobalException} should be thrown to indicate the error.
     * </p>
     *
     * @throws GlobalException if the validation fails
     * @return an {@code Account} object representing the validated data
     */
    Account validate() throws GlobalException;
}
