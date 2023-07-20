package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pageObjects.CheckoutPage;
import utils.TestContextSetUp;

public class CheckoutPageSteps {

	public CheckoutPage checkOutPage;
	public TestContextSetUp setUp;

	public CheckoutPageSteps(TestContextSetUp setUp) {
		this.setUp = setUp;
		this.checkOutPage = setUp.pageManager.getCheckOutPage();
	}

	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_tom_items_in_checkout_page(String name) throws InterruptedException {
		checkOutPage.checkOutItem();
		Thread.sleep(2000);
	}

	@Then("User has ability to enter promo code and place the order")
	public void user_has_ability_to_enter_promo_code_and_place_the_order() {

		Assert.assertTrue(checkOutPage.verifyPromoBtn());
		Assert.assertTrue(checkOutPage.verifyPlaceOrder());

	}

}
