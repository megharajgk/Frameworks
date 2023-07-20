package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponentStuffs;

public class CheckoutPage extends AbstractComponentStuffs {

	public WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

//	driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");\
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement selectCountry;
	
	public void typeCountry(String country)
	{
		selectCountry.sendKeys(country);
	}
	
//	List<WebElement> countries=driver.findElements(By.cssSelector("button .ng-star-inserted"));
	@FindBy(css = "button .ng-star-inserted")
	List<WebElement> countries;
	
	public void clickOnCountry()
	{
		for(WebElement country:countries)
		{	
			if(country.getText().equalsIgnoreCase("india"))
			{
				country.click();
				break;
			}
		}
	}
	
//	driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
	@FindBy(xpath = "//a[text()='Place Order ']")
	WebElement placeOrder;
	
	public ConfirmationPage placeOrderButton()
	{
		placeOrder.click();
		return new ConfirmationPage(driver);
	}
	
	
}
