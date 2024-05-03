package com.pw.greenkart.Base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.pw.greenkart.Factory.PlaywrightFactory;
import com.pw.greenkart.Pages.HomePage;

public class BaseTest {
	PlaywrightFactory pf;
	protected Properties prop;
	Page page;
	protected HomePage homePage;
	
	@BeforeTest
	public void setup() {
		pf=new PlaywrightFactory();
		prop =pf.initProperties();
		page=pf.initPlaywright(prop);
		homePage=new HomePage(page);
		
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
