package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class Checkout {
	TestContextSetup tcs;
	CheckoutPage cp;
	
	public Checkout(TestContextSetup tcs){
		this.tcs = tcs;
		this.cp = tcs.pageObjectManager.getCheckoutPage();
	}
	
	@And("User verify has ability to enter promo code and place the order")
	public void User_verify_has_ability_to_enter_promo_code_and_place_the_order() throws InterruptedException {
		Assert.assertTrue(cp.verifyPromo());
		Assert.assertTrue(cp.verifyPlaceOrder());
	}
	
	@Then("^User proceeds to Checkout and validate (.+) items in checkout page$")
	public void User_proceeds_to_Checkout_and(String item) {
		cp.checkOutItems();
	}
	
}