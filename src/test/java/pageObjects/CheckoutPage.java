package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By cartBag = By.xpath("//img[@alt='Cart']");
	private By checkoutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	private By promoButton = By.xpath("//button[@class='promoBtn']");
	private By placeOrderButton = By.xpath("//button[text()='Place Order']");
	
	public void checkOutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkoutButton).click();
	}
	
	public boolean verifyPromo() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(promoButton).isDisplayed();
	}
	
	public boolean verifyPlaceOrder() {
		return driver.findElement(placeOrderButton).isDisplayed();
	}
	
}
