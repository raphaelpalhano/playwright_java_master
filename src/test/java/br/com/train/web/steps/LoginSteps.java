package br.com.train.web.steps;

import br.com.train.web.pages.LoginPage;
import io.cucumber.java.en.Given;

public class LoginSteps {
	
	
	@Given("o acesso ao barriga App")
	public void acessando_app_barriga() {
		
		LoginPage.openApp();
	}

}
