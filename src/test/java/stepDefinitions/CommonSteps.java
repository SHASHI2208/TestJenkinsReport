package stepDefinitions;

import cucumber.api.java.en.When;

public class CommonSteps {
	
	@When("^Display Name$")
	public void display_Name() {
	    System.out.println("Shashi printed");
	}

}
