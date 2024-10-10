package com.dboaz.ms_auth.core.mappers;

import java.io.Serializable;
import java.util.Set;
import com.dboaz.ms_auth.core.enums.RoleType;
import com.dboaz.ms_auth.core.enums.StatusType;
import com.dboaz.ms_auth.core.domain.Account;

/**
 * The {@code AccountMapper} class represents a Data Transfer Object (DTO) for the {@code Account} entity.
 * It encapsulates the data required to represent an account, including an ID, login credentials,
 * assigned roles, and a set of keys.
 * <p>
 * This class provides helper methods to convert between {@code Account} and {@code AccountMapper} objects.
 * </p>
 *
 * <p>
 * A mapper is a design pattern used to separate the domain model from the data transfer objects (DTOs).
 * It helps in converting complex objects to simpler representations that can be easily transferred over the network or used in different layers of the application.
 * </p>
 *
 * <p>
 * In the context of persistence, an entity represents a table in a database, and each instance of the entity represents a row in that table.
 * The {@code Account} class is an example of an entity that would be persisted in the database.
 * The {@code AccountMapper} class is used to transfer data between different layers of the application, such as from the database layer to the service layer.
 * </p>
 *
 * <p>
 * Mappers are particularly useful when you want to decouple your domain model from the representation used in the presentation layer or when transferring data over the network.
 * They help in maintaining a clean separation of concerns and make the code more maintainable and testable.
 * </p>
 *
 * <p>Example of usage:</p>
 * <pre>
 * {@code
 * Account account = // obtain Account instance
 * AccountMapper mapper = AccountMapper.fromAccount(account);
 *
 * // Convert back to Account
 * Account accountFromMapper = mapper.toAccount();
 * }
 * </pre>
 *
 * @author GustavoBoaz
 * @since 1.0
 */
public class AccountMapper implements Serializable {

    private String id;
    private String login;
    private String email;
    private String password;
    private StatusType status;
    private Set<RoleType> roles;
    private Set<String> keys;
    private String createdAt;
    private String updatedAt;

    // Default constructor
    public AccountMapper() {}

    // Parameterized constructor
    public AccountMapper(
        String id,
        String login,
        String email,
        String password,
        StatusType status,
        Set<RoleType> roles,
        Set<String> keys,
        String createdAt,
        String updatedAt
    ) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.status = status;
        this.roles = roles;
        this.keys = keys;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters
    public String getId() { return id; }
    public String getLogin() { return login; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public StatusType getStatus() { return status; }
    public Set<RoleType> getRoles() { return roles; }
    public Set<String> getKeys() { return keys; }
    public String getCreatedAt() { return createdAt; }
    public String getUpdatedAt() { return updatedAt; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setLogin(String login) { this.login = login; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setStatus(StatusType status) { this.status = status; }
    public void setRoles(Set<RoleType> roles) { this.roles = roles; }
    public void setKeys(Set<String> keys) { this.keys = keys; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }

    /**
     * Creates an {@code AccountMapper} instance from an {@code Account} object.
     * This method maps all properties from the {@code Account} to the {@code AccountMapper}.
     *
     * @param account the {@code Account} object to convert
     * @return a new {@code AccountMapper} instance with the data from the {@code Account}
     */
    public static AccountMapper fromAccount(Account account) {
        return new AccountMapper(
            account.getId(),
            account.getLogin(),
            account.getEmail(),
            account.getPassword(),
            account.getStatus(),
            account.getRoles(),
            account.getKeys(),
            account.getCreatedAt(),
            account.getUpdatedAt()
        );
    }

    /**
     * Converts the current {@code AccountMapper} instance back into an {@code Account} object.
     * This method maps all properties from the {@code AccountMapper} to the corresponding {@code Account}.
     *
     * @return an {@code Account} object based on the data from this {@code AccountMapper}
     */
    public Account toAccount() {
        return Account.toAccount(this);
    }
}
