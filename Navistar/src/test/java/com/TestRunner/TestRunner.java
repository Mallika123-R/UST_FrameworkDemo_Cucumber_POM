package com.TestRunner; 
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
 features = "src/test/resources/Features/",
 glue={"com.stepDefinition"},monochrome = true,dryRun = false,plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/cucumber-reports.html","json:target/cucumber.json","junit:target/cucmber.xml"}
)
 @Test
public class TestRunner extends AbstractTestNGCucumberTests {
	
	
	@DataProvider(parallel = false)
	 @Override
	 public Object[][] scenarios() {
	 return super.scenarios();
	 } 
}