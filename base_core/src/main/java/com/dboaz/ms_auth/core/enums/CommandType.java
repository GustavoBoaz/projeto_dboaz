package com.dboaz.ms_auth.core.enums;

import java.util.EnumSet;
import java.util.Set;

/**
 * Enum representing the types of command operations that can be executed in the system.
 * Each command can modify the state of the database.
 *
 * <p>The {@code Account} class represents an account in the system. It includes fields such as:</p>
 * <pre>
 * {@code
 * {
 *   "id": "string",
 *   "login": "string",
 *   "email": "string",
 *   "password": "string",
 *   "status": "ACTIVE | INACTIVE | PENDING | SUSPENDED | DELETED",
 *   "roles": ["DBO_ADM_OWNER", "DBO_ADM_QA", "DBO_ADM_DEV", "DBO_ADM_SALES", "DBO_USER_BASIC", "DBO_USER_PREMIUM", "DBO_USER_VIEW"],
 *   "keys": ["string1", "string2", "string3"],
 *   "createdAt": "yyyy-MM-dd HH:mm:ss",
 *   "updatedAt": "yyyy-MM-dd HH:mm:ss"
 * }
 * }
 * </pre>
 *
 * <p>Each command type has a set of roles that are permitted to execute the command. The roles are defined in the {@code RoleType} enum.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * CommandType command = CommandType.POST_ACCOUNT_NEW;
 * System.out.println(command.getDescription()); // Outputs: Creates a new account in the system.
 * System.out.println(command.getPermissions()); // Outputs: [DBO_ADM_OWNER, DBO_USER_VIEW]
 * }
 * </pre>
 *
 * @since 1.0
 */
public enum CommandType {

    /**
     * Creates a new account in the system.
     *
     * <p>Permitted roles: DBO_ADM_OWNER, DBO_USER_VIEW</p>
     */
    POST_ACCOUNT_NEW("Creates a new account in the system.", EnumSet.of(
            RoleType.DBO_ADM_OWNER,
            RoleType.DBO_USER_VIEW
    )),

    /**
     * Retrieves a token by account login.
     *
     * <p>Permitted roles: DBO_ADM_OWNER, DBO_USER_VIEW</p>
     */
    POST_ACCOUNT_TOKEN_BY_LOGIN("Retrieves a token by account login.", EnumSet.of(
            RoleType.DBO_ADM_OWNER,
            RoleType.DBO_USER_VIEW
    )),

    /**
     * Resets the password for an account.
     *
     * <p>Permitted roles: DBO_ADM_OWNER, DBO_USER_BASIC, DBO_USER_PREMIUM</p>
     */
    PUT_ACCOUNT_RESET_PASSWORD("Resets the password for an account.", EnumSet.of(
            RoleType.DBO_ADM_OWNER,
            RoleType.DBO_USER_PREMIUM,
            RoleType.DBO_USER_BASIC
    )),

    /**
     * Updates the email of an account.
     *
     * <p>Permitted roles: DBO_ADM_OWNER, DBO_USER_BASIC, DBO_USER_PREMIUM</p>
     */
    PUT_ACCOUNT_UPDATE_EMAIL("Updates the email of an account.", EnumSet.of(
            RoleType.DBO_ADM_OWNER,
            RoleType.DBO_USER_PREMIUM,
            RoleType.DBO_USER_BASIC
    )),

    /**
     * Toggles the status of an account.
     *
     * <p>Permitted roles: DBO_ADM_OWNER, DBO_ADM_SALES</p>
     */
    PUT_ACCOUNT_TOGGLE_STATUS("Toggles the status of an account.", EnumSet.of(
            RoleType.DBO_ADM_OWNER,
            RoleType.DBO_ADM_SALES
    )),

    /**
     * Updates the roles of an account.
     *
     * <p>Permitted roles: DBO_ADM_OWNER, DBO_ADM_SALES</p>
     */
    PUT_ACCOUNT_UPDATE_ROLES("Updates the roles of an account.", EnumSet.of(
            RoleType.DBO_ADM_OWNER,
            RoleType.DBO_ADM_SALES
    )),

    /**
     * Updates the login of an account.
     *
     * <p>Permitted roles: DBO_ADM_OWNER, DBO_ADM_SALES</p>
     */
    PUT_ACCOUNT_UPDATE_LOGIN("Updates the login of an account.", EnumSet.of(
            RoleType.DBO_ADM_OWNER,
            RoleType.DBO_ADM_SALES
    )),

    /**
     * Removes an account from the system.
     *
     * <p>Permitted roles: DBO_ADM_OWNER</p>
     */
    DELETE_ACCOUNT_BY_ID("Removes an account from the system.", EnumSet.of(
            RoleType.DBO_ADM_OWNER
    ));

    private final String description;
    private final Set<RoleType> permissions;

    /**
     * Constructs a CommandType with a description and a set of permissions.
     *
     * @param description A string describing the purpose of the command operation.
     * @param permissions A set of roles that are permitted to execute the command.
     */
    CommandType(String description, Set<RoleType> permissions) {
        this.description = description;
        this.permissions = permissions;
    }

    /**
     * Retrieves the description of the command operation.
     *
     * @return A string representing the description of the command.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the set of roles permitted to execute the command.
     *
     * @return A set of roles permitted to execute the command.
     */
    public Set<RoleType> getPermissions() {
        return permissions;
    }
}
