package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractComponent.AbstractComponentStuffs;

public class ProductCatalogue extends AbstractComponentStuffs {

	public WebDriver driver=null;
	
	public ProductCatalogue(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	List<WebElement> elements=driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> prodcuts;
	
//	driver.findElement(By.cssSelector(".ng-animating"));
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productBy);
		return prodcuts;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod=getProductList().stream().filter(element->element.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws Exception
	{
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}
	
}
