package com.dboaz.ms_auth.core.utils.constants;

/**
 * The {@code Claim} class defines constant values representing the keys used in JWT claims.
 * These claims are used to store and retrieve important information in the token payload,
 * ensuring consistency in how the data is structured across the authentication system.
 */
public class Claim {

    /**
     * The claim key representing the authoritiess granted to the token bearer.
     * Typically used to define the access level or actions allowed for the token.
     */
    public static final String AUTHORITIES = "authorities";
    
    /**
     * The claim key representing the scope or permissions granted to the token bearer.
     * Typically used to define the access level or actions allowed for the token.
     */
    public static final String SCOPE = "scope";

    /**
     * The claim key representing the unique identifier of the user.
     * This claim stores the user's ID within the token.
     */
    public static final String ID = "id";

    /**
     * The claim key representing the login or username of the user.
     * This is typically the login credential of the user.
     */
    public static final String LOGIN = "login";
    
    /**
     * The claim status representing the status of the user.
     * This is status acces user in this system.
     */
    public static final String STATUS = "status";

    /**
     * The claim key representing the roles assigned to the user.
     * This claim stores the user's roles, often used to define user privileges.
     */
    public static final String ROLES = "roles";
}

