package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "@.\\Failed\\failed_scenario.txt",
		glue = "stepDefinitions",
		dryRun = false,
		monochrome = true,
		plugin = {"html:./Reports/HtmlReports/report1.html", 
				"json:./Reports/JsonReports/report2.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}
		)
public class FailedTestRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
}
