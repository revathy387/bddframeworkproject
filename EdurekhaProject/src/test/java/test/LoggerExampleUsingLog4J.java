package test;



import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoggerExampleUsingLog4J {
	
	public static Logger getLogger(String classnameandmethod) {
		Logger log = Logger.getLogger(classnameandmethod);
		
		//BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties");
		return log;
		
	}

	
	public static void main(String args[]) {
		
		Logger log =LoggerExampleUsingLog4J.getLogger("LoggerExampleUsingLog4Jandmain()");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		log.info("launching google website");
		
		driver.quit();
		log.info("closing browser");
	}

}
