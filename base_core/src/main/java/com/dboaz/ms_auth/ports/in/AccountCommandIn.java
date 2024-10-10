package com.dboaz.ms_auth.ports.in;

import com.dboaz.ms_auth.core.domain.Token;
import com.dboaz.ms_auth.core.dtos.CommandDto;
import com.dboaz.utils.exceptions.GlobalException;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Port for account-related command operations in a hexagonal architecture.
 * <p>
 * This interface defines the contract for executing account commands
 * within a hexagonal architecture. It serves as an entry point to interact with
 * the core business logic for creating, updating, and deleting accounts.
 * </p>
 *
 * @see com.dboaz.ms_auth.core.dtos.CommandDto
 * @see com.dboaz.utils.exceptions.GlobalException
 *
 * @since 1.0
 */
@Tag(name = "Account Commands")
public interface AccountCommandIn {

    @Operation(
            description = """
            ### Create Account
            Use this endpoint to create a new account in the system.

            **Example JSON:**
            ```json
            {
                "command": "POST_ACCOUNT_NEW",
                "login": "loginsystem@dboaz.app",
                "password": "Pass@123456",
                "email": "your_email@domain.com",
                "status": "ACTIVE",
                "roles": ["DBO_ADM_OWNER"]
            }
            ```

            For more details, contact the developer team.
            """,
            responses = {
                    @ApiResponse(responseCode = "201", description = "Account has been created"),
                    @ApiResponse(responseCode = "400 to 500", description = "Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalException.class))
                    })
            }
    )
    ResponseEntity<Void> createAccount(CommandDto commandDto) throws GlobalException;

    @Operation(
            security = @SecurityRequirement(name = "bearer-key"),
            description = """
            ### Update Account Login
            Use this endpoint to update the login of an existing account.

            **Example JSON:**
            ```json
            {
                "command": "PUT_ACCOUNT_UPDATE_LOGIN",
                "login": "newlogin@dboaz.app"
            }
            ```

            For more details, contact the developer team.
            """,
            responses = {
                    @ApiResponse(responseCode = "200", description = "Account login updated successfully"),
                    @ApiResponse(responseCode = "400 to 500", description = "Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalException.class))
                    })
            }
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_DBO_ADM_OWNER','SCOPE_DBO_ADM_SALES')")
    ResponseEntity<Void> updateAccountLogin(CommandDto commandDto) throws GlobalException;

    @Operation(
            security = @SecurityRequirement(name = "bearer-key"),
            description = """
            ### Reset Account Password
            Use this endpoint to reset the password of an existing account.

            **Example JSON:**
            ```json
            {
                "command": "PUT_ACCOUNT_RESET_PASSWORD",
                "password": "NewPass@123456"
            }
            ```

            For more details, contact the developer team.
            """,
            responses = {
                    @ApiResponse(responseCode = "200", description = "Account password reset successfully"),
                    @ApiResponse(responseCode = "400 to 500", description = "Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalException.class))
                    })
            }
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_DBO_ADM_OWNER','SCOPE_DBO_USER_PREMIUM','SCOPE_DBO_USER_BASIC')")
    ResponseEntity<Void> resetAccountPassword(CommandDto commandDto) throws GlobalException;

    @Operation(
            security = @SecurityRequirement(name = "bearer-key"),
            description = """
            ### Update Account Email
            Use this endpoint to update the email of an existing account.

            **Example JSON:**
            ```json
            {
                "command": "PUT_ACCOUNT_UPDATE_EMAIL",
                "email": "newemail@dboaz.app"
            }
            ```

            For more details, contact the developer team.
            """,
            responses = {
                    @ApiResponse(responseCode = "200", description = "Account email updated successfully"),
                    @ApiResponse(responseCode = "400 to 500", description = "Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalException.class))
                    })
            }
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_DBO_ADM_OWNER','SCOPE_DBO_USER_PREMIUM','SCOPE_DBO_USER_BASIC')")
    ResponseEntity<Void> updateAccountEmail(CommandDto commandDto) throws GlobalException;

    @Operation(
            security = @SecurityRequirement(name = "bearer-key"),
            description = """
            ### Toggle Account Status
            Use this endpoint to toggle the status of an existing account.

            **Example JSON:**
            ```json
            {
                "command": "PUT_ACCOUNT_TOGGLE_STATUS",
                "status": "INACTIVE"
            }
            ```

            For more details, contact the developer team.
            """,
            responses = {
                    @ApiResponse(responseCode = "200", description = "Account status toggled successfully"),
                    @ApiResponse(responseCode = "400 to 500", description = "Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalException.class))
                    })
            }
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_DBO_ADM_OWNER','SCOPE_DBO_ADM_SALES')")
    ResponseEntity<Void> toggleAccountStatus(CommandDto commandDto) throws GlobalException;

    @Operation(
            security = @SecurityRequirement(name = "bearer-key"),
            description = """
            ### Update Account Roles
            Use this endpoint to update the roles of an existing account.

            **Example JSON:**
            ```json
            {
                "command": "PUT_ACCOUNT_UPDATE_ROLES",
                "roles": ["DBO_ADM_DEV"]
            }
            ```

            For more details, contact the developer team.
            """,
            responses = {
                    @ApiResponse(responseCode = "200", description = "Account roles updated successfully"),
                    @ApiResponse(responseCode = "400 to 500", description = "Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalException.class))
                    })
            }
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_DBO_ADM_OWNER','SCOPE_DBO_ADM_SALES')")
    ResponseEntity<Void> updateAccountRoles(CommandDto commandDto) throws GlobalException;

    @Operation(
            security = @SecurityRequirement(name = "bearer-key"),
            description = """
            ### Delete Account by ID
            Use this endpoint to delete an account by its unique ID.

            **Example JSON:**
            ```json
            {
                "command": "DELETE_ACCOUNT_BY_ID",
                "id": "account-id"
            }
            ```

            For more details, contact the developer team.
            """,
            responses = {
                    @ApiResponse(responseCode = "200", description = "Account deleted successfully"),
                    @ApiResponse(responseCode = "400 to 500", description = "Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalException.class))
                    })
            }
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_DBO_ADM_OWNER')")
    ResponseEntity<Void> deleteAccountById(CommandDto commandDto) throws GlobalException;

    @Operation(
            description = """
            ### Generate Token by Login
            Use this endpoint to generate a token for an account based on login credentials.

            **Example JSON:**
            ```json
            {
                "command": "POST_ACCOUNT_TOKEN_BY_LOGIN",
                "login": "loginsystem@dboaz.app",
                "password": "Pass@123456"
            }
            ```

            For more details, contact the developer team.
            """,
            responses = {
                    @ApiResponse(responseCode = "200", description = "Token generated successfully"),
                    @ApiResponse(responseCode = "400 to 500", description = "Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalException.class))
                    })
            }
    )
    ResponseEntity<Token> generateTokenByLogin(CommandDto commandDto) throws GlobalException;
}
