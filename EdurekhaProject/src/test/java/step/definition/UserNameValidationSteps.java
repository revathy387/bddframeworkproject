package step.definition;

import java.time.Duration;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DemoBlazeHomePage;
import pages.DemoBlazeLoginPage;
import pages.DemoBlazeLogoutPage;
import utilities.BrowserUtil;

public class UserNameValidationSteps {

	RemoteWebDriver driver = Hooks.getdriver();
	DemoBlazeLoginPage loginpage;
	DemoBlazeLogoutPage logoutpage;
	DemoBlazeHomePage homePage;
	
	
	@Given("User opens the browser")
	public void user_opens_the_browser() {

		loginpage = new DemoBlazeLoginPage(driver);
		logoutpage = new DemoBlazeLogoutPage(driver);
		homePage = new DemoBlazeHomePage(driver);
	}

	@When("User navigated to the login page")
	public void user_navigated_to_the_login_page() {

		driver.get("https://www.demoblaze.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		loginpage.clickloginlink();
	}

	@When("Enter username as {string} and validate")
	public boolean enter_username_as_and_validate(String string){

		loginpage.enterusername(string);
		try{Thread.sleep(2000);}catch(InterruptedException e) {}
		if(string.equalsIgnoreCase("Aditi2013")) {
			return true;
		}else {
			return false;
		}
	}


	@When("User enters user name as {string} and password as {string}")
	public void user_enters_user_name_as_and_password_as(String string, String string2) {
		try{Thread.sleep(2000);}catch(InterruptedException e) {}
		loginpage.enterusername(string);
		loginpage.enterpassword(string2);

	}

	@When("Clicks on Login button")
	public void clicks_on_login_button() {
		loginpage.clickloginbutton();
	}

	@Then("the home page is displayed")
	public void the_home_page_is_displayed() {
		logoutpage.successfullLoginValidation();
	}
	
	
}
