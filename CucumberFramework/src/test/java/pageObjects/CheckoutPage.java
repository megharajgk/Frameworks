package pageObjects;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	public WebDriver driver;
	
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By cartBag=By.xpath(" //img[@alt='Cart']");
	By proceed=By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	By promoBtn=By.cssSelector(".promoBtn");
	By placeOrder=By.xpath("//button[text()='Place Order']");
	
	
	public void checkOutItem()
	{
		driver.findElement(cartBag).click();
		driver.findElement(proceed).click();
	}
	
	public Boolean verifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public Boolean verifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
	
	
	
}
