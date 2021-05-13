package stepDefinitions;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
public class StepDefinition1 {
	private int res=0;
	@Given("You have calculator")
		public void you_have_calculator() {
		    // Write code here that turns the' phrase above into concrete actions
		   
		}

		@When("you multiply {int} and {int}")
		public void you_multiply_and(Integer int1, Integer int2) {
		    // Write code here that turns the phrase above into concrete actions
			
			res=int1*int2;
			System.out.println("num1 :"+int1+" num2 :"+int2+" = "+res);
		    
		}
		@Test
		@Then("result displayed {int}")
		public void result_displayed(Integer int1) {
		    // Write code here that turns the phrase above into concrete actions
			//assertTrue("the expected total 8,but actual is :"+res,res==int1);
			Assert.assertTrue("the expected total 8,but actual is :"+res,res==int1);
		   
		}



}
