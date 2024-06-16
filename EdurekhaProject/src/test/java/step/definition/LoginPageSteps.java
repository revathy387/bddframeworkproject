package step.definition;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DemoBlazeLoginPage;
import pages.DemoBlazeLogoutPage;
import utilities.BrowserUtil;
import utilities.ExcelUtility;

public class LoginPageSteps {
	
	RemoteWebDriver driver = Hooks.getdriver();
	DemoBlazeLoginPage loginpage;
	DemoBlazeLogoutPage logoutpage;
	Object[][] testdata = null;
	
	
	@Given("User launches the web page")
	public void user_launches_the_web_page() {
	    
		loginpage = new DemoBlazeLoginPage(driver);
		logoutpage = new DemoBlazeLogoutPage(driver);
	}

	@When("User logins to the application")
	public void user_logins_to_the_application(){
		
		driver.get("https://www.demoblaze.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		loginpage.clickloginlink();
		try {
			testdata = ExcelUtility.readFromFile("testdata/Assignment10.xlsx", "LoginData");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@When("User enters valid login data")
	public void user_enters_valid_login_data(){
		
		
			
			String name = testdata[0][0].toString();
			String key = testdata[0][1].toString();
			try{Thread.sleep(2000);}catch(InterruptedException e) {}
			loginpage.enterusername(name);
			loginpage.enterpassword(key);
			loginpage.clickloginbutton();
		
	}
	
	@When("User enter invalid login data")
	public void user_enter_invalid_login_data(){
		
		String name = testdata[1][0].toString();
		String key = testdata[1][1].toString();
		try{Thread.sleep(2000);}catch(InterruptedException e) {}
		loginpage.enterusername(name);
		loginpage.enterpassword(key);
		loginpage.clickloginbutton();
		
	}
	
	

	/*
	 * @When("User enter username as {string} and password as {string}") public void
	 * user_enter_username_as_and_password_as(String string, String string2) throws
	 * InterruptedException, IOException { //DemoBlazeLoginPage obj = new
	 * DemoBlazeLoginPage(driver); Object[][] testdata = null; testdata =
	 * ExcelUtility.readFromFile("testdata/Assignment10.xlsx", "LoginData"); for(int
	 * i=0; i<testdata.length;i++) {
	 * driver.navigate().to("https://www.demoblaze.com/index.html");
	 * loginpage.clickloginlink(); String name = testdata[i][0].toString(); String
	 * key = testdata[i][1].toString(); Thread.sleep(2000);
	 * loginpage.enterusername(name); loginpage.enterpassword(key);
	 * loginpage.clickloginbutton(); }
	 * 
	 * }
	 */

	@Then("Successfull login")
	public void successfull_login() {
		
		logoutpage.successfullLoginValidation();
	    
	}

	@Then("Alert is displayed")
	public void alert_is_displayed() {
	    
		loginpage.InvalidLogin();
	}
	
}
