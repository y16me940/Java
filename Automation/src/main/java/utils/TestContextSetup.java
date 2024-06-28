package utils;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;
	public String HomepageProductName;
	public PageObjectManager pageObjects;
	
	public TestContextSetup() {
		pageObjects = new PageObjectManager(driver);
	}
}
