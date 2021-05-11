package com.pwc.pulse.digital.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features", //the path of the feature files
		glue = { "com.pwc.pulse.digital.stepdefinition" }, //the path of the step definition files
		tags = {"@AllScenarios" },  // Execute all tests tagged as @AllScenarios OR @Scenario01 OR Scenario02 OR Scenario03
		monochrome = true, //display the console output in a proper readable format
		plugin = { "pretty", 
				"html:Reports" //To generate different types of reporting
				 }
		)

public class TestRunner {

}
