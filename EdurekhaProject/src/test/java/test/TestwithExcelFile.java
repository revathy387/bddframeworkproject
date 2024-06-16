package test;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import pages.DemoBlazeLoginPage;
import utilities.BrowserUtil;
import utilities.ExcelUtility;

public class TestwithExcelFile {
	
	RemoteWebDriver driver = BrowserUtil.getDriver("chrome");

	@Test
	public void test() throws IOException {
		DemoBlazeLoginPage obj = new DemoBlazeLoginPage(driver);
		Object[][] testdata = null;
		testdata = ExcelUtility.readFromFile("testdata/Assignment10.xlsx", "LoginData");
		for(int i=0; i<testdata.length;i++) {
			driver.navigate().to("https://www.demoblaze.com/index.html");
			obj.clickloginlink();
			obj.login(testdata[i][0].toString(), testdata[i][1].toString());
		}
	}
}
