package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {

	public WebDriver driver=null;
	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void switchWindowToChild()
	{
		Set<String> window=driver.getWindowHandles();
		Iterator<String> ite= window.iterator();
		String parent=ite.next();
		String child=ite.next();
		
		driver.switchTo().window(child);
	}
}
