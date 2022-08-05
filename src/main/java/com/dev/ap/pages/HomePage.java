package com.dev.ap.pages;

import org.openqa.selenium.By;

import com.dev.ap.SUT;

public class HomePage extends BasePage{

	public HomePage(SUT testEnv) {
		super(testEnv);
	}
	
	private static final String signIn_linkText = "Sign in";
	
	
	public AuthenticationPage signIn(){
		click(By.linkText(signIn_linkText));
		return new AuthenticationPage(testEnv);
	}

}
