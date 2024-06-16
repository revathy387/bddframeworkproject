package step.definition;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DemoBlazeHomePage;

public class HomePageSteps {

	RemoteWebDriver driver = Hooks.getdriver();
	DemoBlazeHomePage homePage;

	@Given("User launches the browser")
	public void user_launches_the_browser() {

		homePage = new DemoBlazeHomePage(driver);
	}


	@When("User launches the home page")
	public void user_launches_the_home_page(){

		driver.get("https://www.demoblaze.com/");
		try{Thread.sleep(2000);}catch(InterruptedException e) {}
	}

	@Then("Succesfully navigate to home page")
	public void succesfully_navigate_to_home_page() {

		homePage.homePageValidation();

	}


	@Then("shut down the Browser")
	public void shut_down_the_browser() {
	}

}
