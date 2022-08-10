package com.dev.fk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.dev.ap.SUT;

public class HomePage extends BasePage {
	
	private static final String SEARCH_FIELD_NAME = "q";
	private static final String CLOSE_BUTTON_XPATH = "//button[text()='✕']";

	public HomePage(SUT testEnv) {
		super(testEnv);
		findElement(By.xpath(CLOSE_BUTTON_XPATH)).click();
	}

	public SearchResultsPage search(String searchString) {
		findElement(By.name(SEARCH_FIELD_NAME)).sendKeys(searchString + Keys.ENTER);
		return new SearchResultsPage(testEnv);
	}
}
