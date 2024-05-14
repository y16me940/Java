package com.pw.test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class IFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwrightObj=Playwright.create();
		
		Browser browser=playwrightObj.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		  
		BrowserContext browserContext=browser.newContext();
		  
		 Page page=browserContext.newPage();
		 page.navigate("https://www.formsite.com/templates/government/license-application/");
		 page.locator("img[alt='License Application Form']").click();
		 page.frameLocator("iframe[id='frame-one1060748588']").locator("input[name='RESULT_TextField-4']").fill("abdul rajak");
         String name=page.frameLocator("iframe[id='frame-one1060748588']").locator("input[name='RESULT_TextField-4']").inputValue();
         System.out.println("********************");
         System.out.println(name);
         System.out.println("********************");
         
         page.close();
         playwrightObj.close();
	}

}
