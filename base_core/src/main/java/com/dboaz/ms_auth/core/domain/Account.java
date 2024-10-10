package com.dboaz.ms_auth.core.domain;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dboaz.ms_auth.core.mappers.AccountMapper;
import com.dboaz.ms_auth.core.enums.RoleType;
import com.dboaz.ms_auth.core.enums.StatusType;

/**
 * Represents an account in the system.
 * This is a domain class, which means it represents a business entity in the domain layer of the application.
 * The domain layer is responsible for representing business concepts, information, and rules.
 *
 * <p>This class uses the Builder design pattern to create instances of {@code Account}.
 * The Builder pattern is a creation design pattern that allows for the step-by-step creation of complex objects.
 * It provides a way to construct a complex object by specifying its type and content, and separating the construction process from the representation.</p>
 *
 * <p>The {@code ZONE_ID} is set to "America/Sao_Paulo" for all instances.</p>
 *
 * <p>The date and time are formatted using the pattern "yyyy-MM-dd HH:mm:ss". This format is used for the {@code createdAt} and {@code updatedAt} fields.</p>
 *
 * <p>Example of usage:</p>
 * <pre>
 * {@code
 * Account account = Account.builder()
 *     .id()
 *     .login("user123")
 *     .email("user123@example.com")
 *     .password("password")
 *     .status(StatusType.ACTIVE)
 *     .roles(Set.of(RoleType.USER))
 *     .keys()
 *     .createdAt()
 *     .updatedAt()
 *     .build();
 * }
 * </pre>
 *
 * <p>Example of converting from AccountMapper to Account:</p>
 * <pre>
 * {@code
 * AccountMapper mapper = // obtain instance of AccountMapper
 * Account account = Account.toAccount(mapper);
 * }
 * </pre>
 *
 * @since 1.0
 * @author GustavoBoaz
 */
public class Account {

    private static final ZoneId ZONE_ID = ZoneId.of("America/Sao_Paulo");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final SecureRandom secureRandom = new SecureRandom();

    private String id;
    private String login;
    private String email;
    private String password;
    private StatusType status;
    private Set<RoleType> roles;
    private Set<String> keys;
    private String createdAt;
    private String updatedAt;

    public Account() {}

    /**
     * Creates a new Account builder.
     *
     * @return a new Account instance.
     */
    public static Account builder() {
        return new Account();
    }

    public Account id() { this.id = generatorId(); return this; }
    public Account id(String id) { this.id = id; return this; }
    public Account login(String login) { this.login = login; return this; }
    public Account email(String email) { this.email = email; return this; }
    public Account password(String password) { this.password = password; return this; }
    public Account status(StatusType status) { this.status = status; return this; }
    public Account roles(Set<RoleType> roles) { this.roles = roles; return this; }
    public Account keys() { this.keys = generatorKeys(3); return this; }
    public Account keys(Integer limit) { this.keys = generatorKeys(limit); return this; }
    public Account keys(Set<String> keys) { this.keys = keys; return this; }
    public Account createdAt() { this.createdAt = LocalDateTime.now(ZONE_ID).format(FORMATTER); return this; }
    public Account createdAt(String createdAt) { this.createdAt = createdAt; return this; }
    public Account updatedAt() { this.updatedAt = LocalDateTime.now(ZONE_ID).format(FORMATTER); return this; }
    public Account updatedAt(String updatedAt) { this.updatedAt = updatedAt; return this; }

    /**
     * Builds and returns the Account instance.
     *
     * @return the built Account instance.
     */
    public Account build() { return this; }

    /**
     * Converts an AccountMapper to an Account.
     *
     * @param mapper the AccountMapper instance.
     * @return the converted Account instance.
     */
    public static Account toAccount(AccountMapper mapper) {
        return Account.builder()
            .id(mapper.getId())
            .login(mapper.getLogin())
            .email(mapper.getEmail())
            .password(mapper.getPassword())
            .status(mapper.getStatus())
            .roles(mapper.getRoles())
            .keys(mapper.getKeys())
            .createdAt(mapper.getCreatedAt())
            .updatedAt(mapper.getUpdatedAt())
            .build();
    }

    /**
     * Generates a set of keys.
     *
     * @param limit the number of keys to generate.
     * @return a set of generated keys.
     */
    protected static Set<String> generatorKeys(Integer limit) {
        IToken key = Account::generateToken;

        ISetKey keys = () -> Stream
            .generate(key::generate)
            .limit(Math.max(limit, 3))
            .collect(Collectors.toSet());

        return keys.generate();
    }

    /**
     * Generates a unique ID.
     *
     * @return the generated ID.
     */
    protected static String generatorId() {
        IKey key = () -> UUID.randomUUID().toString();
        return key.generate();
    }

    /**
     * Generates a token using the current timestamp and a random number.
     *
     * @return the generated token. ex - 17f9343c5c114ed6a
     */
    protected static String generateToken() {
        long currentTimeMillis = System.currentTimeMillis();
        int randomInt = secureRandom.nextInt();
        return Long.toHexString(currentTimeMillis) + Integer.toHexString(randomInt);
    }

    // Getters
    public String getId() { return this.id; }
    public String getLogin() { return this.login; }
    public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }
    public StatusType getStatus() { return this.status; }
    public Set<RoleType> getRoles() { return this.roles; }
    public Set<String> getKeys() { return this.keys; }
    public String getCreatedAt() { return this.createdAt; }
    public String getUpdatedAt() { return this.updatedAt; }

    // Setters
    public void setLogin(String login) { this.login = login; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setStatus(StatusType status) { this.status = status; }
    public void setRoles(Set<RoleType> roles) { this.roles = roles; }
    protected void setKeys(Set<String> keys) { this.keys = keys; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }

    protected interface IKey {
        String generate();
    }

    protected interface IToken {
        String generate();
    }

    protected interface ISetKey {
        Set<String> generate();
    }
}
