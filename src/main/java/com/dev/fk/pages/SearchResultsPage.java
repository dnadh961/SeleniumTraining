package com.dev.fk.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import com.dev.ap.SUT;

public class SearchResultsPage extends BasePage {
	
	private static final String FIRST_RESULT_CSS = "div[data-id] a";

	public SearchResultsPage(SUT testEnv) {
		super(testEnv);
	}
	
	public ProductPage clickFirstResult() {
		findElement(By.cssSelector(FIRST_RESULT_CSS)).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandleList = new ArrayList<>(windowHandles);
		String secondWinHandle = windowHandleList.get(1);
		driver.switchTo().window(secondWinHandle);
		return new ProductPage(testEnv);
	}

}
