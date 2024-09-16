
package com.dboaz.ms_auth.models;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dboaz.ms_auth.dtos.AccountDto;
import com.dboaz.ms_auth.enums.RoleType;

/**
 * The {@code Account} class represents an account entity in the system with fields 
 * for managing user credentials, roles, and unique identification keys.
 * This class includes builder methods for convenient object construction and 
 * utility methods for generating IDs and keys.
 * <p>
 * It offers functionalities to create an account, map an {@code AccountDto} to an 
 * {@code Account}, and generate a unique identifier and a set of keys.
 * </p>
 * 
 * @author GustavoBoaz
 * @since 1.0
 */
public class Account {

    /**
     * The maximum number of keys that can be generated for an account.
     */
    private static final Integer LIMIT = 3;

    /**
     * Unique identifier for the account.
     */
    private String id;

    /**
     * The login name for the account.
     */
    private String login;

    /**
     * The password associated with the account.
     */
    private String password;

    /**
     * A set of roles assigned to the account.
     */
    private Set<RoleType> roles;

    /**
     * A set of unique keys generated for the account.
     */
    private Set<String> keys;

    /**
     * Default no-argument constructor.
     */
    public Account() {}

    /**
     * Constructor that initializes the account with login, password, and roles.
     * This constructor also generates an ID and a set of keys for the account.
     * 
     * @param login    the login name for the account
     * @param password the password associated with the account
     * @param roles    a set of roles assigned to the account
     */
    public Account(String login, String password, Set<RoleType> roles) {
        this.id = generatorId();
        this.login = login;
        this.password = password;
        this.roles = roles;
        this.keys = generatorKeys();
    }

    /**
     * Creates a new instance of {@code Account} using the builder pattern.
     * This method sets a generated ID and a set of keys.
     * 
     * @return a new instance of {@code Account}
     */
    public static Account builder() {
        var account = new Account();
        account.setId(generatorId());
        account.setKeys(generatorKeys());
        return account;
    }

    /**
     * Sets the login for the {@code Account} and returns the updated instance.
     * 
     * @param login the login name for the account
     * @return the updated {@code Account} instance
     */
    public Account login(String login) { this.login = login; return this; }

    /**
     * Sets the password for the {@code Account} and returns the updated instance.
     * 
     * @param password the password for the account
     * @return the updated {@code Account} instance
     */
    public Account password(String password) { this.password = password; return this; }

    /**
     * Sets the roles for the {@code Account} and returns the updated instance.
     * 
     * @param roles a set of roles assigned to the account
     * @return the updated {@code Account} instance
     */
    public Account roles(Set<RoleType> roles) { this.roles = roles; return this; }

    /**
     * Completes the building process and returns the constructed {@code Account}.
     * 
     * @return the fully built {@code Account} instance
     */
    public Account build() { return this; }

    /**
     * Converts an {@code AccountDto} to an {@code Account}.
     * This method copies all properties from the DTO to the account.
     * 
     * @param dto the {@code AccountDto} to convert
     * @return the corresponding {@code Account}
     */
    public static Account toAccount(AccountDto dto) {
        var account = new Account();
        account.setId(dto.id());
        account.setLogin(dto.login());
        account.setPassword(dto.password());
        account.setRoles(dto.roles());
        account.setKeys(dto.keys());
        return account;
    }

    /**
     * Generates a set of unique keys using UUIDs, limited by the {@code LIMIT} constant.
     * 
     * @return a set of generated keys
     */
    protected static Set<String> generatorKeys() {
        IKey key = () -> UUID.randomUUID().toString();

        ISetKey keys = () -> Stream
            .generate(key::generate)
            .limit(LIMIT)
            .collect(Collectors.toSet());

        return keys.generate();
    }

    /**
     * Generates a unique ID for the account using a UUID.
     * 
     * @return the generated ID
     */
    protected static String generatorId() {
        IKey key = () -> UUID.randomUUID().toString();
        return key.generate();
    }

    /**
     * Sets the ID of the account.
     * 
     * @param id the unique identifier for the account
     */
    protected void setId(String id) { this.id = id; }

    /**
     * Sets the login of the account.
     * 
     * @param login the login name for the account
     */
    public void setLogin(String login) { this.login = login; }

    /**
     * Sets the password of the account.
     * 
     * @param password the password for the account
     */
    public void setPassword(String password) { this.password = password; }

    /**
     * Sets the roles assigned to the account.
     * 
     * @param roles a set of roles assigned to the account
     */
    public void setRoles(Set<RoleType> roles) { this.roles = roles; }

    /**
     * Sets the keys generated for the account.
     * 
     * @param keys the unique keys generated for the account
     */
    protected void setKeys(Set<String> keys) { this.keys = keys; }

    /**
     * Gets the unique ID of the account.
     * 
     * @return the ID of the account
     */
    public String getId() { return this.id; }

    /**
     * Gets the login name of the account.
     * 
     * @return the login of the account
     */
    public String getLogin() { return this.login; }

    /**
     * Gets the password of the account.
     * 
     * @return the password of the account
     */
    public String getPassword() { return this.password; }

    /**
     * Gets the roles assigned to the account.
     * 
     * @return a set of roles assigned to the account
     */
    public Set<RoleType> getRoles() { return this.roles; }

    /**
     * Gets the keys generated for the account.
     * 
     * @return a set of keys generated for the account
     */
    public Set<String> getKeys() { return this.keys; }

    /**
     * Interface for generating a single key.
     */
    protected interface IKey { 
        /**
         * Generates a single key.
         * 
         * @return the generated key
         */
        String generate(); 
    }

    /**
     * Interface for generating a set of keys.
     */
    protected interface ISetKey { 
        /**
         * Generates a set of keys.
         * 
         * @return the generated set of keys
         */
        Set<String> generate(); 
    }
}
