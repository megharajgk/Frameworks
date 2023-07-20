package abstractComponent;

import java.time.Duration; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.CartPage;
import pageObjects.OrderPage;

public class AbstractComponentStuffs {

	public WebDriver driver;
	public AbstractComponentStuffs(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	driver.findElement(By.xpath("//button[contains(@routerlink,'cart')]")).click();
	@FindBy(xpath = "//button[contains(@routerlink,'cart')]")
	WebElement cartHeader;
	
	@FindBy(xpath = "//button[contains(@routerlink,'myorders')]")
	WebElement orderHeader;

	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToDisappear(WebElement ele) throws Exception
	{
		// Here, we are not using WebDriverWait just because website is having some issue
		Thread.sleep(2000);
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void waitForElementToAppear(WebElement ele) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cartPage=new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrdersPage()
	{
		orderHeader.click();
		OrderPage orderPage=new OrderPage(driver);
		return orderPage;
	}
}
