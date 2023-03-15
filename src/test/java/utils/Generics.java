package utils;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class Generics {
	public WebDriver driver;
	
	public Generics(WebDriver driver) {
		this.driver = driver;
	}

	public void switchTab() {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}
}
