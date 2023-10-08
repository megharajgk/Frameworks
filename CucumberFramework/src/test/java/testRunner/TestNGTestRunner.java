 package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".\\src\\test\\java\\features",
		glue = "stepDefinitions",
		dryRun = false,
		monochrome = true,
		tags = "@PlaceOrder or @OfferPage",
		plugin = {"html:./Reports/HtmlReports/report1.html", 
				"json:./Reports/JsonReports/report2.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:Failed/failed_scenario.txt"}
		)
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
}
