 package utils;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	public WebDriver driver;
	
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public Generics generics;
	
	public String firstProductName;
	public String secondProductName;
	
	public TestContextSetup() {
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		generics = new Generics(testBase.WebDriverManager());
	}
}