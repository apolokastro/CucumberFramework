package stepDefinitions;

import org.testng.Assert;
import io.cucumber.java.en.*;
import pageObjects.GreenKartPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class Offers {
	TestContextSetup tcs;
	PageObjectManager obj;
	
	public Offers(TestContextSetup tcs) {
		this.tcs = tcs;
	}
	
	@Then("^User searched with (.+) shortname in offers page to check if product exist$")
	public void user_searched_with_shortname_in_offers_page_to_check_if_product_exist(String product) throws InterruptedException {
		switchToOffersPage();
		OffersPage op = tcs.pageObjectManager.getOffersPage();
		op.searhcItem(product);
	    Thread.sleep(1000);
	    tcs.secondProductName = op.getProductName();
	    System.out.println(tcs.secondProductName + " from Offers page");
	}
	
	@Then("Validates prodcut name matches in both pages")
	public void validates_prodcut_name_matches_in_both_pages() {
		Assert.assertEquals(tcs.firstProductName, tcs.secondProductName);
	}

	public void switchToOffersPage() {
		GreenKartPage gp = tcs.pageObjectManager.getGreenKartPage();
		gp.clickTopDealsLink();
		tcs.generics.switchTab();
	}
}