package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"features\\DemoBlazeLoginModule.feature"},
glue = {"step.definition", "Hooks"},
plugin = {"html:htmlreport/cucumber-test-report.html","json:target/cucumber-report.json","pretty"})
public class LoginValidation extends AbstractTestNGCucumberTests {

}
