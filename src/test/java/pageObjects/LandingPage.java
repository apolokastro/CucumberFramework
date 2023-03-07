package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By searchBar = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("h4.product-name");
	private By lnkTopDals = By.linkText("Top Deals");
	
	public void searhcItem(String shortName) {
		driver.findElement(searchBar).sendKeys(shortName);
	}
	
	public void getSearchText() {
		driver.findElement(searchBar).getText();
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public void clickTopDealsLink() {
		driver.findElement(lnkTopDals).click();
	}
}
