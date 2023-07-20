package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features = ".\\src\\test\\java\\features",
				glue = "stepDefinitions",
				dryRun = false,
				monochrome = false,
				stepNotifications = true,
				plugin = {"html:./Reports/report.html",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"rerun:Failed/failed_scenario.txt"}
				)
public class JunitTestRunner {
}
