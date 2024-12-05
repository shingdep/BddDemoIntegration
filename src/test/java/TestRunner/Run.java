package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = ".//Feature/Login.feature",
		glue="StepDef",
		dryRun = false,
		monochrome = true,
		//plugin= {"pretty","html:target/cucumber-reports1.html"}
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	
		)
public class Run 
{
         
}
