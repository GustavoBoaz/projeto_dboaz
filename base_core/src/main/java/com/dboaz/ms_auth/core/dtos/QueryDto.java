package com.dboaz.ms_auth.core.dtos;

import java.util.Set;

import com.dboaz.ms_auth.core.enums.QueryType;
import com.dboaz.ms_auth.core.enums.RoleType;
import com.dboaz.ms_auth.core.enums.StatusType;
import com.dboaz.ms_auth.core.interfaces.ValidationDto;
import com.dboaz.ms_auth.core.domain.Account;
import com.dboaz.ms_auth.core.utils.validations.Validate;
import com.dboaz.utils.enums.SystemCodeEnum;
import com.dboaz.utils.exceptions.GlobalException;
import com.dboaz.utils.models.CustomAlert;

/**
 * Data Transfer Object (DTO) for queries. This DTO is used to transfer data
 * between different layers of the application, specifically for querying account information.
 * It contains validation methods to ensure the integrity of the provided id, login, email, status, roles, and keys.
 *
 * <p>DTOs are simple objects that should not contain any business logic. They are used to
 * encapsulate data and transfer it from one layer of the application to another.</p>
 *
 * <p>The {@code QueryDto} is designed to handle different types of queries, as specified
 * by the {@code QueryType} enum. Each query type has its own set of required fields that
 * must be validated before the query can be executed.</p>
 *
 * @param query  The type of query to be executed. This is an enum of type {@code QueryType}.
 * @param id     The unique identifier of the account, which must be a valid UUID.
 * @param login  The unique identifier of the account, which must be a valid email.
 * @param email  The email associated with the account, which must be a valid email.
 * @param status The status of the account, represented as an enum of type {@code StatusType}.
 * @param roles  The roles associated with the account, represented as a set of {@code RoleType}.
 * @param keys   A set of keys used to retrieve accounts, each must be a valid UUID.
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * QueryDto queryDto = new QueryDto(QueryType.GET_ACCOUNT_BY_ID, "123e4567-e89b-12d3-a456-426614174000", null, null, null, null, null);
 * Account account = queryDto.validate();
 * }</pre>
 *
 * <p>In this example, a {@code QueryDto} is created to get an account by its ID. The {@code validate}
 * method is called to ensure the ID is valid and to build the corresponding {@code Account} object.</p>
 *
 * <p>Concept of Query:</p>
 * <p>A query in this context refers to a request to retrieve specific information from the database.
 * The type of query determines what kind of information is being requested and what parameters are
 * required to fulfill the request.</p>
 *
 * <p>Supported Query Types:</p>
 * <ul>
 *   <li>{@code GET_ACCOUNT_BY_ID}: Retrieve an account by its unique ID.</li>
 *   <li>{@code GET_ACCOUNT_BY_LOGIN}: Retrieve an account by its login (email).</li>
 *   <li>{@code GET_ACCOUNT_BY_KEY}: Retrieve accounts by a set of keys.</li>
 *   <li>{@code GET_ACCOUNT_ALL_BY_ROLE}: Retrieve all accounts associated with specific roles.</li>
 *   <li>{@code GET_ACCOUNT_ALL_BY_STATUS}: Retrieve all accounts associated with a specific status.</li>
 *   <li>{@code GET_ACCOUNT_COUNT_BY_ROLE}: Retrieve the count of accounts associated with specific roles.</li>
 *   <li>{@code GET_ACCOUNT_COUNT_BY_STATUS}: Retrieve the count of accounts associated with a specific status.</li>
 *   <li>{@code GET_ACCOUNT_BY_KEYS_LOGIN_EMAIL}: Retrieve accounts by a combination of keys, login, and email.</li>
 * </ul>
 *
 * <p>Each query type has specific validation requirements to ensure the integrity and correctness
 * of the data being queried.</p>
 *
 * @author GustavoBoaz
 * @since 1.0
 */
public record QueryDto(
        QueryType query,
        String id,
        String login,
        String email,
        StatusType status,
        Set<RoleType> roles,
        Set<String> keys
) implements ValidationDto {

    @Override
    public Account validate() throws GlobalException {
        Validate.query(query.toString());
        return switch (query) {
            case GET_ACCOUNT_BY_ID -> {
                Validate.uuid(id);
                yield Account.builder().id(id).build();
            }
            case GET_ACCOUNT_ALL_BY_ROLE, GET_ACCOUNT_COUNT_BY_ROLE -> {
                Validate.roles(roles);
                yield Account.builder().roles(roles).build();
            }
            case GET_ACCOUNT_ALL_BY_STATUS, GET_ACCOUNT_COUNT_BY_STATUS -> {
                Validate.status(status);
                yield Account.builder().status(status).build();
            }
            case GET_ACCOUNT_BY_KEYS_LOGIN_EMAIL -> {
                Validate.login(login);
                Validate.email(email);
                Validate.keys(keys);
                yield Account.builder().login(login).email(email).keys(keys).build();
            }
            case GET_ACCOUNT_BY_LOGIN -> {
                Validate.login(login);
                yield Account.builder().login(login).build();
            }
            default ->
                    throw GlobalException.builder().status(400).alert(new CustomAlert(SystemCodeEnum.C004DB)).build();
        };
    }
}
