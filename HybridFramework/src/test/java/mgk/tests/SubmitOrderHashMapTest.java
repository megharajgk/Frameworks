package mgk.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mgk.testComponents.BaseTest;
import pageObjects.ProductCatalogue;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.OrderPage;

public class SubmitOrderHashMapTest extends BaseTest{

	String productName="IPHONE 13 PRO";
	
	@Test(dataProvider = "getData", groups = {"Purchase"})
	public void submitOrder(HashMap<String, String> input)
	{ 
		String countryName="ind";
		try
		{
			ProductCatalogue pc=land.loginApp(input.get("email"), input.get("password"));
			pc.getProductList();
			pc.addProductToCart(input.get("prodName"));
			CartPage cartPage=pc.goToCartPage();
			Boolean match=cartPage.verifyProductDisplay(input.get("prodName"));
			Assert.assertTrue(match);
			CheckoutPage cop=cartPage.goToCheckout();
			cop.typeCountry(countryName);
			cop.clickOnCountry();
			ConfirmationPage confirmPage=cop.placeOrderButton();
			String confirmMessege=confirmPage.verifyConfirmationMessage();
			Assert.assertTrue(confirmMessege.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest()
	{
		// To verify the ordered product is displaying in Orders page
		ProductCatalogue pc=land.loginApp("anshika@gmail.com", "Iamking@000");
		OrderPage op=pc.goToOrdersPage();
		Assert.assertTrue(op.verifyOrderDisplay(productName));
	}
	
	@DataProvider
	public Object[][] getData()
	{
		HashMap<String, String> hm1=new HashMap<String, String>();
		hm1.put("email", "anshika@gmail.com");
		hm1.put("password", "Iamking@000");
		hm1.put("prodName", "ZARA COAT 3");
		
		HashMap<String, String> hm2=new HashMap<String, String>();
		hm2.put("email", "shetty@gmail.com");
		hm2.put("password", "Iamking@000");
		hm2.put("prodName", "IPHONE 13 PRO");
		return new Object[][] {{hm1},{hm2}};
		
	}

}
