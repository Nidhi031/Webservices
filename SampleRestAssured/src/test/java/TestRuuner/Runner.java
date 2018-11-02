package TestRuuner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Feature Files/hcsc.feature",glue = {"stepDefinitions"}
		,plugin= {"pretty","json:target/Cucumber-report/cucumber.json"}
		
		)

public class Runner{

}
