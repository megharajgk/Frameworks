package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponentStuffs;

public class ConfirmationPage extends AbstractComponentStuffs {

	public WebDriver driver;
	public ConfirmationPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

//	String confirmMessege=driver.findElement(By.cssSelector(".hero-primary")).getText();
	@FindBy(css = ".hero-primary")
	WebElement confirmationMessage;
	
	public String verifyConfirmationMessage()
	{
		return confirmationMessage.getText();
	}
}
