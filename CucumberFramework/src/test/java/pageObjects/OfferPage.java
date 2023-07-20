package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {

	public WebDriver driver;
	
	By search=By.id("search-field");
	By prodName=By.xpath("//tbody/tr/td[1]");

	
	public OfferPage(WebDriver driver)
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
	
	public String getProdName()
	{
		return driver.findElement(prodName).getText();
	}
	 
}
