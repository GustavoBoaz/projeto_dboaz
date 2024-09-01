package com.dboaz.unit.utils.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dboaz.utils.enums.SystemCodeEnum;

class SystemCodeEnumTest {

    @Test
    void testC0001DBEnumValues() {
        SystemCodeEnum code = SystemCodeEnum.C001DB;
        assertEquals("Internal server error", code.getProblem());
        assertEquals("Try a connection at another time", code.getAction());
    }

    @Test
    void testC0002DBEnumValues() {
        SystemCodeEnum code = SystemCodeEnum.C002DB;
        assertEquals("Not found", code.getProblem());
        assertEquals("The resource is not available", code.getAction());
    }
}
