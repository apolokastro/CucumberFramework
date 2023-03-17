package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.GreenKartPage;
import utils.TestContextSetup;

public class GreenKart {
	TestContextSetup tcs;
	GreenKartPage gp;
	
	public GreenKart(TestContextSetup tcs){
		this.tcs = tcs;
		this.gp = tcs.pageObjectManager.getGreenKartPage();
	}
	
	@Given("User is in GreenKart landing page")
	public void user_is_in_green_kart_landing_page() {
		Assert.assertTrue(gp.getTitleGreenPage().contains("GreenKart"));
	}
	
	@When("^User searches with shortname (.+) and extract the actual name of product$")
	public void user_searches_with_shortname_and_extract_the_actual_name_of_product(String product) throws InterruptedException {
		gp.searhcItem(product);
		Thread.sleep(1000);
		tcs.firstProductName = gp.getProductName().split("-")[0].trim();
		System.out.println(tcs.firstProductName + " from HomePage");
	}
	
	@And("User added {string} itemes of the selected products to cart")
	public void User_added_itemes_of_the_selected_products_to_cart(String ammount) {
		gp.incrementQuantity(Integer.parseInt(ammount));
		gp.addToCart();
	}
}