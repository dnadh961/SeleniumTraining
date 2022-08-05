package com.dev.ap.pages;

import org.openqa.selenium.By;

import com.dev.ap.SUT;

public class AuthenticationPage extends BasePage {

	private static final String emailAddress_id = "email_create";
	private static final String createAccount_btn_name = "SubmitCreate";

	public AuthenticationPage(SUT testEnv) {
		super(testEnv);
	}
	
	public void enterEmailAddress(String email){
		findElement(By.id(emailAddress_id)).sendKeys(email);
	}
	
	public CreateAccountPage createAccount(){
		click(By.name(createAccount_btn_name));
		return new CreateAccountPage(testEnv);
	}
}
