package pageObjects;

import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponentStuffs;

public class LandingPage extends AbstractComponentStuffs {

	public WebDriver driver=null;
	
	public LandingPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	driver.findElement(By.cssSelector("#userEmail")).sendKeys("anshika@gmail.com");
	@FindBy(id="userEmail")
	WebElement userEmail;
	
//	driver.findElement(By.cssSelector("#userPassword")).sendKeys("Iamking@000");
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
//	driver.findElement(By.cssSelector("#login")).click();
	@FindBy(id="login")
	WebElement submit;
	
	public ProductCatalogue loginApp(String email, String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue prodCat=new ProductCatalogue(driver);
		return prodCat;
	}
	
	public void goToUrl()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;
	
	public String getErrorMessage() throws Exception
	{
		waitForElementToAppear(errorMessage);
		return errorMessage.getText();
	}
}
