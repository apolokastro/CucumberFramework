package stepDefinitions;

import java.util.ArrayList;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pageObjects.GreenKartPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class Offers {
	TestContextSetup tcs;
	
	public Offers(TestContextSetup tcs) {
		this.tcs = tcs;
	}
	
	@Then("User searched with {string} shortname in offers page to check if product exist")
	public void user_searched_with_shortname_in_offers_page_to_check_if_product_exist(String product) throws InterruptedException {
		switchToOffersPage();
		OffersPage op = new OffersPage(tcs.driver);
		op.searhcItem(product);
	    Thread.sleep(1000);
	    tcs.secondProductName = op.getProductName();
	}
	
	@Then("Validates prodcut name matches in both pages")
	public void validates_prodcut_name_matches_in_both_pages() {
		Assert.assertEquals(tcs.firstProductName, tcs.secondProductName);
		tcs.driver.quit();
	}

	public void switchToOffersPage() {
		GreenKartPage gp = new GreenKartPage(tcs.driver);
		gp.clickTopDealsLink();
		ArrayList<String> tabs = new ArrayList<String> (tcs.driver.getWindowHandles());
		tcs.driver.switchTo().window(tabs.get(1));
	}
}