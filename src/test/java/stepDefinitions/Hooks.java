package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.After;
import utils.TestContextSetup;

public class Hooks {
	public TestContextSetup tcs;
	
	public Hooks(TestContextSetup tcs) {
		this.tcs = tcs;
	}
	
	@After
	public void AfterScenario() throws IOException {
		tcs.testBase.WebDriverManager().quit();
		System.out.println("Driver destroyed...");
	}

}
