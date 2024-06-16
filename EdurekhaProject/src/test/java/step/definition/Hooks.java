package step.definition;

import java.net.MalformedURLException;
import java.net.URI;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;

public class Hooks {

	private static RemoteWebDriver driver;
	
	@Before
	public void setup() throws MalformedURLException {

		DesiredCapabilities obj = new DesiredCapabilities();
		obj.setBrowserName("firefox");
		obj.setCapability("platformName", "Windows 11");
		driver = new RemoteWebDriver(URI.create("http://192.168.1.3:4444").toURL(), obj);
	}

		@After
		public void teardown() {
			driver.quit();
		}

		public static RemoteWebDriver getdriver() {

			return driver;
		}
	}
