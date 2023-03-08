package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	WebDriver driver;
	
	public OffersPage(WebDriver driver) {
		this.driver =  driver;
	}
	
	private By searchBar = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("tr td:nth-child(1)");
	
	public void searhcItem(String shortName) {
		driver.findElement(searchBar).sendKeys(shortName);
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
}