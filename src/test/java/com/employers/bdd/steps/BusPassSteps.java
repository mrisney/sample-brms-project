package com.employers.bdd.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import com.employers.sample.model.AdultBusPass;
import com.employers.sample.model.BusPassList;
import com.employers.sample.model.ChildBusPass;
import com.employers.sample.model.Person;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BusPassSteps {
	
	  List<Object> facts = new ArrayList<>();
	  List<String> nameList = new ArrayList<>();

	  @Given("^bus passes are issued to persons with the following details:$")
	  public void bus_passes_are_issued_to_persons(List<Map<String,String>> table) throws Throwable {
	      facts.clear();
          BusPassList.adultBusPassList.clear();
          BusPassList.childBusPassList.clear();
		  for (Map<String,String> row: table) {
		      String firstname = row.get("Firstname");
		      String lastname = row.get("Lastname");
		      int age = Integer.valueOf(row.get("Age"));
		      facts.add(new Person(firstname, lastname, age));
		  }  
	  }
	  
	  @When("^the bus passes are submitted$")
	  public void submit_bus_passes() throws Throwable {
		  KieServices kieServices = KieServices.Factory.get(); 
	      KieContainer kContainer = kieServices.getKieClasspathContainer(this.getClass().getClassLoader()); 
	      StatelessKieSession ksession = kContainer.newStatelessKieSession();
//	      ksession.addEventListener(new DebugRuleRuntimeEventListener());
//	      ksession.addEventListener(new DebugAgendaEventListener());
	      ksession.execute(facts);
	  }


	  @Then("the child bus passes should be issued to the following persons:$")
	  public void child_bus_passes_submitted_to_persons(List<Map<String,String>> table) throws Throwable {
	      nameList.clear();
	      for (ChildBusPass bp: BusPassList.childBusPassList) {
	    	      nameList.add(bp.getPerson().getFirstName() + ":" + bp.getPerson().getLastName());
	      }
	      for (Map<String,String> row: table) {
	          String firstname = row.get("Firstname");
	          String lastname = row.get("Lastname");
	          Assert.assertEquals(2, BusPassList.childBusPassList.size());
	          Assert.assertTrue(nameList.contains(firstname + ":" + lastname));
	      }
	  }

	  
	  @Then("the adult bus passes should be issued to the following persons:$")
	  public void adult_bus_passes_submitted_to_persons(List<Map<String,String>> table) throws Throwable {
	      nameList.clear();
		  for (AdultBusPass bp: BusPassList.adultBusPassList) {
		      nameList.add(bp.getPerson().getFirstName() + ":" + bp.getPerson().getLastName());
		  }	    
	      for (Map<String,String> row: table) {
	          String firstname = row.get("Firstname");
	          String lastname = row.get("Lastname");
	          Assert.assertEquals(2, BusPassList.adultBusPassList.size());
		      Assert.assertTrue(nameList.contains(firstname + ":" + lastname));
	      }
	  }  


}
