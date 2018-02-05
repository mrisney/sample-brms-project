package com.employers.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@Cucumber.Options(format = {/*"html:target/cucumber-html-report", */"json-pretty:target/cucumber-json-report.json"})
//@Cucumber.Options(features={"src/test/resources"}, glue={"cucumber.com.zzz.yyy.steps"}, format={"html:target/test-reports"}, )
//format = {"pretty", /*"html:target/cucumber",*/ "json:target/cucumber.json"}//, "rerun:target/rerun.txt"}

@CucumberOptions(
  features={"src/test/resources"},	
  monochrome = false, 
  format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"}//, "rerun:target/rerun.txt"}
  )
public class RunCucumberTest {
	
	
}