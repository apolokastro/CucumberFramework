package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GreenKartPage {
	WebDriver driver;
	
	public GreenKartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By searchBar = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("h4.product-name");
	private By lnkTopDals = By.linkText("Top Deals");
	private By incrementButton = By.xpath("//a[@class='increment']");
	private By addToCartButton = By.xpath("//button[text()='ADD TO CART']");
	
	public void searhcItem(String product) {
		driver.findElement(searchBar).sendKeys(product);
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public void clickTopDealsLink() {
		driver.findElement(lnkTopDals).click();
	}
	
	public String getTitleGreenPage() {
		return driver.getTitle();
	}
	
	public void incrementQuantity(int quantity) {
		int i = quantity-1;
		while (i > 0) {
			driver.findElement(incrementButton).click();
			i--;
		}
	}
	
	public void addToCart() {
		driver.findElement(addToCartButton).click();
	}
}
