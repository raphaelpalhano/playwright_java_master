package br.com.train.web.pages;

import br.com.train.web.core.AccessDataManager;

public class LoginPage extends BasePage{
	private static String url;
		

	public static void openApp() {
		try {
			url = AccessDataManager.getData().getUrl();
		    page.navigate(url);	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sign() {
		
	}

}
