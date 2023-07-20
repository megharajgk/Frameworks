package stepDefinitions;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetUp;

public class Hooks {

	TestContextSetUp setUp;

	public Hooks(TestContextSetUp setUp)
	{
		this.setUp=setUp;
	}
	
	@After
	public void afterEveryScenario() throws Exception
	{
		setUp.testBase.webDriverManager().quit();
	}
	
	@AfterStep
	public void addScreenShot(Scenario scn) throws Exception
	{
		WebDriver driver=setUp.testBase.webDriverManager();
		if(scn.isFailed())
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent=FileUtils.readFileToByteArray(src);
			scn.attach(fileContent, "image/png", "image");
		}
	}
}
 