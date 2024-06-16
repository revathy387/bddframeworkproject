package step.definition;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignUpPage;
import utilities.WebActions;

public class SignUpSteps {
	
	RemoteWebDriver driver = Hooks.getdriver();
	SignUpPage page;
	
	@Given("User navigates to home page")
	public void user_navigates_to_home_page() {
		
		WebActions.openurl(driver, "https://www.demoblaze.com/");
		//driver.get("https://www.demoblaze.com/");
		page = new SignUpPage(driver);
	}

	@When("User clicks on sign up link")
	public void user_clicks_on_sign_up_link() {
		
		page.clickSignUpLink();
		
	}

	@When("User enters the required details to signup")
	public void user_enters_the_required_details_to_signup(){
		
		page.register();
	}

	@Then("User has successfully registered")
	public void user_has_successfully_registered() {
		
		page.registration_success();
	}
}
