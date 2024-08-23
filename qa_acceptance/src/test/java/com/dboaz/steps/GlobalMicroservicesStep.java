package com.dboaz.steps;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dboaz.SpringAcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GlobalMicroservicesStep extends SpringAcceptanceTest {

    @Given("that the customer wants to know the version of the resource")
    public void that_the_customer_wants_to_know_the_version_of_the_resource() {
        assertTrue(true);
    }

    @When("the client makes call to GET \\/version")
    public void the_client_makes_call_to_get_version() {
        assertTrue(true);
    }

    @Then("the client receives status code of {int}")
    public void the_client_receives_status_code_of(Integer int1) {
        assertEquals(int1, 200);
    }

    @Then("the client receives server version {double}")
    public void the_client_receives_server_version(Double double1) {
        assertEquals(double1, 1.0);
    }
}
