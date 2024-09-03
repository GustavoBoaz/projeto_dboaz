package com.dboaz.steps.global_ms;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

public class GlobalRedirectToSwaggerStep extends SpringAcceptanceTest {
 
    @Autowired ApplicationContext context;
    @Autowired TestRestTemplate rest;

    ResponseEntity<String> response;

    @Given("`F5#` - the {string} microservice is running")
    public void f5_the_microservice_is_running(String serviceName) {
        assertNotNull(getClassMap(serviceName), "Microservice name is not registred");
        assertTrue(context.getBeanNamesForType(getClassMap(serviceName)).length > 0, "Microservice is not enable in context");
    }

    @When("`F5#` - make a GET request to {string}")
    public void f5_make_a_get_request_to(String path) {
        response = rest.getForEntity(path, String.class);
    }

    @Then("`F5#` - the response should have an HTTP status {int}")
    public void f5_the_response_should_have_an_http_status(Integer status) {
        if (status.equals(200)) {
            assertTrue(response.getStatusCode().is2xxSuccessful(), "Response is not present in range 200");
        }
    }

    @Then("`F5#` - the content-type equals text\\/html")
    public void f5_the_content_type_equals_text_html() {
        var content = response.getHeaders().getContentType();
        if (content != null) {
            assertEquals("text/html", content.toString(), "Response body is not text/html");
        }
    }
}
