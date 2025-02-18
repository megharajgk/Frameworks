package resources;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	public static ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir")+"\\Reports\\TestReport.html";
		ExtentSparkReporter repoter=new ExtentSparkReporter(path);
		repoter.config().setReportName("Web Automation Result");
		repoter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(repoter);
		extent.setSystemInfo("MGK", "Tester");
		extent.flush();
		return extent;
	}
}
