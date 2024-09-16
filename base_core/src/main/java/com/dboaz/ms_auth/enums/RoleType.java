package com.dboaz.ms_auth.enums;

/**
 * Enum representing different roles in the system.
 * Each role has a rule (3-letter acronym) and a description explaining the role.
 */
public enum RoleType {

    /**
     * Owner employee, responsible for general system administration.
     * Rule: DBO_ADM_PRODUCT
     */
    DBO_ADM_OWNER("DBO_ADM_PRODUCT", "Owner employee, manages general system administration"),

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
     * Sales team employee responsible for handling application sales.
     * Rule: DBO_ADM_SALES
     */
    DBO_ADM_SALES("DBO_ADM_SALES", "Sales team, manages app sales"),

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
     * View-only user with restricted access to certain resources.
     * Rule: DBO_USER_VIEW
     */
    DBO_USER_VIEW("DBO_USER_VIEW", "View-only user, limited access");

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

