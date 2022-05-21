package br.com.train.web.core;

import br.com.train.web.pages.BasePage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook extends BasePage{
	
	
	@Before
	public void before(Scenario scenario) throws Exception {
		System.out.println(scenario.getName());
		setupWeb("Chromium", false);
		openApp();
	}

}
