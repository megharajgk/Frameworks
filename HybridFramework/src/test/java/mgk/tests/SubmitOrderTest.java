package mgk.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import mgk.testComponents.BaseTest;
import pageObjects.ProductCatalogue;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.OrderPage;

public class SubmitOrderTest extends BaseTest{

	String productName="IPHONE 13 PRO";
	
	@Test(dataProvider = "getData", groups = {"Purchase"})
	public void submitOrder(String email, String password, String prodName)
	{ 
		String countryName="ind";
		try
		{
			ProductCatalogue pc=land.loginApp(email, password);
			pc.getProductList();
			pc.addProductToCart(prodName);
			CartPage cartPage=pc.goToCartPage();
			Boolean match=cartPage.verifyProductDisplay(prodName);
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
		return new Object[][] {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"},{"shetty@gmail.com","Iamking@000","IPHONE 13 PRO"}};
	}

	

}
