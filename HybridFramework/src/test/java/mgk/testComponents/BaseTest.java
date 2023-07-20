package mgk.testComponents;

import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage land;
	
	public WebDriver initializeDriver() throws Exception
	{
		Properties prop=new Properties();
		FileReader fr=new FileReader(".\\src\\main\\java\\resources\\globalData.properties");
		prop.load(fr);
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApp() throws Exception
	{
		driver=initializeDriver();
		
		land=new LandingPage(driver);
		land.goToUrl();
		
		return land;
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driver.close();
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws Exception
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File scr=ts.getScreenshotAs(OutputType.FILE);
		String filePath=".//Reports//"+testCaseName+".png";
		File dst=new File(filePath);
		FileUtils.copyFile(scr, dst);
		return filePath;
	}
}
