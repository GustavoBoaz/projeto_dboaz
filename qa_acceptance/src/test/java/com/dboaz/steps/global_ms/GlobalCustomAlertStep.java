package com.dboaz.steps.global_ms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;

import com.dboaz.SpringAcceptanceTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GlobalCustomAlertStep extends SpringAcceptanceTest {

    @Autowired ApplicationContext context;
    @Autowired TestRestTemplate rest;

    ResponseEntity<Object> response;

    @Given("`F3#` - the {string} microservice is running")
    public void f3_the_microservice_is_running(String serviceName) {
        assertNotNull(getClassMap(serviceName), "Microservice name is not registred");
        assertTrue(context.getBeanNamesForType(getClassMap(serviceName)).length > 0, "Microservice is not enable in context");
    }

    @When("`F3#` - a request is made to the any endpoint that provides an alert")
    public void f3_a_request_is_made_to_the_any_endpoint_that_provides_an_alert() {
        response = rest.getForEntity("/fail/endpoint", Object.class);
    }

    @Then("`F3#` - the microservice should return a custom alert")
    public void f3_the_microservice_should_return_a_custom_alert(DataTable dataTable) {
        @SuppressWarnings("unchecked")
        var json = (Map<String, Object>) response.getBody();
        assertNotNull(json, "Response body is null");

        validateContentType();
        validateFieldsTable(dataTable, 0, json);
        validateFieldsTable(dataTable, 1, json);
    }

    protected void validateFieldsTable(DataTable dataTable, Integer column, Map<String, Object> json) {
        var className = "";
        var iterator = dataTable.column(column).iterator();

        if (iterator.hasNext()) className = iterator.next(); // Get index in first line

        if (column.equals(1)) {
            @SuppressWarnings("unchecked")
            var alert = (Map<String, Object>) json.get("alert");
            assertNotNull(alert, "Object alert is null");
            interateJson(alert, iterator, className);
        } else {
            interateJson(json, iterator, className);
        }
    }

    protected void validateContentType() {
        var content = response.getHeaders().getContentType();
        if (content != null) {
            assertEquals("application/json", content.toString(), "Response body is not application/json");
        }
    }

    protected void interateJson(Map<String, Object> json, Iterator<String> iterator, String className) {
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (entry != null) assertTrue(json.containsKey(entry), "Key "+ entry +" not exist in " + className);
        }
    }
}
