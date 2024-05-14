package com.pw.test;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class Frames {
	Playwright playwrightObj;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwrightObj=Playwright.create();
			
		Browser browser=playwrightObj.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		  
		BrowserContext browserContext=browser.newContext();
		  
		  Page page=browserContext.newPage();
		  
		  
		  page.navigate("https://www.londonfreelance.org/courses/frames/index.html");
		  String frameName=page.frameLocator("frame[name='navbar']").locator("text=No frames").textContent();
		  System.out.println(frameName); 
		  
		  String frameName2=page.frame("main").locator("body h2:has-text('Title bar ')").textContent();
		  System.out.println(frameName2);
		  
		  //page.frameLocator() --> it accepts any attribute
		  //page.frame() --> it accepts only name attribute

		  
		  
		  page.close();
		  playwrightObj.close();

	}

}
