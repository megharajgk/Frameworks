package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.LandingPage;
import utils.TestContextSetUp;

public class LandingPageSteps {
	
String prodNameOffer=null;
public TestContextSetUp setUp;
public LandingPage land;

public LandingPageSteps(TestContextSetUp setUp)
{
	this.setUp=setUp;
	this.land=setUp.pageManager.getLandingPage();
}

	@Given("User is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() 
	{
		Assert.assertTrue(land.getTitleLandingPage().contains("GreenKart"));
	}

	@When("^User searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException 
	{
		
		land.searchItem(shortName); 
		Thread.sleep(2000);
		setUp.prodNameHome=land.getProdName().split("-")[0].trim();
		System.out.println(setUp.prodNameHome+" : In Home page");
	}
	
	@When("Added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(String quantity) throws InterruptedException 
	{
		land.incrementQuantity(Integer.parseInt(quantity));
		land.addToCart();
	}
	
}
