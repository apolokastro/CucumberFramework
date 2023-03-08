package stepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pageObjects.GreenKartPage;
import utils.TestContextSetup;

public class GreenKart {
	TestContextSetup tcs;
	
	public GreenKart(TestContextSetup tcs){
		this.tcs = tcs;
	}
	
	@Given("User is in GreenKart landing page")
	public void user_is_in_green_kart_landing_page() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rodol\\Documents\\chromedriver.exe");
		tcs.driver = new ChromeDriver();
		tcs.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		tcs.driver.manage().window().maximize();
	}
	
	@When("User searches with shortname {string} and extract the actual name of product")
	public void user_searches_with_shortname_and_extract_the_actual_name_of_product(String product) throws InterruptedException {
		GreenKartPage gp = new GreenKartPage(tcs.driver);
		gp.searhcItem(product);
		Thread.sleep(1000);
		tcs.firstProductName = gp.getProductName().split("-")[0].trim();
		System.out.println(tcs.firstProductName + " from HomePage");
	}
}