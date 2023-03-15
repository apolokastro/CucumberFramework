package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
	public WebDriver driver;
	
	public WebDriver WebDriverManager() {
		
		if(driver == null) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\rodol\\Documents\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			
			
			driver = new ChromeDriver(options);
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
			driver.manage().window().maximize();
		}
		return driver;
	}
}