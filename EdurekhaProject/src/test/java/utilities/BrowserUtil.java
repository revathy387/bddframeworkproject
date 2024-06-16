package utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import test.LoggerExampleUsingLog4J;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BrowserUtil {
	
	public static void quitDriver(RemoteWebDriver driver) {
		driver.quit();
	}
	
	public static RemoteWebDriver getDriver(String browser) {
		
		/*
		 * String browser=System.getProperty("browser");
		 * System.out.println("Browser value:="+browser); if(browser==null) { Logger
		 * logger= LoggerExampleUsingLog4J.getLogger("BrowserUtil.getDriver()"); logger.
		 * debug("Browser value is null. Hence launching chrome as default browser");
		 * browser="firefox"; }
		 */
		
		RemoteWebDriver driver;
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

}

