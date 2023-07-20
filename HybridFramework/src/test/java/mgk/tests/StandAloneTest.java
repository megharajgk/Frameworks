package mgk.tests;

import java.time.Duration; 
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static WebDriver driver=null;
	public static void main(String[] args) throws Exception
	{
		String productName="IPHONE 13 PRO";
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("anshika@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Iamking@000");
		driver.findElement(By.cssSelector("#login")).click();
		
		// Using Java-Stream concept
		
//		List<WebElement> elements=driver.findElements(By.cssSelector(".mb-3"));
//		WebElement ele=elements.stream().filter(element->element.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("iphone 13 pro")).findFirst().orElse(null);
//		ele.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> elements=driver.findElements(By.cssSelector(".mb-3"));
		
		for(WebElement element:elements)
		{
			WebElement ele= element.findElement(By.cssSelector("b"));
			
			if(ele.getText().equalsIgnoreCase(productName))
			{
				element.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			}
		}
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(@routerlink,'cart')]")).click();
		
		List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		
		List<WebElement> countries=driver.findElements(By.cssSelector("button .ng-star-inserted"));
		for(WebElement country:countries)
		{	
			if(country.getText().equalsIgnoreCase("india"))
			{
				country.click();
				break;
			}
		}
		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
		
		String confirmMessege=driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		Assert.assertTrue(confirmMessege.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
		
	}

}
