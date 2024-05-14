package com.pw.test;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class MultiDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwrightObj=Playwright.create();
		
		Browser browser=playwrightObj.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		  
		BrowserContext browserContext=browser.newContext();
		  
		  Page page=browserContext.newPage();
		  page.navigate("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
		  
		  Locator dropdownField = page.locator("#multi-select");
		  
		  List<String> as=dropdownField.selectOption(new SelectOption[]{
						  new SelectOption().setLabel("New York"), 
						  new SelectOption().setLabel("Texas"), 
						  new SelectOption().setValue("California"), 
						  new SelectOption().setIndex(7)});
		  System.out.println(as);
				  
				  

	}

	

}
