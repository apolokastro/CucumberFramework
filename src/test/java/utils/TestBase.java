package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException {
		
		FileInputStream fis = new FileInputStream("src/test/resources/global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String url = prop.getProperty("QAurl");
		
		if(driver == null) {
			
			if (prop.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				
				driver = new ChromeDriver(options);
			}
			
			if (prop.getProperty("browser").equals("edge")) {
				System.setProperty("webdriver.edge.driver","src/test/resources/msedgedriver.exe");
				
				driver = new EdgeDriver();
			}
			
			driver.get(url);
			driver.manage().window().maximize();
		}
		return driver;
	}
}