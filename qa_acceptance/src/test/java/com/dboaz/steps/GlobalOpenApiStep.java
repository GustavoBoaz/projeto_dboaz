package com.dboaz.steps;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;

import com.dboaz.SpringAcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GlobalOpenApiStep extends SpringAcceptanceTest {

    @Autowired ApplicationContext context;
    @Autowired TestRestTemplate rest;

    ResponseEntity<Object> response;

    @Given("`F2#` - the {string} microservice is running")
    public void f2_the_microservice_is_running(String serviceName) {
        assertNotNull(getClassMap(serviceName), "Microservice name is not registred");
        assertTrue(context.getBeanNamesForType(getClassMap(serviceName)).length > 0, "Microservice is not enable in context");
    }

    @When("`F2#` - make a GET request to {string}")
    public void f2_make_a_get_request_to(String path) {
        response = rest.getForEntity(path, Object.class);
    }

    @Then("`F2#` - the response should have an HTTP status {int}")
    public void f2_the_response_should_have_an_http_status(Integer int1) {
        assertTrue(response.getStatusCode().is2xxSuccessful(), "The status code are not range 200");
    }
}
