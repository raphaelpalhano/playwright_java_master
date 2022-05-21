package br.com.train.web.maps;

import com.microsoft.playwright.Locator;
import br.com.train.web.pages.BasePage;

public abstract class LoginMap extends BasePage {
	
	public static Locator inputEmail = page.locator("input[data-test='email']");
	
	
	public static Locator inputPassword = page.locator("input[data-test='passwd']");
	
	public static Locator buttonSign = page.locator("//button[contains(text(), 'Entrar')]");
	
	
}
