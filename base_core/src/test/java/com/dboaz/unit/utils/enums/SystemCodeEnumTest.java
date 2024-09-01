package com.dboaz.unit.utils.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dboaz.utils.enums.SystemCodeEnum;

class SystemCodeEnumTest {

    @Test
    void testC0001DBEnumValues() {
        SystemCodeEnum code = SystemCodeEnum.C0001DB;
        assertEquals("Internal server error", code.getProblem());
        assertEquals("Try a connection at another time", code.getAction());
    }

    @Test
    void testC0002DBEnumValues() {
        SystemCodeEnum code = SystemCodeEnum.C0002DB;
        assertEquals("Resource not found", code.getProblem());
        assertEquals("Certify your request", code.getAction());
    }
}