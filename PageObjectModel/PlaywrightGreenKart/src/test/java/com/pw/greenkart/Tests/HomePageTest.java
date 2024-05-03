package com.pw.greenkart.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pw.greenkart.Base.BaseTest;
import com.pw.greenkart.Constants.AppConstants;

public class HomePageTest extends BaseTest {
	

	@Test(priority=1)
	public void validatePageTitleUrl() {
		String actualTitle = homePage.getHomePageTitle();
		String actualUrl = homePage.getHomePageURL();
		Assert.assertEquals(actualTitle, AppConstants.HOMEPAGE_TITLE);
		Assert.assertEquals(actualUrl, prop.getProperty("url"));
	}
	
	
	@DataProvider
	public Object[][] getProductNames(){
		return new Object[][] {
			{"Mac"},
			{"iMac"},
			{"Samsung"}
				
			};
		
	}
	@Test(dataProvider="getProductNames",priority=2)
	public void searchItem(String Itemname) {
		
		Assert.assertEquals(homePage.doSearch(Itemname), "Search - "+Itemname);
		
	}
}
