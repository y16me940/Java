package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestContextSetup;

public class OffersPageObjects {
	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("td:nth-child(1)");
    public WebDriver driver;
	
	public OffersPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	public void search(String name) {
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(name);
	}
	
	public String getItem() {
		return driver.findElement(productName).getText();
	}


}
