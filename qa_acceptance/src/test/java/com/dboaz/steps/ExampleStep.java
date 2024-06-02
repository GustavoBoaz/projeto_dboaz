package com.dboaz.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExampleStep {
  @Given("I have a step")
  public void i_have_a_step() {
    assert true;
  }
  @When("I do something")
  public void i_do_something() {
    assert true;
  }
  @Then("I should see something")
  public void i_should_see_something() {
    assert true;
  }
}
