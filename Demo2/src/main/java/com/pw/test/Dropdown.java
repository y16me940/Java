package com.pw.test;

import java.nio.file.Paths;
import java.util.List;

import org.w3c.dom.Text;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.SelectOption;

public class Dropdown {

	static Playwright playwrightObj;
	static Browser browser;
	static BrowserContext browserContext;
	static Page page;
	
	public static void main(String[] a) throws InterruptedException {
		
	  playwrightObj=Playwright.create();
		
	  browser=playwrightObj.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
	  
	  browserContext=browser.newContext();
	  Page page = browserContext.newPage();
	 

	  
	  page.navigate("https://www.orangehrm.com/en/30-day-free-trial/");
	  System.out.println(page.title());

	  page.locator("button:has-text('Allow all')").click();
	  Locator country = page.locator("#Form_getForm_Country");
	  System.out.println(country.allTextContents());
	  
	  //List<String> as= country.selectOption("Afghanistan");
	  //List<String> as= country.selectOption(new SelectOption().setLabel("Afghanistan"));
	 // List<String> as= country.selectOption(new SelectOption().setValue("Afghanistan"));
	 List<String> as= country.selectOption(new SelectOption().setIndex(1));
	  
	 
	 
	 System.out.println("************************");
	  System.out.println(as.get(0));
	  page.frameLocator("iframe[title='reCAPTCHA']").locator("span#recaptcha-anchor").click();
	  System.out.println("************************");
	  

	}
}
