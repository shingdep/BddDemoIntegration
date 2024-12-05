package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features=".//Feature/DDT.feature",
		glue="StepDef",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","html:target/cucmberRun/Report1.html"}
		
		
		
		)


public class Run1 
{

}
