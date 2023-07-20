package mgk.tests;

import org.testng.Assert; 
import org.testng.annotations.Test;

import mgk.testComponents.BaseTest;
import pageObjects.CartPage;
import pageObjects.ProductCatalogue;

public class ErrorValidationTest extends BaseTest{

	@Test(groups = {"ErrorHandling"})
	public void loginErrorValidation() throws Exception
	{
		
		
		land.loginApp("anshik@gmail.com", "Iamking@00");
		Assert.assertEquals("Incorrect email password.", land.getErrorMessage());
	}
	
	@Test
	public void prodErrorValidation()
	{
		String productName="IPHONE 13 PRO";
		try
		{
			ProductCatalogue pc=land.loginApp("anshika@gmail.com", "Iamking@000");
			pc.getProductList();
			pc.addProductToCart(productName);
			CartPage cartPage=pc.goToCartPage();
			Boolean match=cartPage.verifyProductDisplay(productName+" PLUS");
			Assert.assertFalse(match);
			
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
