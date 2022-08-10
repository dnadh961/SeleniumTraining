package com.dev.fk;

import org.testng.Assert;

import com.dev.ap.Browser;
import com.dev.ap.SUT;
import com.dev.fk.pages.HomePage;
import com.dev.fk.pages.ProductPage;
import com.dev.fk.pages.SearchResultsPage;
import com.dev.fk.pages.ShoppingCartPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepdef {
	
	private SUT testEnv = null;
	private Browser browser = null;
	private HomePage homePage = null;
	private SearchResultsPage resultsPage = null;
	private ProductPage productPage = null;
	private ShoppingCartPage cartPage = null;

	@Given("user opens Flipkart home page")
	public void user_opens_flipkart_home_page() {
		testEnv = new SUT();
		browser = testEnv.getBrowser();
		homePage = browser.open();
	}

	@When("user searches for the {string}")
	public void user_searches_for_the(String searchString) {
		resultsPage = homePage.search(searchString);
	}

	@When("user clicks on the first search result in the results page")
	public void user_clicks_on_the_first_search_result_in_the_results_page() {
		productPage = resultsPage.clickFirstResult();
	}

	@When("user switches to the next tab and clicks on Add to Cart button")
	public void user_switches_to_the_next_tab_and_clicks_on_button() {
		cartPage = productPage.addToCart();
	}

	@Then("item count should be equal to {int} in the Place Order page")
	public void item_count_should_be_equal_to_in_the_place_order_page(Integer count) {
		Assert.assertTrue(cartPage.checkProductCount(count));
	}
}
