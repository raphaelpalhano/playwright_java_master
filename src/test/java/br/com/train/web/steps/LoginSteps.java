package br.com.train.web.steps;

import br.com.train.web.pages.LoginPage;
import io.cucumber.java.pt.Dado;

public class LoginSteps {
	
	
	@Dado("o acesso do usuario")
	public void acessando_do_usuario() {
		LoginPage.fillLoginFields();
		LoginPage.clickSign();
	}


}
