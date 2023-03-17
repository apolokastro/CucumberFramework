package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public GreenKartPage gp;
	public OffersPage op;
	public CheckoutPage cp;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public GreenKartPage getGreenKartPage() {
		gp = new GreenKartPage(driver);
		return gp;
	}
	
	public OffersPage getOffersPage() {
		op = new OffersPage(driver);
		return op;
	}
	
	public CheckoutPage getCheckoutPage() {
		cp = new CheckoutPage(driver);
		return cp;
	}
}