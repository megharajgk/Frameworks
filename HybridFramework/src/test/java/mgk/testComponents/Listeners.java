package mgk.testComponents;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener{

	ExtentReports extent= ExtentReportNG.getReportObject();
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		test=extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS, "Test Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		
		String filePath=null; 
		try
		{
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());

			test.log(Status.FAIL, "Test Failed");
			test.fail(result.getThrowable());
			
			filePath=getScreenshot(result.getMethod().getMethodName(),driver); 
			test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
			
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}

	@Override
	public void onStart(ITestContext context) 
	{
		
	}

}
