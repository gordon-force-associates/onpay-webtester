package com.forceassociates.onpay_webtester.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.forceassociates.onpay_webtester.util.VarArgConverters.asArray;

/**
 * Use this class verify application behavior described by  the steps defined by 
 * P2PSendMoney stories. Each method in this class matches to one or more steps 
 * defined in the stories. 
 * 
 * This class uses a slfj class level logger at the TRACE level to aid development
 * 
 * @author Gordon Force
 * 
 * @see <a href="http://jbehave.org/reference/stable/candidate-steps.html">Simple Step Candidate</a>
 * 
 */
public class P2PSendMoneySteps  {

	private String lastBalance = ""; // used to share context between steps.
	private Logger logger = LoggerFactory.getLogger(P2PSendMoneySteps.class);
	
	//Given        is logged into his account page and has an available balance of $90
	@Given("$payor is logged into his account page and has an available balance of $amount")
	public void loginToAccountPage(String payor, String amount) {
		logger.trace("verify {} is logged into OnPay. Log out of another account if required and login as {}", payor, payor);
		logger.trace("verify the available balance on the account page is {}", amount);
		lastBalance = amount;
	}
	
	//     filling out the send money form with         in the amount field,        in the recipient field and clicking on the            button 
	@When("filling out the send money form with $amount in the amount field, $payee in the recipient field and clicking on the $buttonName button")
	public void fillAndSumbitSendMoneyForm(String amount, String payee, String buttonName)
	{
		logger.trace("fill out the Send Money form with amount={}, receipeint={} and clicks the {} button", 
				asArray(amount, payee, buttonName));
	}
	

	//     OnPay updates the account page with an available balance of $90     and a pending $10 transaction to sue@localhost
	@Then("OnPay updates the account page with an available balance of $amount and a pending $10 transaction to $payee")
	public void verifyThenSucessfulPayorTransaction(String amount, String payee)
	{
		logger.trace("verify the current page (payor account) has an available balance of {} and a pending {} transaction to {} in the transactions table",
				amount, payee);
	}
	
	@Then("adds a payment notification to the account page for $payee in the notifications section")
	public void verifyPaymentNotification(String payee)
	{
		logger.trace("Log out of current (payee) account");
		logger.trace("Log into {} account", payee);
		logger.trace("Verify payment notificaiton from payor to $payee in the notification section their account page");
	}

	//     OnPay displays the account page with the available balance unchanged and the following message in the errors section 
	@Then("OnPay displays the account page with the available balance unchanged and the following message in the errors section $message")
	public void balancedUnchanged(String message)
	{
		logger.trace("verify the current page (payor account) has an available balance of {} and the message \"{}\" in the errors section",
				lastBalance, message);
	}
   
}



