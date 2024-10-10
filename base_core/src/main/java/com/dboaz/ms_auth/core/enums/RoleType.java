package com.dboaz.ms_auth.core.enums;

import com.dboaz.ms_auth.core.domain.Account;

/**
 * Enum representing different roles in the system.
 * Each role has a rule (3-letter acronym) and a description explaining the role.
 *
 * <p>Roles and rules are crucial in a system for several reasons:</p>
 * <ul>
 *   <li><b>Security:</b> Ensures that users have access only to the resources and actions they are authorized for.</li>
 *   <li><b>Organization:</b> Helps in managing and categorizing users based on their responsibilities and access levels.</li>
 *   <li><b>Accountability:</b> Tracks actions performed by different roles, aiding in auditing and monitoring.</li>
 * </ul>
 *
 * <p>Priorities and privileges in the system are defined as follows:</p>
 * <ul>
 *   <li><b>DBO_ADM_OWNER:</b> Highest priority with full administrative privileges.</li>
 *   <li><b>DBO_ADM_SALES:</b> High priority with privileges related to sales management.</li>
 *   <li><b>DBO_ADM_QA:</b> High priority with privileges related to quality assurance and testing.</li>
 *   <li><b>DBO_ADM_DEV:</b> High priority with privileges related to application development.</li>
 *   <li><b>DBO_USER_PREMIUM:</b> Medium priority with access to all user features.</li>
 *   <li><b>DBO_USER_BASIC:</b> Low priority with access to limited user features.</li>
 *   <li><b>DBO_USER_VIEW:</b> Lowest priority with view-only access to certain resources.</li>
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
 *     .status(StatusType.ACTIVE)
 *     .roles(Set.of(RoleType.DBO_USER_BASIC, RoleType.DBO_USER_VIEW))
 *     .keys()
 *     .createdAt()
 *     .updatedAt()
 *     .build();
 * }
 * </pre>
 *
 * @author GustavoBoaz
 * @since 1.0
 */
public enum RoleType {

    /**
     * Owner employee, responsible for general system administration.
     * Rule: DBO_ADM_PRODUCT
     */
    DBO_ADM_OWNER("DBO_ADM_PRODUCT", "Owner employee, manages general system administration"),

    /**
     * Sales team employee responsible for handling application sales.
     * Rule: DBO_ADM_SALES
     */
    DBO_ADM_SALES("DBO_ADM_SALES", "Sales team, manages app sales"),

    /**
     * QA employee, responsible for testing the application.
     * Rule: DBO_ADM_QA
     */
    DBO_ADM_QA("DBO_ADM_QA", "QA employee, tests the app"),

    /**
     * Developer employee, responsible for developing the application.
     * Rule: DBO_ADM_DEV
     */
    DBO_ADM_DEV("DBO_ADM_DEV", "DEV employee, develops the app"),

    /**
     * Basic user with limited features on the platform.
     * Rule: DBO_USER_BASIC
     */
    DBO_USER_BASIC("DBO_USER_BASIC", "Basic user, limited features"),

    /**
     * Premium user with full features on the platform.
     * Rule: DBO_USER_PREMIUM
     */
    DBO_USER_PREMIUM("DBO_USER_PREMIUM", "Premium user, full features"),

    /**
     * View-only user or system with restricted access to certain resources.
     * Rule: DBO_USER_VIEW
     */
    DBO_USER_VIEW("DBO_USER_VIEW", "View-only user or system, limited access");

    private final String rule;
    private final String description;

    /**
     * Constructor to set the rule and description for each role type.
     *
     * @param rule        the 3-character rule representing the role type.
     * @param description a brief description of the role type's responsibilities.
     */
    RoleType(String rule, String description) {
        this.rule = rule;
        this.description = description;
    }

    /**
     * Returns the rule of the role type.
     *
     * @return the 3-character rule of the role type.
     */
    public String getRule() {
        return rule;
    }

    /**
     * Returns the description of the role type.
     *
     * @return the description of the role type's responsibilities.
     */
    public String getDescription() {
        return description;
    }
}
