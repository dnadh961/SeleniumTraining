package com.dev.ap;

import org.openqa.selenium.WebDriver;

import com.dev.fk.pages.HomePage;

public class Browser {

	private SUT testEnv = null;
	private WebDriver driver = null;
	private Configuration config = null;
	
	public Browser(SUT testEnv) {
		this.testEnv = testEnv;
		this.driver = testEnv.getDriver();
		this.config = testEnv.getConfiguration();
	}

	public HomePage open() {
		open(config.getInstanceURL());
		return new HomePage(testEnv);
	}

	public void close() {
		driver.close();
	}

	public void open(String url) {
		driver.get(url);
	}
	
}
