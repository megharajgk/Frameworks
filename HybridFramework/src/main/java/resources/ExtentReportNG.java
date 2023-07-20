package resources;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	public static ExtentReports getReportObject()
	{
		ExtentSparkReporter repoter=new ExtentSparkReporter(".//Reports//index.html");
		repoter.config().setReportName("Web Automation Result");
		repoter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(repoter);
		extent.setSystemInfo("Tester", "MGK");
		return extent;
	}
}
