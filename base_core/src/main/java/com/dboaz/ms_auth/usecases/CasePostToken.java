package com.dboaz.ms_auth.usecases;

import java.time.Instant;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

import com.dboaz.ms_auth.core.dtos.CommandDto;
import com.dboaz.ms_auth.core.dtos.QueryDto;
import com.dboaz.ms_auth.core.enums.QueryType;
import com.dboaz.ms_auth.core.mappers.AccountMapper;
import com.dboaz.ms_auth.core.domain.Token;
import com.dboaz.ms_auth.ports.out.AccountCommandOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.dboaz.ms_auth.core.utils.constants.Claim;
import com.dboaz.ms_auth.core.utils.validations.Validate;
import com.dboaz.utils.enums.SystemCodeEnum;
import com.dboaz.utils.exceptions.GlobalException;
import com.dboaz.utils.models.CustomAlert;

/**
 * The {@code CasePostToken} class is responsible for generating a JWT token for an authenticated user.
 * It implements {@link Callable} to handle asynchronous processing of token creation.
 * <p>
 * The class validates user credentials, builds JWT claims, and encodes the token.
 * It utilizes {@link JwtEncoder} for the encoding process and relies on predefined constants for JWT claims.
 * </p>
 *
 * <h2>Usage Example with {@link ExecutorService}:</h2>
 * <pre>{@code
 * // Create an instance of JwtEncoder (injected by Spring)
 * JwtEncoder jwtEncoder = ...; // Assume this is injected
 *
 * // Create an instance of CasePostToken and set the parameters
 * CasePostToken casePostToken = new CasePostToken(jwtEncoder)
 *     .setParams(accountService, queryDto);
 *
 * // Create an ExecutorService to execute the Callable task asynchronously
 * ExecutorService executorService = Executors.newSingleThreadExecutor();
 *
 * // Submit the task for execution and obtain a Future object
 * Future<Token> futureToken = executorService.submit(casePostToken);
 *
 * // Retrieve the Token object from the Future (this will block until the task completes)
 * Token token = futureToken.get(); // Handle exceptions appropriately
 *
 * // Print or use the token
 * System.out.println("Generated Token: " + token.getToken());
 *
 * // Shutdown the executor service after usage
 * executorService.shutdown();
 * }</pre>
 *
 * @author GustavoBoaz
 * @since 1.0
 */
@Service
public class CasePostToken implements Callable<Token> {
    
    // Constants for token expiry time and the issuer's name
    private static final Long EXPIRY_SECONDS = 2629344L; // Expiry time in seconds (approx. 1 month)
    private static final String MS_AUTH = "ms_auth"; // JWT issuer identifier

    private final JwtEncoder encoder;
    private AccountCommandOut service;
    private CommandDto dto;

    /**
     * Constructs a {@code CasePostToken} instance with a provided {@link JwtEncoder}.
     *
     * @param encoder   the {@link JwtEncoder} used to encode JWT tokens.
     */
    @Autowired
    public CasePostToken(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    /**
     * Sets the parameters required for token generation.
     *
     * @param service   the account service used to fetch account information.
     * @param dto       the input data required to process the request.
     * @return the current instance of {@code CasePostToken} with the parameters set.
     */
    public CasePostToken setParams(AccountCommandOut service, CommandDto dto) {
        this.service = service;
        this.dto = dto;
        return this;
    }

    /**
     * Generates a JWT token after validating the user's credentials.
     * <p>
     * This method is invoked when the callable task is executed. It performs user credential validation, 
     * creates the necessary JWT claims, and returns the generated token along with creation and expiry times.
     * </p>
     *
     * @return a {@link Token} object containing the generated JWT token and related metadata.
     * @throws GlobalException if authentication fails due to invalid credentials.
     */
    @Override
    public Token call() throws GlobalException {
        dto.validate();
        
        //var entity = service.getAccountByLogin(new QueryDto(QueryType.GET_ACCOUNT_BY_LOGIN, null, dto.login(), null, null, null, null));
        var now = Instant.now();

        //Validate.credentials(entity, dto.password());
        
        ///JwtClaimsSet claims = createJwtClaims(entity, now);

        return null; ///generateToken(claims, now);
    }

    /**
     * Creates the set of JWT claims based on the user's account information.
     *
     * @param entity    the user's account details.
     * @param now       the current timestamp used for token issuance.
     * @return a {@link JwtClaimsSet} object containing the claims for the JWT.
     */
    private JwtClaimsSet createJwtClaims(AccountMapper entity, Instant now) {
        Set<GrantedAuthority> authorities = entity.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role.toString()))
            .collect(Collectors.toSet());

        return JwtClaimsSet.builder()
            .issuer(MS_AUTH)
            .issuedAt(now)
            .expiresAt(now.plusSeconds(EXPIRY_SECONDS))
            .subject(entity.getLogin())
            .claim(Claim.SCOPE, authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(" ")))
            .claim(Claim.ID, entity.getId())
            .claim(Claim.LOGIN, entity.getLogin())
            .claim(Claim.STATUS, entity.getStatus())
            .build();
    }

    /**
     * Encodes the JWT claims into a token and returns the generated {@link Token} object.
     *
     * @param claims    the JWT claims to be encoded.
     * @param now       the current timestamp used for defining creation and expiry times.
     * @return a {@link Token} object containing the generated JWT token and metadata.
     */
    private Token generateToken(JwtClaimsSet claims, Instant now) {
        try {
            String jwtToken = encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
            return Token.builder()
                .token(jwtToken)
                .createAt(now.toString())
                .expiryAt(now.plusSeconds(EXPIRY_SECONDS).toString())
                .build();
        } catch(Exception e) {
            throw GlobalException.builder()
                .status(401)
                .alert(new CustomAlert(SystemCodeEnum.C041DB))
                .build();
        }
    }
}

