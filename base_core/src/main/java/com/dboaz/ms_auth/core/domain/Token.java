package com.dboaz.ms_auth.core.domain;

/**
 * The {@code Token} class represents a token used in authentication,
 * containing the token string, creation time, and expiration time.
 * It provides a builder-like pattern for constructing instances.
 * <p>
 * This class is designed to handle JWT tokens, where the {@code createAt} and {@code expiryAt}
 * parameters are set at the moment of token creation.
 * </p>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * Token token = Token.builder()
 *     .token("abc123")
 *     .createAt("2024-09-23T10:00:00Z")
 *     .expiryAt("2024-09-24T10:00:00Z")
 *     .build();
 *
 * System.out.println("Token: " + token.getToken());
 * System.out.println("Created At: " + token.getCreateAt());
 * System.out.println("Expires At: " + token.getExpiryAt());
 * }</pre>
 *
 * <p>
 * The builder pattern allows for a more readable and maintainable way to construct
 * {@code Token} instances, especially when dealing with multiple parameters.
 * </p>
 *
 * @author GustavoBoaz
 * @since 1.0
 */
public class Token {

    private String token;
    private String createAt;
    private String expiryAt;

    /**
     * Default constructor for the {@code Token} class.
     * Initializes an empty {@code Token} object.
     */
    public Token() {}

    /**
     * Returns a new instance of {@code Token} to be used with the builder pattern.
     *
     * @return a new {@code Token} instance.
     */
    public static Token builder() {
        return new Token();
    }

    public Token token(String token) { this.token = token; return this; }
    public Token createAt(String createAt) { this.createAt = createAt; return this; }
    public Token expiryAt(String expiryAt) { this.expiryAt = expiryAt; return this; }

    /**
     * Finalizes the {@code Token} construction process.
     *
     * @return the current {@code Token} instance.
     */
    public Token build() {
        return this;
    }

    // Getters
    public String getToken() { return this.token; }
    public String getCreateAt() { return this.createAt; }
    public String getExpiryAt() { return this.expiryAt; }
}
