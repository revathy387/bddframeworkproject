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

public class DemoBlazeLoginPage {

	RemoteWebDriver driver;
	Logger log;

	public DemoBlazeLoginPage(RemoteWebDriver driver) {

		this.driver = driver;
	}

	By loginlink = By.xpath("//a[@id='login2']");
	By username = By.id("loginusername");
	By password = By.id("loginpassword");
	By loginbutton = By.xpath("//button[text()='Log in']");

	public void clickloginlink() {

		log = LoggerExampleUsingLog4J.getLogger("DemoBlazeLoginPageclassandclickloginlink()");
		log.debug(loginlink);
		driver.findElement(loginlink).click();

	}


	public void enterusername(String name) {

		log = LoggerExampleUsingLog4J.getLogger("DemoBlazeLoginPageclassandenterusername(String name)");
		log.debug(name);
		driver.findElement(username).sendKeys(name);

	}

	public void enterpassword(String key) {

		log = LoggerExampleUsingLog4J.getLogger("DemoBlazeLoginPageclassandenterpassword(String key)");
		log.debug(key);
		driver.findElement(password).sendKeys(key);

	}

	public void clickloginbutton() {

		log = LoggerExampleUsingLog4J.getLogger("DemoBlazeLoginPageclassandclickloginbutton()");
		log.debug(loginbutton);
		driver.findElement(loginbutton).click();

	}


	public void login(String name, String key) {

		driver.findElement(username).sendKeys(name);
		driver.findElement(password).sendKeys(key);
		driver.findElement(loginbutton).click();
	}
	
	public void InvalidLogin() {
		
		try {
         
            // Wait for the alert to be present
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.alertIsPresent());

            // Switch to the alert and accept it
            Alert alert = driver.switchTo().alert();
			String message = alert.getText();
			if(message.equalsIgnoreCase("User does not exist.")) {
				alert.accept();
			}
        } catch (Exception e) {
            log.error("Alert not found" + e);
        }
	}

	public static void main(String args[]) throws InterruptedException {

		RemoteWebDriver driver = BrowserUtil.getDriver("chrome");
		DemoBlazeLoginPage obj = new DemoBlazeLoginPage(driver);
		driver.get("https://www.demoblaze.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		obj.clickloginlink();

		//successfull Login validation
		obj.login("Aditi2013", "ABC123");
		DemoBlazeLogoutPage obj1 = new DemoBlazeLogoutPage(driver);
		obj1.successfullLoginValidation();

		//invalid login validation
		
			driver.navigate().to("https://www.demoblaze.com/");
			obj.clickloginlink();
			obj.enterusername("Anjana2019"); obj.enterpassword("XYZ456");
			obj.clickloginbutton();
			Thread.sleep(2000);
			obj.InvalidLogin();
	
	}

}
