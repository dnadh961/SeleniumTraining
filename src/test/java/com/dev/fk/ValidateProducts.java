package com.dev.fk;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dev.ap.Browser;
import com.dev.ap.SUT;
import com.dev.fk.pages.HomePage;
import com.dev.fk.pages.ProductPage;
import com.dev.fk.pages.SearchResultsPage;
import com.dev.fk.pages.ShoppingCartPage;

public class ValidateProducts {
	
	private HomePage homePage = null;

	@BeforeMethod
	public void setup() {
		SUT testEnv = new SUT();
		Browser browser = testEnv.getBrowser();
		homePage = browser.open();
	}
	
	@Test
	public void testAddToCart() {
		SearchResultsPage resultsPage = homePage.search("tv smart tv");
		ProductPage productPage = resultsPage.clickFirstResult();
		ShoppingCartPage cartPage = productPage.addToCart();
		Assert.assertTrue(cartPage.isProductAdded());
	}
}
