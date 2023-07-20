package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import utils.TestContextSetUp;


public class OfferPageSteps {


TestContextSetUp setUp;

public OfferPageSteps(TestContextSetUp setUp)
{
	this.setUp=setUp;
}

	@Then("^User searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException 
	{
		switchToOfferPage();
		OfferPage offer=setUp.pageManager.getOfferPage();
	
		offer.searchItem(shortName);
		
		setUp.prodNameOffer=offer.getProdName();
		System.out.println(setUp.prodNameOffer+" : In Offer page");
	}

	public void switchToOfferPage()
	{
		LandingPage land=setUp.pageManager.getLandingPage();	
		land.selectTopDealsPage();
		setUp.gen.switchWindowToChild();
	}
	
	@Then("Validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() throws InterruptedException 
	{
		Assert.assertEquals(setUp.prodNameHome, setUp.prodNameOffer);
		if(setUp.prodNameHome.equalsIgnoreCase(setUp.prodNameOffer))
		{
			System.out.println("User searched shortname is same as both in home and offer page.");
			Thread.sleep(2000);
		}
		else
		{
			System.out.println("User searched shortname is not same as both in home and offer page.");
		}
	}
}
