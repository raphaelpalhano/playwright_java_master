package br.com.train.web.pages;


import static org.junit.Assert.assertEquals;

import br.com.train.web.core.AccessDataManager;
import br.com.train.web.maps.LoginMap;

public class LoginPage extends BasePage{
	
	private static String email;
	private static String password;
	

	
	
	public static void fillLoginFields() {
		try {
			email = AccessDataManager.getData().getUsername();
			password = AccessDataManager.getData().getPassword();
			LoginMap.inputEmail.type(email);
			LoginMap.inputPassword.type(password);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void clickSign() {
		LoginMap.buttonSign.click();
	}
	
	public static void validateMessage(String message) {
		page.onDialog(dialog -> {
			assertEquals(message, dialog.message());
		});
	}

}
