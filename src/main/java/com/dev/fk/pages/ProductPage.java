package com.dev.fk.pages;

import org.openqa.selenium.By;

import com.dev.ap.SUT;

public class ProductPage extends BasePage{
	
	private static final String ADD_TO_CART_XPATH = "//button[text()='Add to Cart']";

	public ProductPage(SUT testEnv) {
		super(testEnv);
	}
	
	public ShoppingCartPage addToCart() {
		findElement(By.xpath(ADD_TO_CART_XPATH)).click();
		return new ShoppingCartPage(testEnv);
	}

}
