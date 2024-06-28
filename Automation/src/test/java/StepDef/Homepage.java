package StepDef;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import net.bytebuddy.asm.Advice.OffsetMapping.Target.AbstractReadOnlyAdapter;
import pageObjects.HomePageObjects;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class Homepage {
	//public WebDriver driver;
	//public String HomepageProductName;
	
	TestContextSetup test;
	
	public Homepage(TestContextSetup testContextSetup) {
		this.test=testContextSetup;
	}
	
	
	
	@Given("user lands at the homepage of the greenKart application")
	public void user_lands_at_the_homepage_of_the_green_kart_application() {
	    // C:\Users\abdul\Downloads\chromedriver-win64
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abdul\\Downloads\\chromedriver-win64\\chromedriver.exe");
		test.driver = new ChromeDriver();
		test.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
	    
	}
	
	@And("searches for a product with the shorname {string} by ectracting full name")
	public void searches_for_a_product_with_the_shorname_by_ectracting_full_name(String shortName) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		HomePageObjects homepage=test.pageObjects.getHomepageObject();
		homepage.searchItem(shortName);
	
		Thread.sleep(2000);
	    test.HomepageProductName = homepage.getItem().split("-")[0].trim();
	    System.out.println("Homepage Product Name is: "+test.HomepageProductName);
	}
	
}
