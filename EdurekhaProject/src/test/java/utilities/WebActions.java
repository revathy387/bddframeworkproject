package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import step.definition.Hooks;

public class WebActions {
	
	RemoteWebDriver driver = Hooks.getdriver();
	
	public static void openbrowser(RemoteWebDriver driver) {
		//BrowserUtil.getDriver("chrome");
	}
	
	public static void openurl(RemoteWebDriver driver, String url) {
		driver.get(url);
		Reporter.log("Launching the webpage" + url);
	}
	
	public static void settext(RemoteWebDriver driver, By locator, String data){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		//Thread.sleep(5000);
		driver.findElement(locator).sendKeys(data);
		Reporter.log("Enter the details" + locator + data);
	}
	
	public static void clickbutton(By driver, SearchContext locator) {
		
		driver.findElement(locator).click();
		Reporter.log("Click the login button" + locator );
	}
	
	

}
