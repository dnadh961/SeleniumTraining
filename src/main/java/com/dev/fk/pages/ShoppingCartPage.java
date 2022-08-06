package com.dev.fk.pages;

import org.openqa.selenium.By;

import com.dev.ap.SUT;

public class ShoppingCartPage extends BasePage{
	
	private static final String PRODUCT_COUNT_CSS = "input[value='1']";

	public ShoppingCartPage(SUT testEnv) {
		super(testEnv);
	}

	public boolean isProductAdded() {
		testEnv.handleWaits().waitForElementPresence(By.xpath("//span[text()='Place Order']"));
		return verifyElement(By.cssSelector(PRODUCT_COUNT_CSS));
	}
}
