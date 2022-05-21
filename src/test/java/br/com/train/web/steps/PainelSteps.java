package br.com.train.web.steps;

import br.com.train.web.pages.LoginPage;
import io.cucumber.java.pt.Entao;

public class PainelSteps {

	@Entao("deve exibir uma mensagem {string}")
	public void validando_alerta(String message) {
		LoginPage.validateMessage(message);
	}
}
