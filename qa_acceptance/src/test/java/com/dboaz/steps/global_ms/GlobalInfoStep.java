package com.dboaz.steps.global_ms;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

public class GlobalInfoStep extends SpringAcceptanceTest {

    @Autowired ApplicationContext context;
    @Autowired TestRestTemplate rest;

    ResponseEntity<Object> response;

    @Given("`F1#` - the {string} microservice is running")
    public void the_microservice_is_running(String serviceName) {
        assertNotNull(getClassMap(serviceName), "Microservice name is not registred");
        assertTrue(context.getBeanNamesForType(getClassMap(serviceName)).length > 0, "Microservice is not enable in context");
    }

    @When("`F1#` - make a GET request to {string}")
    public void make_a_get_request_to(String path) {
        response = rest.getForEntity(path, Object.class);
    }

    @Then("`F1#` - the response should have an HTTP status {int}")
    public void the_response_should_have_an_http_status(Integer status) {
        assertTrue(response.getStatusCode().is2xxSuccessful(), "The status code are not range 200");
    }

    @Then("`F1#` - the response body should contain the following fields with expected values:")
    public void the_response_body_should_contain_the_following_fields_with_expected_values(DataTable dataTable) {

        @SuppressWarnings("unchecked")
        var json = (Map<String, Object>) response.getBody();
        var iterator = dataTable.asMap(String.class, String.class).entrySet().iterator();

        if (iterator.hasNext()) iterator.next(); // Ignore index line

        assertNotNull(json, "Response body is null");

        while (iterator.hasNext()) {
            var entry = iterator.next();
            assertTrue(json.containsKey(entry.getKey()), "Key not exist");
            assertTrue(entry.getValue().equals(json.get(entry.getKey()).toString()), "Key " + entry.getKey() + " does not match expected value");
        }
    }
}
