package utils;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileReader;
import java.time.Duration;
import java.util.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver=null;
	public WebDriver webDriverManager() throws Exception
	{
		FileReader fr=new FileReader(".\\src\\test\\resources\\global.properties");
		
		Properties prop=new Properties();
		prop.load(fr);
		
		String url=prop.getProperty("URL");
		
		
		if(driver==null)
		{
			if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(url);
			
		} 
		return driver;
	}
}
