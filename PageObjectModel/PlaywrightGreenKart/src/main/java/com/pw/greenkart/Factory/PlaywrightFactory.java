package com.pw.greenkart.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

	Playwright playWright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	Properties prop;
	public Page initPlaywright(Properties prop) {
		playWright = Playwright.create();
		
		String browserName=prop.getProperty("browser");
		String url = prop.getProperty("url");
		
		switch (browserName.toLowerCase()) {
		case "chrome":
			browser = playWright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
			break;
		case "msedge":
			browser = playWright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));
			break;

		default:
			System.out.println("enter a valid browser: chrome/msedge");
			break;
		}
		
		browserContext = browser.newContext();
		page=browserContext.newPage();
		page.navigate(url);
		return page;
		
	}
	
	public Properties initProperties() {
		try {
			FileInputStream fi = new FileInputStream("./src/test/resources/Properties/Page.properties");
			prop = new Properties();
			prop.load(fi);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
}
