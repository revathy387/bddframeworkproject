package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import test.LoggerExampleUsingLog4J;
import utilities.BrowserUtil;

public class DemoBlazeHomePage {
	
	RemoteWebDriver driver;
	Logger log;
	
	public DemoBlazeHomePage(RemoteWebDriver driver) {
		
		this.driver = driver;
	}
	
	By productstore = By.xpath("//a[@id='nava']");
	By loginlink = By.xpath("//a[@id='login2']");
	
		
	public void homePageValidation() {
		
		String message = driver.findElement(productstore).getText();
		log = LoggerExampleUsingLog4J.getLogger("DemoBlazeHomePageclassandhomePageValidation()");
		log.debug(message);
		Boolean flag = driver.findElement(loginlink).isDisplayed();
		log.debug(flag);
		if(message.equalsIgnoreCase("PRODUCT STORE") && flag ) {
			System.out.println("*******************************"); 
			System.out.println("Welcome to DemoBlaze Home Page");
			System.out.println("*******************************"); 
		}
		
	}

	public static void main(String args[]) {
		
		RemoteWebDriver driver = BrowserUtil.getDriver("chrome");
		DemoBlazeHomePage obj = new DemoBlazeHomePage(driver);
		driver.get("https://www.demoblaze.com/");
		obj.homePageValidation();
		
	}
}
