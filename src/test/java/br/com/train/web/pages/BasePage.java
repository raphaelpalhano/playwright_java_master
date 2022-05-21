package br.com.train.web.pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public abstract class BasePage {
	protected static Browser browser;
	protected static Page page;
	private static BrowserType browserType;
	
	
	
	protected static Page setupWeb(String browserType, Boolean headlesMod) {
		BrowserType managerBrowser = managerBrowsers(browserType);
		browser = managerBrowser.launch(new BrowserType.LaunchOptions().setHeadless(headlesMod));
		page = browser.newPage();
		return page;
	}
	
	
	
	private static BrowserType managerBrowsers(String browser) {
		switch (browser) {
		case "Firefox":
			browserType = Playwright.create().firefox();
			break;
		case "Chromium":
			browserType = Playwright.create().chromium();
			break;
		case "Webkit":
			browserType = Playwright.create().webkit();
			break;
			
		default:
			throw new IllegalArgumentException("Nao existe browser com esse nome" + browser);
			
		}
		return browserType;
	}
	

}
