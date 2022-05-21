package br.com.train.web.runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = "src/test/resources/features",
		glue = {"br.com.train.web.steps", "br.com.train.web.pages", "br.com.train.web.core"}, 
		plugin = {"pretty","junit:target/junitreport.xml","json:target/jsonreport.json",
				"html:target/cucumber-reports"})
public class TestRunner {
	
	 private TestRunner() {

	 }

}
