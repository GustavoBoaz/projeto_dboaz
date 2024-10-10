package com.dboaz.ms_auth.ports.in;

import com.dboaz.ms_auth.core.dtos.QueryDto;
import com.dboaz.ms_auth.core.domain.Account;
import com.dboaz.ms_auth.core.mappers.AccountMapper;
import com.dboaz.utils.exceptions.GlobalException;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Set;

/**
 * Port for account-related query operations in a hexagonal architecture.
 * <p>
 * This interface defines the contract for executing account queries
 * within a hexagonal architecture. It serves as an entry point to interact with
 * the core business logic for retrieving account data.
 * </p>
 *
 * @see com.dboaz.ms_auth.core.dtos.QueryDto
 * @see com.dboaz.utils.exceptions.GlobalException
 *
 * @since 1.0
 */
@Tag(name = "Account Queries")
public interface AccountQueryIn {

    @Operation(
            security = @SecurityRequirement(name = "bearer-key"),
            description = """
            ### Get Account by ID
            Use this endpoint to retrieve an account by its unique ID.

            **Example JSON:**
            ```json
            {
                "query": "GET_ACCOUNT_BY_ID",
                "id": "account-id"
            }
            ```

            For more details, contact the developer team.
            """,
            responses = {
                    @ApiResponse(responseCode = "200", description = "Account retrieved successfully"),
                    @ApiResponse(responseCode = "400 to 500", description = "Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalException.class))
                    })
            }
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_DBO_ADM_OWNER','SCOPE_DBO_ADM_SALES','SCOPE_DBO_ADM_QA','SCOPE_DBO_USER_PREMIUM','SCOPE_DBO_USER_BASIC')")
    ResponseEntity<AccountMapper> getAccountById(QueryDto queryDto) throws GlobalException;

    @Operation(
            security = @SecurityRequirement(name = "bearer-key"),
            description = """
            ### Get Accounts by Role
            Use this endpoint to retrieve accounts based on a specific role.

            **Example JSON:**
            ```json
            {
                "query": "GET_ACCOUNT_ALL_BY_ROLE",
                "role": "DBO_ADM_OWNER"
            }
            ```

            For more details, contact the developer team.
            """,
            responses = {
                    @ApiResponse(responseCode = "200", description = "Accounts retrieved successfully"),
                    @ApiResponse(responseCode = "400 to 500", description = "Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalException.class))
                    })
            }
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_DBO_ADM_OWNER','SCOPE_DBO_ADM_SALES','SCOPE_DBO_ADM_QA')")
    ResponseEntity<Set<AccountMapper>> getAccountsByRole(QueryDto queryDto) throws GlobalException;

    @Operation(
            security = @SecurityRequirement(name = "bearer-key"),
            description = """
            ### Get Account Count by Role
            Use this endpoint to retrieve the count of accounts by their roles.

            **Example JSON:**
            ```json
            {
                "query": "GET_ACCOUNT_COUNT_BY_ROLE",
                "role": "DBO_ADM_OWNER"
            }
            ```

            For more details, contact the developer team.
            """,
            responses = {
                    @ApiResponse(responseCode = "200", description = "Account count retrieved successfully"),
                    @ApiResponse(responseCode = "400 to 500", description = "Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalException.class))
                    })
            }
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_DBO_ADM_OWNER','SCOPE_DBO_ADM_SALES','SCOPE_DBO_ADM_QA')")
    ResponseEntity<Long> getAccountCountByRole(QueryDto queryDto) throws GlobalException;

    @Operation(
            security = @SecurityRequirement(name = "bearer-key"),
            description = """
            ### Get Accounts by Status
            Use this endpoint to retrieve accounts based on a specific status.

            **Example JSON:**
            ```json
            {
                "query": "GET_ACCOUNT_ALL_BY_STATUS",
                "status": "ACTIVE"
            }
            ```

            For more details, contact the developer team.
            """,
            responses = {
                    @ApiResponse(responseCode = "200", description = "Accounts retrieved successfully"),
                    @ApiResponse(responseCode = "400 to 500", description = "Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalException.class))
                    })
            }
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_DBO_ADM_OWNER','SCOPE_DBO_ADM_SALES','SCOPE_DBO_ADM_QA')")
    ResponseEntity<Set<AccountMapper>> getAccountsByStatus(QueryDto queryDto) throws GlobalException;

    @Operation(
            security = @SecurityRequirement(name = "bearer-key"),
            description = """
            ### Get Account Count by Status
            Use this endpoint to retrieve the count of accounts by their status.

            **Example JSON:**
            ```json
            {
                "query": "GET_ACCOUNT_COUNT_BY_STATUS",
                "status": "ACTIVE"
            }
            ```

            For more details, contact the developer team.
            """,
            responses = {
                    @ApiResponse(responseCode = "200", description = "Account count retrieved successfully"),
                    @ApiResponse(responseCode = "400 to 500", description = "Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalException.class))
                    })
            }
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_DBO_ADM_OWNER','SCOPE_DBO_ADM_SALES','SCOPE_DBO_ADM_QA')")
    ResponseEntity<Long> getAccountCountByStatus(QueryDto queryDto) throws GlobalException;

    @Operation(
            security = @SecurityRequirement(name = "bearer-key"),
            description = """
            ### Get Account by Keys (Login/Email)
            Use this endpoint to retrieve an account by a specific key (login/email).

            **Example JSON:**
            ```json
            {
                "query": "GET_ACCOUNT_BY_KEYS_LOGIN_EMAIL",
                "login": "loginsystem@dboaz.app",
                "email": "your_email@domain.com"
            }
            ```

            For more details, contact the developer team.
            """,
            responses = {
                    @ApiResponse(responseCode = "200", description = "Account retrieved successfully"),
                    @ApiResponse(responseCode = "400 to 500", description = "Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalException.class))
                    })
            }
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_DBO_ADM_OWNER','SCOPE_DBO_USER_VIEW')")
    ResponseEntity<AccountMapper> getAccountByKeysLoginEmail(QueryDto queryDto) throws GlobalException;

    @Operation(
            security = @SecurityRequirement(name = "bearer-key"),
            description = """
            ### Get Account by Login
            Use this endpoint to retrieve an account by its login credentials.

            **Example JSON:**
            ```json
            {
                "query": "GET_ACCOUNT_BY_LOGIN",
                "login": "loginsystem@dboaz.app"
            }
            ```

            For more details, contact the developer team.
            """,
            responses = {
                    @ApiResponse(responseCode = "200", description = "Account retrieved successfully"),
                    @ApiResponse(responseCode = "400 to 500", description = "Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GlobalException.class))
                    })
            }
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_DBO_ADM_OWNER','SCOPE_DBO_ADM_SALES','SCOPE_DBO_ADM_QA')")
    ResponseEntity<AccountMapper> getAccountByLogin(QueryDto queryDto) throws GlobalException;
}
