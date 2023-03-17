package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

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
			
			/*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					  .withTimeout(Duration.ofSeconds(30))
					  .pollingEvery(Duration.ofSeconds(5))
					  .ignoring(NoSuchElementException.class);*/
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(url);
			driver.manage().window().maximize();
		}
		return driver;
	}
}