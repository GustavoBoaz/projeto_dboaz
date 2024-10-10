package com.dboaz.ms_auth.core.utils.constants;

/**
 * The {@code Route} class defines constant values for API routes used in the authentication microservice.
 * These constants ensure consistent use of route paths across the application.
 * <p>
 * The routes defined here are used for different operations such as fetching account details, managing accounts, 
 * and obtaining microservice information. This class centralizes the route definitions to avoid hardcoding strings 
 * in multiple places and to make future maintenance easier.
 * </p>
 *
 * @author GustavoBoaz
 * @since 1.0
 */
public class Route {

    /**
     * The route for fetching the info of the authentication microservice.
     * This route points to the "/ms_auth/info" endpoint, which provides details about the microservice status and version.
     */
    public static final String GET_INFO = "/ms_auth/info";

    /**
     * The route for retrieving an account by its ID.
     * This is used in requests to fetch account details based on a unique account identifier.
     */
    public static final String GET_ACCOUNT_BY_ID = "/ms_auth/account/get/by/id";

    /**
     * The route for retrieving an account by its key.
     * This route is used when an account needs to be fetched using a specific key (e.g., API key or a custom identifier).
     */
    public static final String GET_ACCOUNT_BY_KEY = "/ms_auth/account/get/by/key";

    /**
     * The route for retrieving all accounts based on a specific role.
     * This can be used to fetch multiple accounts that share the same role (e.g., admin, user).
     */
    public static final String GET_ACCOUNT_ALL_BY_ROLE = "/ms_auth/account/get/all/by/role";

    /**
     * The route for retrieving all accounts based on their status.
     * This is useful for fetching accounts that are active, inactive, or in a specific state.
     */
    public static final String GET_ACCOUNT_ALL_BY_STATUS = "/ms_auth/account/get/all/by/status";

    /**
     * The route for creating a new account.
     * This is used for posting new account details and registering a new user in the system.
     */
    public static final String POST_ACCOUNT_NEW = "/ms_auth/account/post/new";

    /**
     * The route for fetching an account's token by login credentials.
     * This is typically used for authentication purposes, where a valid token is retrieved after providing login details.
     */
    public static final String POST_ACCOUNT_TOKEN_BY_LOGIN = "/ms_auth/account/post/token/by/login";
    
    /**
     * The route for resetting an account's password.
     * This allows the modification of a password by sending a reset request.
     */
    public static final String PUT_ACCOUNT_RESET_PASSWORD = "/ms_auth/account/put/reset/password";

    /**
     * The route for toggling an account's status (e.g., enabling or disabling an account).
     * This is typically used to change an account's activation state.
     */
    public static final String PUT_ACCOUNT_TOGGLE_STATUS = "/ms_auth/account/put/toggle/status";

    /**
     * The route for deleting an account by its ID.
     * This is used when an account needs to be permanently removed from the system.
     */
    public static final String DELETE_ACCOUNT_BY_ID = "/ms_auth/account/delete/by/id";

    /**
     * Returns the {@code GET_INFO} route.
     * 
     * @return the route for the authentication microservice info endpoint.
     */
    public String getInfo() { return GET_INFO; }
}
