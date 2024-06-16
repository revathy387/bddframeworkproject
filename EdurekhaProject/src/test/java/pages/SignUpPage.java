package pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.LoggerExampleUsingLog4J;
import utilities.BrowserUtil;
import utilities.WebActions;

public class SignUpPage {

	RemoteWebDriver driver;
	Logger log;
	
	public SignUpPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	By signInLink = By.xpath("//a[@id='signin2']");
	By inputusername = By.id("sign-username");
	By inputpassword = By.id("sign-password");
	By signUpButton = By.xpath("//button[text()='Sign up']");

	public void clickSignUpLink() {

		WebActions.clickbutton(signInLink, driver);
		//driver.findElement(signInLink).click();
		log = LoggerExampleUsingLog4J.getLogger("SignUpPageclassandclickSignUpLink()");
		log.debug(signInLink);

	}

	public void register(){
		
		WebActions.settext(driver, inputusername, "testusr3");
		//driver.findElement(inputusername).sendKeys("revathyedureka1");
		WebActions.settext(driver, inputpassword, "password1");
		//driver.findElement(inputpassword).sendKeys("password1");
		WebActions.clickbutton(signUpButton, driver);
		//driver.findElement(signUpButton).click();
		log = LoggerExampleUsingLog4J.getLogger("SignUpPageclassandregister()");
		log.debug(inputusername);
		log.info(inputpassword);
		log.fatal(signUpButton);

	}

	public void registration_success() {

		try {

			// Wait for the alert to be present
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.alertIsPresent());

			// Switch to the alert and accept it
			Alert alert = driver.switchTo().alert();
			String message = alert.getText();
			Thread.sleep(2000);
			if (message.equalsIgnoreCase("Sign up successful.")) {
				alert.accept();
			}
		} catch (Exception e) {
			log.error("Alert not found" + e);
		}

	}
	
	public static void main(String args[]){
		
		RemoteWebDriver driver = BrowserUtil.getDriver("chrome");
		SignUpPage obj = new SignUpPage(driver);
		driver.get("https://www.demoblaze.com/");
		obj.clickSignUpLink();
		obj.register();
		obj.registration_success();
	}
}
