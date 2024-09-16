
package com.dboaz.unit.ms_auth.enums;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.dboaz.ms_auth.enums.RoleType;

public class RoleTypeTest {

    @Test
    public void testDBO_ADM_OWNER() {
        RoleType role = RoleType.DBO_ADM_OWNER;
        assertEquals("DBO_ADM_PRODUCT", role.getRule());
        assertEquals("Owner employee, manages general system administration", role.getDescription());
    }

    @Test
    public void testDBO_ADM_QA() {
        RoleType role = RoleType.DBO_ADM_QA;
        assertEquals("DBO_ADM_QA", role.getRule());
        assertEquals("QA employee, tests the app", role.getDescription());
    }

    @Test
    public void testDBO_ADM_DEV() {
        RoleType role = RoleType.DBO_ADM_DEV;
        assertEquals("DBO_ADM_DEV", role.getRule());
        assertEquals("DEV employee, develops the app", role.getDescription());
    }

    @Test
    public void testDBO_ADM_SALES() {
        RoleType role = RoleType.DBO_ADM_SALES;
        assertEquals("DBO_ADM_SALES", role.getRule());
        assertEquals("Sales team, manages app sales", role.getDescription());
    }

    @Test
    public void testDBO_USER_BASIC() {
        RoleType role = RoleType.DBO_USER_BASIC;
        assertEquals("DBO_USER_BASIC", role.getRule());
        assertEquals("Basic user, limited features", role.getDescription());
    }

    @Test
    public void testDBO_USER_PREMIUM() {
        RoleType role = RoleType.DBO_USER_PREMIUM;
        assertEquals("DBO_USER_PREMIUM", role.getRule());
        assertEquals("Premium user, full features", role.getDescription());
    }

    @Test
    public void testDBO_USER_VIEW() {
        RoleType role = RoleType.DBO_USER_VIEW;
        assertEquals("DBO_USER_VIEW", role.getRule());
        assertEquals("View-only user, limited access", role.getDescription());
    }
}
