package com.dboaz.ms_auth.dtos;

import java.util.Set;
import com.dboaz.ms_auth.enums.RoleType;
import com.dboaz.ms_auth.models.Account;

/**
 * The {@code AccountDto} record represents a Data Transfer Object (DTO) for the {@code Account} entity.
 * It encapsulates the data required to represent an account, including an ID, login credentials, 
 * assigned roles, and a set of keys.
 * <p>
 * This record provides helper methods to convert between {@code Account} and {@code AccountDto} objects.
 * </p>
 * 
 * @param id        the unique identifier for the account
 * @param login     the login name of the account
 * @param password  the password of the account
 * @param roles     a set of roles assigned to the account
 * @param keys      a set of keys generated for the account
 *
 * @author GustavoBoaz
 * @since 1.0
 */
public record AccountDto(
    String id,
    String login,
    String password,
    Set<RoleType> roles,
    Set<String> keys
) {

    /**
     * Creates an {@code AccountDto} instance from an {@code Account} object.
     * This method maps all properties from the {@code Account} to the {@code AccountDto}.
     * 
     * @param account the {@code Account} object to convert
     * @return a new {@code AccountDto} instance with the data from the {@code Account}
     */
    public static AccountDto fromAccount(Account account) {
        return new AccountDto(
            account.getId(),
            account.getLogin(),
            account.getPassword(),
            account.getRoles(),
            account.getKeys()
        );
    }

    /**
     * Converts the current {@code AccountDto} instance back into an {@code Account} object.
     * This method maps all properties from the {@code AccountDto} to the corresponding {@code Account}.
     * 
     * @return an {@code Account} object based on the data from this {@code AccountDto}
     */
    public Account toAccount() {
        return Account.toAccount(this);
    }
}
