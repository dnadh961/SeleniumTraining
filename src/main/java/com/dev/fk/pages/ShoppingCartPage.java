package com.dev.fk.pages;

import org.openqa.selenium.By;

import com.dev.ap.SUT;

public class ShoppingCartPage extends BasePage{

	public ShoppingCartPage(SUT testEnv) {
		super(testEnv);
	}

	public boolean checkProductCount(int count) {
		testEnv.handleWaits().waitForElementPresence(By.xpath("//span[text()='Place Order']"));
		return verifyElement(By.cssSelector("input[value='" + count + "']"));
	}
}
