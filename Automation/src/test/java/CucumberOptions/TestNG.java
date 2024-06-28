package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/Features",
		glue="StepDef",
		monochrome=true,
		//dryRun=true
		tags="@search"
		//plugin= {"pretty","html:target/login.html","json:target/login.json"}
		
		)

public class TestNG extends AbstractTestNGCucumberTests{

}
