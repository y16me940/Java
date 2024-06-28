package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public HomePageObjects homePage;
	public OffersPageObjects offersPage;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public HomePageObjects getHomepageObject() {
		return homePage = new HomePageObjects(driver);
	}
	
	public OffersPageObjects getOfferspageObject() {
		return offersPage = new OffersPageObjects(driver);
	}

}
