package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	public WebDriver driver;
	
	By search=By.xpath("//input[@type='search']");
	By prodName=By.cssSelector("h4.product-name");
	By topDeals=By.xpath("//a[text()='Top Deals']");
	
	By addItem=By.xpath("//a[@class='increment']");
	By addToCart=By.xpath("//button[text()='ADD TO CART']");
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name); 
	}
	
	public void getSearchText()
	{
		driver.findElement(search).getText();
	}
	

	public void incrementQuantity(int quantity) 
	{
		int i=quantity-1;
		while(i>0)
		{
			driver.findElement(addItem).click();
			i--;
		}
	}
	
	public void addToCart() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(addToCart).click();
		
		Thread.sleep(2000);
	}
	
	public String getProdName()
	{
		return driver.findElement(prodName).getText();
	}
	
	public void selectTopDealsPage()
	{
		driver.findElement(topDeals).click();
	}
	
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}
}
