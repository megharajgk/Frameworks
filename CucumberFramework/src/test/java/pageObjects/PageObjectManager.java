package pageObjects;

// this class is called as Factory class

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public WebDriver driver;
	public LandingPage land;
	public OfferPage offer;
	public CheckoutPage check;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public LandingPage getLandingPage()
	{
		land=new LandingPage(driver);
		return land;
	}
	
	public OfferPage getOfferPage()
	{
		offer=new OfferPage(driver);
		return offer;
	}
	
	public CheckoutPage getCheckOutPage()
	{
		check=new CheckoutPage(driver);
		return check;
	}
	
}
