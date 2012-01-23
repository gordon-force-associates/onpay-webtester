package com.forceassociates.onpay_webtester.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.forceassociates.onpay_webtester.util.VarArgConverters.asArray;

/**
 * Use this class verify application behavior described by  the steps defined by 
 * RegisterPeople stories. Each method in this class matches to one or more steps 
 * defined in the stories. 
 * 
 * This example shows how to use the examples table to execute a story multiple times
 * with different data, e.g., how to register more than one user using the same story.
 * 
 * This class uses a slfj class level logger at the TRACE level to aid development.
 * 
 * @author Gordon Force
 * 
 * @see <a href="http://jbehave.org/reference/stable/parametrised-scenarios.html">Parameter driven scenarios</a>
 * 
 */
public class RegisterPeopleSteps {

	private Logger logger = LoggerFactory.getLogger(RegisterPeopleSteps.class);

	@Given("a browser is on the OnPay registration page")
	public void gotoRegistrationPage() {
		logger.trace("go the OnPay registration page");
	}

	@When("filling out the registration form with <name> in the name field, <email> in the email address field, <amount> in the initial funding field and clicking on the $buttonName button")
	public void submitRegistrationForm(@Named("name") String name, // named parameters required for table data
			@Named("email") String email, @Named("amount") String amount,
			@Named("buttonName") String buttonName) {
		logger.trace(
				"fill out the registration form with name={}, email={}, amount={} and click on the {} button",
				asArray(name, email, amount, buttonName));
	}

	@Then("OnPay creates an account for <name> and displays their account page")
	public void verifyAccountPageName(@Named("name") String name) {
		logger.trace(
				"verify OnPay dispalys an account page with {} in the \"logged as\" field",
				name);
	}

}
