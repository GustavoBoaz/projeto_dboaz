package com.dboaz.ms_auth.core.dtos;

import java.util.Set;

import com.dboaz.ms_auth.core.enums.CommandType;
import com.dboaz.ms_auth.core.enums.RoleType;
import com.dboaz.ms_auth.core.enums.StatusType;
import com.dboaz.ms_auth.core.interfaces.ValidationDto;
import com.dboaz.ms_auth.core.domain.Account;
import com.dboaz.ms_auth.core.utils.validations.Validate;
import com.dboaz.utils.enums.SystemCodeEnum;
import com.dboaz.utils.exceptions.GlobalException;
import com.dboaz.utils.models.CustomAlert;

/**
 * Data Transfer Object (DTO) for commands. This DTO is used to transfer data
 * between different layers of the application, specifically for executing commands
 * related to account management.
 * It contains validation methods to check the integrity of the provided id, login, email,
 * password, status, and roles.
 *
 * <p>DTOs are simple objects that should not contain any business logic. They are used to
 * encapsulate data and transfer it from one layer of the application to another.</p>
 *
 * <p>The {@code CommandDto} is designed to handle different types of commands, as specified
 * by the {@code CommandType} enum. Each command type has its own set of required fields that
 * must be validated before the command can be executed.</p>
 *
 * @param command  The type of command to be executed. This is an enum of type {@code CommandType}.
 * @param id       The unique identifier of the account, which must be a valid UUID.
 * @param login    The login name, which must match a specific email format.
 * @param email    The contact email, which must match a specific email format.
 * @param password The password, which must follow certain security requirements.
 * @param status   The status of the account at the moment.
 * @param roles    The roles associated with the account, represented as a set of {@code RoleType}.
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * CommandDto commandDto = new CommandDto(CommandType.POST_ACCOUNT_NEW, null, "user@example.com", "user@example.com", "password123", StatusType.ACTIVE, Set.of(RoleType.USER));
 * Account account = commandDto.validate();
 * }</pre>
 *
 * <p>In this example, a {@code CommandDto} is created to create a new account. The {@code validate}
 * method is called to ensure all fields are valid and to build the corresponding {@code Account} object.</p>
 *
 * <p>Concept of Command:</p>
 * <p>A command in this context refers to an action or operation that modifies the state of the system.
 * The type of command determines what kind of operation is being performed and what parameters are
 * required to execute the operation.</p>
 *
 * <p>Supported Command Types:</p>
 * <ul>
 *   <li>{@code POST_ACCOUNT_NEW}: Create a new account.</li>
 *   <li>{@code POST_ACCOUNT_TOKEN_BY_LOGIN}: Generate a token for an account based on login credentials.</li>
 *   <li>{@code PUT_ACCOUNT_RESET_PASSWORD}: Reset the password for an account.</li>
 *   <li>{@code PUT_ACCOUNT_UPDATE_EMAIL}: Update the email for an account.</li>
 *   <li>{@code PUT_ACCOUNT_TOGGLE_STATUS}: Toggle the status of an account.</li>
 *   <li>{@code PUT_ACCOUNT_UPDATE_ROLES}: Update the roles for an account.</li>
 *   <li>{@code PUT_ACCOUNT_UPDATE_LOGIN}: Update the login for an account.</li>
 *   <li>{@code DELETE_ACCOUNT_BY_ID}: Delete an account by its unique ID.</li>
 * </ul>
 *
 * <p>Each command type has specific validation requirements to ensure the integrity and correctness
 * of the data being processed.</p>
 *
 * @author GustavoBoaz
 * @since 1.0
 */
public record CommandDto(
        CommandType command,
        String id,
        String login,
        String email,
        String password,
        StatusType status,
        Set<RoleType> roles
) implements ValidationDto {

    private static final Integer LIMIT = 5;

    @Override
    public Account validate() throws GlobalException {
        Validate.command(command.toString());
        return switch (command) {
            case POST_ACCOUNT_NEW -> {
                Validate.login(login);
                Validate.email(email);
                Validate.password(password);
                Validate.status(status);
                Validate.roles(roles);
                yield Account.builder()
                    .id()
                    .login(login)
                    .email(email)
                    .password(password)
                    .status(status)
                    .roles(roles)
                    .keys(LIMIT)
                    .createdAt()
                    .updatedAt()
                    .build();
            }
            case POST_ACCOUNT_TOKEN_BY_LOGIN -> {
                Validate.login(login);
                Validate.password(password);
                yield Account.builder().login(login).password(password).build();
            }
            case PUT_ACCOUNT_UPDATE_LOGIN -> {
                Validate.uuid(id);
                Validate.login(login);
                Validate.password(password);
                yield Account.builder().id(id).login(login).password(password).updatedAt().build();
            }
            case PUT_ACCOUNT_UPDATE_EMAIL -> {
                Validate.uuid(id);
                Validate.email(email);
                Validate.password(password);
                yield Account.builder().id(id).email(email).password(password).updatedAt().build();
            }
            case PUT_ACCOUNT_RESET_PASSWORD -> {
                Validate.uuid(id);
                Validate.password(password);
                yield Account.builder().id(id).password(password).updatedAt().build();
            }
            case PUT_ACCOUNT_TOGGLE_STATUS -> {
                Validate.uuid(id);
                Validate.status(status);
                yield Account.builder().id(id).status(status).updatedAt().build();
            }
            case PUT_ACCOUNT_UPDATE_ROLES -> {
                Validate.uuid(id);
                Validate.roles(roles);
                yield Account.builder().id(id).roles(roles).updatedAt().build();
            }
            case DELETE_ACCOUNT_BY_ID -> {
                Validate.uuid(id);
                yield Account.builder().id(id).build();
            }
            default ->
                    throw GlobalException.builder().status(400).alert(new CustomAlert(SystemCodeEnum.C003DB)).build();
        };
    }
}
