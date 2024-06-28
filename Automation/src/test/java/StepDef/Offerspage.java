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
import pageObjects.OffersPageObjects;
import utils.TestContextSetup;

public class Offerspage {
	
	
	public String offerspageProductName;
	TestContextSetup test;
	
	public Offerspage(TestContextSetup testContextSetup) {
		this.test=testContextSetup;
	}
	
	@Then("searches for the same product in OffersPage with same shortname {string}")
	public void searches_for_the_same_product_in_offers_page_with_same_shortname(String shortName) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		OffersPageObjects offerPage=test.pageObjects.getOfferspageObject();
		
		switchToOffersPage();
		offerPage.search(shortName);
	    Thread.sleep(2000);
	    offerspageProductName = offerPage.getItem();
	    System.out.println("OffersPage Product Name is: "+offerspageProductName);
	    
	    
	}
	
	public void switchToOffersPage() {
		test.driver.findElement(By.linkText("Top Deals")).click();
		Set<String> s1 = test.driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
	    String parentWindow = i1.next();
	    String childWindow = i1.next();
	    test.driver.switchTo().window(childWindow);
	}
	
	
	@And("vlidate the product names in both the pages")
	public void vlidate_the_product_names_in_both_the_pages() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(test.HomepageProductName, offerspageProductName);
	}


}
