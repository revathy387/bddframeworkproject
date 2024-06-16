package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"features\\DemoBlazeSignup.feature"},
glue = {"step.definition", "Hooks"},
plugin = {"html:htmlreport/cucumber-test-report.html","json:target/cucumber-report.json","pretty"})
public class SignUpValidation extends AbstractTestNGCucumberTests {

}
