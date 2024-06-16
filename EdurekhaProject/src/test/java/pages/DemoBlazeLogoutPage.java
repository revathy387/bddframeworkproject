package pages;



import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.LoggerExampleUsingLog4J;

public class DemoBlazeLogoutPage {
	
	RemoteWebDriver driver;
	 Logger log;
	
	public DemoBlazeLogoutPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	By linklogout = By.id("logout2");
	By nameOfUser = By.xpath("//a[@id='nameofuser']");
	
	public void clicklogout() {
		
		log = LoggerExampleUsingLog4J.getLogger("DemoBlazeLogoutPageclassandclicklogout()");
		log.debug(linklogout);
		driver.findElement(linklogout).click();
		
	}
	
	public boolean islogoutdisplayed() {
		
		log = LoggerExampleUsingLog4J.getLogger("DemoBlazeLogoutPageclassandislogoutdisplayed()");
		log.debug(linklogout);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(linklogout));
		return driver.findElement(linklogout).isDisplayed();
		
	}
	
	public void successfullLoginValidation() {
		
		if(islogoutdisplayed()) {
			log = LoggerExampleUsingLog4J.getLogger("DemoBlazeLogoutPageclassandsuccessfullLoginValidation()");
			log.debug(nameOfUser);
			System.out.println(driver.findElement(nameOfUser).getText());
		}else {
			
		}
	}

}
