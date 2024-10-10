package com.dboaz.ms_auth.core.enums;

import com.dboaz.ms_auth.core.domain.Account;

/**
 * The {@code StatusType} enum represents the various statuses that an account can have
 * within the system. Each status defines the current operational state of the user's account,
 * affecting what actions the user can perform in the system.
 *
 * <p>Statuses are crucial in a system for several reasons:</p>
 * <ul>
 *   <li><b>Security:</b> Ensures that accounts with issues or pending actions are appropriately restricted.</li>
 *   <li><b>Compliance:</b> Helps in adhering to legal and policy requirements by marking accounts accordingly.</li>
 *   <li><b>Management:</b> Facilitates the administration of user accounts by categorizing them based on their current state.</li>
 * </ul>
 *
 * <p>Example of usage in the {@link Account} class:</p>
 * <pre>
 * {@code
 * Account account = Account.builder()
 *     .id()
 *     .login("user123")
 *     .email("user123@example.com")
 *     .password("password")
 *     .status(StatusType.PENDING)
 *     .roles(Set.of(RoleType.DBO_USER_BASIC))
 *     .keys()
 *     .createdAt()
 *     .updatedAt()
 *     .build();
 * }
 * </pre>
 *
 * @since 1.0
 */
public enum StatusType {

    /**
     * Represents an active account in the system.
     * Accounts with this status are fully operational and can access all features of the system.
     *
     * <p>Business Rule:</p>
     * <ul>
     *   <li>The account is validated and has no pending payments or conduct alerts.</li>
     * </ul>
     */
    ACTIVE("The account is active and can freely navigate through the system."),

    /**
     * Represents an inactive account set by the user.
     * The user can choose to deactivate their account temporarily, which will prevent
     * them from accessing the system until reactivated.
     *
     * <p>Business Rule:</p>
     * <ul>
     *   <li>The account will not be listed or accessible.</li>
     *   <li>The user must use private keys obtained during registration to reactivate the account.</li>
     * </ul>
     */
    INACTIVE("The account is inactive, and the user has chosen to temporarily deactivate their profile."),

    /**
     * Represents an account that is pending activation.
     * The account remains in this status until the user selects a basic or premium plan.
     *
     * <p>Business Rule:</p>
     * <ul>
     *   <li>Newly created accounts remain in this status until a plan is chosen.</li>
     * </ul>
     */
    PENDING("The account is pending activation and requires the user to select a plan."),

    /**
     * Represents an account that has been suspended due to issues such as non-payment or policy violations.
     * Accounts with this status are restricted from using the system until the issues are resolved.
     *
     * <p>Business Rule:</p>
     * <ul>
     *   <li>The account is suspended until the user resolves payment issues or policy violations.</li>
     *   <li>The account can be reactivated by the administration team once the issues are resolved.</li>
     * </ul>
     */
    SUSPENDED("The account is suspended due to non-payment or policy violations."),

    /**
     * Represents a deleted account awaiting full removal.
     * The account has been marked for deletion, but the system administration is still in the process of
     * permanently removing all associated data.
     *
     * <p>Business Rule:</p>
     * <ul>
     *   <li>The account and all its data are marked for permanent removal.</li>
     *   <li>Deletion is in accordance with company policies and legal requirements.</li>
     * </ul>
     */
    DELETED("The account has been deleted and is awaiting permanent removal of all related data.");

    private final String description;

    /**
     * Constructor to set the description of each status.
     *
     * @param description A brief explanation of the status.
     */
    StatusType(String description) {
        this.description = description;
    }

    /**
     * Gets the description of the status.
     *
     * @return the description of the status.
     */
    public String getDescription() {
        return description;
    }
}
