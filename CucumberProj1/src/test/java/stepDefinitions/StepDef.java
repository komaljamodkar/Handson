package stepDefinitions;



import java.util.List;

import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
public class StepDef {

	@Given("User is on NetBanking landing page")
	public void user_is_on_net_banking_landing_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("landing on home page");
	}

	@When("User login into application with username and password")
	public void user_login_into_application_with_username_and_password() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("entered uname and pwd");
	}

	@Then("Home page is populated")
	public void home_page_is_populated() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("home page populated");

	}

	@And("Cards are displayed")
	public void cards_are_displayed() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("cards are displayed");

	}

	@When("User login into application with username {string} and password {string}")
	public void user_login_into_application_with_username_and_password(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("entered correct u name and pwd");
				
	}

	@When("User login into application with sername {string} and password {string}")
	public void user_login_into_application_with_sername_and_password(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("entered wrong u name and pwd");
		System.out.println("String1="+string);
		   System.out.println("String1="+string2);
		
	}

	@When("Cards are not displayed")
	public void cards_are_not_displayed() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("cards are not displayed");
	}

	
	@When("User login into application with {string} and password {string}")
		public void user_login_into_application_with_and_password(String arg1, String arg2) {
		    // Write code here that turns the phrase above into concrete actions
		   System.out.println("String1="+arg1);
		   System.out.println("String1="+arg2);
		}


		@Then("Cards displayed {string}")
		public void cards_displayed(String string) {
		    // Write code here that turns the phrase above into concrete actions
		    System.out.println(string);
		}

		@When("User signup with following details")
			public void user_signup_with_following_details(io.cucumber.datatable.DataTable data) {
			    // Write code here that turns the phrase above into concrete actions
			    // For automatic transformation, change DataTable to one of
			    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
			    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
			    // Double, Byte, Short, Long, BigInteger or BigDecimal.
			    //
			    // For other transformations you can register a DataTableType.
			    
			//List <List<String>> obj=data.asLists();
			List <String> obj=data.asList();
			System.out.println(obj.size());
			System.out.println(obj.get(0));
			
			for(String value : obj)
			{
				System.out.print("|"+value+" ");
				
			}
			
			}


		






}
