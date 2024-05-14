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

public class TextSelectors {

	static Playwright playwrightObj;
	static Browser browser;
	static BrowserContext browserContext;
	static Page page;
	
	public static void main(String[] a) {
		
	  playwrightObj=Playwright.create();
		
	  browser=playwrightObj.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
	  
	  browserContext=browser.newContext();
	  
	  page=browserContext.newPage();
	  browserContext.tracing().start(new Tracing.StartOptions()
			  .setScreenshots(true)
			  .setSnapshots(true)
			  .setSources(true));

	  
	  page.navigate("https://naveenautomationlabs.com/opencart/");
	  System.out.println(page.title());
//	  String sol = page.locator("text=Desktops").first().innerText();
//	  System.out.println(sol);
//	  page.locator("text=Desktops").first().click();
//	  List<String> solList=page.locator("'Desktops'").allInnerTexts();
//	  System.out.println("**********************");
//	  for(String e : solList) {
//		  
//		  System.out.println(e); 
//	  }
//	  System.out.println("**********************");
//	 Locator prev = page.locator(".swiper-button-prev").first();
//	 for(int i=0;i<9;i++){
//	 prev.click();
//	 }
	  List<String> myAccountList = page.locator("span:has-text('My Account')").allTextContents();
	  page.locator("span:has-text('My Account')").click();
	  page.locator("'Login'").click();
	  String atr =page.locator("div.list-group a:has-text('Login')").getAttribute("class");
	  System.out.println(atr);
	  System.out.println("**********************");
	  for (String e: myAccountList) {
		  System.out.println(e);
	  }
	  System.out.println("**********************");
	  
	  
	  //browserContext.close();
	  
	  browserContext.tracing().stop(new Tracing.StopOptions()
			  .setPath(Paths.get("trace.zip")));
	  
	  
	  // locator("text=Desktops") -- Partial search
	  // locator("'Desktops'")  -- Exact search
	  // locator("h2:has-text('Desktops')")  -- element level search
	  // locator("div.<classname> h2:has-text('Desktops')")  -- div container level search with classname
	  // locator("<container>.<classname> h2:has-text('Desktops')")  -- other container level search with classname
	  // locator("<parentTag> h2:has-text('Desktops') -- parent child
	  //locator("<parentTag>[<attribute>='<value>'] h2:has-text('Desktops')")  -- parent to child

	}
}
