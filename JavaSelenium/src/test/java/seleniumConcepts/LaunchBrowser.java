package seleniumConcepts;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public WebDriver driver=null;
	
	@Test
	public void launch()
	{
		Properties prop;
		FileReader fr;
		try
		{
			prop=new Properties();
			fr=new FileReader(".\\Resources\\browser.properties");
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
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
