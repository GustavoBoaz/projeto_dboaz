package com.dboaz.ms_auth.core.enums;

import java.util.EnumSet;
import java.util.Set;

/**
 * Enum representing the types of query operations that can be performed in the system.
 * Queries are operations that do not modify the state of the database.
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
 * <p>Each query type has a set of roles that are permitted to execute the query. The roles are defined in the {@code RoleType} enum.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * QueryType query = QueryType.GET_ACCOUNT_BY_ID;
 * System.out.println(query.getDescription()); // Outputs: Retrieves an account by its unique identifier.
 * System.out.println(query.getPermissions()); // Outputs: [DBO_ADM_OWNER, DBO_ADM_SALES, DBO_ADM_QA, DBO_USER_PREMIUM]
 * }
 * </pre>
 *
 * @author GustavoBoaz
 * @since 1.0
 */
public enum QueryType {

    /**
     * Retrieves an account by its unique identifier.
     *
     * <p>Permitted roles: DBO_ADM_OWNER, DBO_ADM_SALES, DBO_ADM_QA, DBO_USER_PREMIUM, DBO_USER_BASIC</p>
     */
    GET_ACCOUNT_BY_ID("Retrieves an account by its unique identifier.", EnumSet.of(
            RoleType.DBO_ADM_OWNER,
            RoleType.DBO_ADM_SALES,
            RoleType.DBO_ADM_QA,
            RoleType.DBO_USER_PREMIUM,
            RoleType.DBO_USER_BASIC
    )),

    /**
     * Retrieves accounts based on a specific role.
     *
     * <p>Permitted roles: DBO_ADM_OWNER, DBO_ADM_SALES, DBO_ADM_QA</p>
     */
    GET_ACCOUNT_ALL_BY_ROLE("Retrieves accounts based on a specific role.", EnumSet.of(
            RoleType.DBO_ADM_OWNER,
            RoleType.DBO_ADM_SALES,
            RoleType.DBO_ADM_QA
    )),

    /**
     * Retrieves accounts based on a specific status.
     *
     * <p>Permitted roles: DBO_ADM_OWNER, DBO_ADM_SALES, DBO_ADM_QA</p>
     */
    GET_ACCOUNT_ALL_BY_STATUS("Retrieves accounts based on a specific status.", EnumSet.of(
            RoleType.DBO_ADM_OWNER,
            RoleType.DBO_ADM_SALES,
            RoleType.DBO_ADM_QA
    )),

    /**
     * Retrieves an account by its unique key, unique login and unique email. Use for recovery account.
     *
     * <p>Permitted roles: DBO_ADM_OWNER, DBO_USER_VIEW</p>
     */
    GET_ACCOUNT_BY_KEYS_LOGIN_EMAIL("Retrieves an account by its unique key, login, and email.", EnumSet.of(
            RoleType.DBO_ADM_OWNER,
            RoleType.DBO_USER_VIEW
    )),

    /**
     * Retrieves an account by its login.
     *
     * <p>Permitted roles: DBO_ADM_OWNER, DBO_ADM_SALES, DBO_ADM_QA</p>
     */
    GET_ACCOUNT_BY_LOGIN("Retrieves an account by its login.", EnumSet.of(
            RoleType.DBO_ADM_OWNER,
            RoleType.DBO_ADM_SALES,
            RoleType.DBO_ADM_QA
    )),

    /**
     * Retrieves the count of accounts by role.
     *
     * <p>Permitted roles: DBO_ADM_OWNER, DBO_ADM_SALES, DBO_ADM_QA</p>
     */
    GET_ACCOUNT_COUNT_BY_ROLE("Retrieves the count of accounts by role.", EnumSet.of(
            RoleType.DBO_ADM_OWNER,
            RoleType.DBO_ADM_SALES,
            RoleType.DBO_ADM_QA
    )),

    /**
     * Retrieves the count of accounts by status.
     *
     * <p>Permitted roles: DBO_ADM_OWNER, DBO_ADM_SALES, DBO_ADM_QA</p>
     */
    GET_ACCOUNT_COUNT_BY_STATUS("Retrieves the count of accounts by status.", EnumSet.of(
            RoleType.DBO_ADM_OWNER,
            RoleType.DBO_ADM_SALES,
            RoleType.DBO_ADM_QA
    ));

    private final String description;
    private final Set<RoleType> permissions;

    /**
     * Constructs a QueryType with a description and a set of permissions.
     *
     * @param description A string describing the purpose of the query operation.
     * @param permissions A set of roles that are permitted to execute the query.
     */
    QueryType(String description, Set<RoleType> permissions) {
        this.description = description;
        this.permissions = permissions;
    }

    /**
     * Retrieves the description of the query operation.
     *
     * @return A string representing the description of the query.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the set of roles permitted to execute the query.
     *
     * @return A set of roles permitted to execute the query.
     */
    public Set<RoleType> getPermissions() {
        return permissions;
    }
}
