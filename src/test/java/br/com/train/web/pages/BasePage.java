package br.com.train.web.pages;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import br.com.train.web.core.AccessDataManager;

public abstract class BasePage {
	protected static Browser browser;
	protected static Page page;
	private static BrowserType browserType;
	private static String url;
	
	
	protected static Page setupWeb(String browserType, Boolean headlessMod) {
		BrowserType managerBrowser = managerBrowsers(browserType);
		browser = managerBrowser.launch(new BrowserType.LaunchOptions()
				.setHeadless(headlessMod)
				.setTimeout(10000)
				);
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
	
	
	protected static void openApp() {
		try {
			url = AccessDataManager.getData().getUrl();
		    page.navigate(url);	
		    page.setViewportSize(1920, 1080);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
