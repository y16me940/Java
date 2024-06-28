package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestContextSetup;

public class HomePageObjects {
	public WebDriver driver;
	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4.product-name");
	
	public HomePageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	public void searchItem(String name) {
	driver.findElement(search).sendKeys(name);;
	}
	
	public String getItem() {
		return driver.findElement(productName).getText();
	}
	

}
