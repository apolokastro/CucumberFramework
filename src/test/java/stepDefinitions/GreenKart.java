package stepDefinitions;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import io.cucumber.java.en.*;


public class GreenKart {
	public WebDriver driver;
	
	String firstProductName;
	String secondProductName;
	
	@Given("User is in GreenKart landing page")
	public void user_is_in_green_kart_landing_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rodol\\Documents\\chromedriver.exe");
	    driver = new ChromeDriver();
	   
	    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	    driver.manage().window().maximize();
	}
	
	@When("User searches with shortname {string} and extract the actual name of product")
	public void user_searches_with_shortname_and_extract_the_actual_name_of_product(String string) throws InterruptedException {
	    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
	    Thread.sleep(1000);
	    firstProductName = driver.findElement(By.xpath("//h4[@class='product-name']")).getText().split("-")[0].trim();
	}
	
	@Then("User searched with shortname {string} in offers page to check if product exist")
	public void user_searched_with_same_shortname_in_offers_page_to_check_if_product_exist(String string) throws InterruptedException {
	    driver.findElement(By.xpath("//a[@class='cart-header-navlink' and text()='Top Deals']")).click();
	    
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    
	    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
	    
	    Thread.sleep(1000);
	    secondProductName =  driver.findElement(By.xpath("//td[contains(text(),'"+string+"')]")).getText();
	}
	
	@Then("Validates prodcut name matches in both pages")
	public void user_searched_with_same_shortname_in_offers_page_to_check_if_product_exist() {
	    Assert.assertEquals(firstProductName, secondProductName);
	    
	    driver.quit();
	}
	
}