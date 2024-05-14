package com.pw.test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Playwright playwrightObj=Playwright.create();
		
		Browser browser=playwrightObj.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		  
		BrowserContext browserContext=browser.newContext();
		  
		 Page page=browserContext.newPage();
		 page.navigate("https://books-pwakit.appspot.com/");
		 Locator inputEle = page.locator("book-input-decorator input[aria-label='Search Books']");
				 inputEle.fill("jai khader Anna");
				 System.out.println(inputEle.inputValue());
				 
		// first mention the shadow dom element and then Actual locator
				
		Page page2=browserContext.newPage();
		page2.navigate("https://selectorshub.com/shadow-dom-in-iframe/");
		page2.frameLocator("iframe#pact").locator("div#snacktime input#tea").fill("Yes I like");
		//page2.frameLocator("#pact").locator("#snacktime #tea").fill("Yes I like");
		 

	}

}
