package com.dboaz.steps.global_ms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dboaz.SpringAcceptanceTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GlobalErrorNotFoundStep extends SpringAcceptanceTest {

    @Autowired ApplicationContext context;
    @Autowired TestRestTemplate rest;

    ResponseEntity<Object> response;

    @Given("`F4#` - the {string} microservice is running")
    public void f4_the_microservice_is_running(String serviceName) {
        assertNotNull(getClassMap(serviceName), "Microservice name is not registred");
        assertTrue(context.getBeanNamesForType(getClassMap(serviceName)).length > 0, "Microservice is not enable in context");
    }

    @When("`F4#` - a request is made to an invalid or non-existent endpoint")
    public void f4_a_request_is_made_to_an_invalid_or_non_existent_endpoint() {
         response = rest.getForEntity("/fail/endpoint", Object.class);
    }

    @Then("`F4#` - the microservice should return a custom alert response")
    public void f4_the_microservice_should_return_a_custom_alert_response(DataTable dataTable) {
        assertNotNull(response, "Response is null");

        // Verificar o status da resposta
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), "Expected status 404");

        // Converter a resposta para um Map para facilitar a comparação
        @SuppressWarnings("unchecked")
        Map<String, Object> responseBody = (Map<String, Object>) response.getBody();

        // Verificar os valores esperados com os valores da resposta
        dataTable.asMaps().forEach(row -> {
            String field = row.get("Field");
            Object expectedValue = parseExpectedValue(row.get("Expected Value"));

            // Navegar até o valor esperado dentro do JSON (caso de campos aninhados como "alert.code")
            Object actualValue = getNestedValue(responseBody, field);

            // Comparar os valores
            assertEquals(expectedValue, actualValue, "Mismatch in field: " + field);
        });
    }

    // Método para pegar o valor aninhado no Map, como "alert.code"
    private Object getNestedValue(Map<String, Object> map, String field) {
        String[] parts = field.split("\\.");
        Object value = map;
        for (String part : parts) {
            if (value instanceof Map) {
                value = ((Map<?, ?>) value).get(part);
            } else {
                return null;
            }
        }
        return value;
    }

    // Método auxiliar para converter o valor esperado de String para o tipo adequado
    private Object parseExpectedValue(String value) {
        if ("404".equals(value)) {
            return 404;
        }
        return value;
    }
}
