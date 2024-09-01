package com.dboaz.unit.utils.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.dboaz.utils.models.GlobalInfo;

class GlobalInfoTest {

    @Test
    void testBuilder() {
        // Criando uma instância usando o padrão Builder
        GlobalInfo info = GlobalInfo.builder()
            .name("Test Name")
            .version("1.0.0")
            .description("Test Description")
            .build();

        // Validando os atributos
        assertEquals("Test Name", info.getName());
        assertEquals("1.0.0", info.getVersion());
        assertEquals("Test Description", info.getDescription());
    }

    @Test
    void testToString() {
        // Criando uma instância usando o padrão Builder
        GlobalInfo info = GlobalInfo.builder()
            .name("Test Name")
            .version("1.0.0")
            .description("Test Description")
            .build();

        // Esperado output do toString
        String expectedString = "\n\n\n GlobalInfo " +
            "\n name: Test Name" +
            "\n version: 1.0.0" +
            "\n description: Test Description" +
            "\n\n";

        // Validando o resultado do método toString
        assertEquals(expectedString, info.toString());
    }

    @Test
    void testGetters() {
        // Criando uma instância usando o padrão Builder
        GlobalInfo info = GlobalInfo.builder()
            .name("Test Name")
            .version("1.0.0")
            .description("Test Description")
            .build();

        // Validando os métodos getters
        assertEquals("Test Name", info.getName());
        assertEquals("1.0.0", info.getVersion());
        assertEquals("Test Description", info.getDescription());
    }
}
