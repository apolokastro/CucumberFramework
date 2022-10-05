package stepDefinitions;

import io.cucumber.java.en.*;

public class GreenKart {
	
	@Given("I want to write a step with precondition")
	public void i_want_to_write_a_step_with_precondition() {
	    System.out.println("one");
	}
	@And("some other precondition")
	public void some_other_precondition() {
		System.out.println("two");
	}
	@When("I complete action")
	public void i_complete_action() {
		System.out.println("three");
	}
	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		System.out.println("four");
	}
	
}