package com.dev.ap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dev.ap.pages.AuthenticationPage;
import com.dev.ap.pages.CreateAccountPage;
import com.dev.ap.pages.HomePage;


public class ValidateAccount {

	@Test
	public void testCreateAccount(){
		SUT testEnv = new SUT();
		Browser browser = testEnv.getBrowser();
		Configuration config = testEnv.getConfiguration();
		HomePage homePage = browser.open();
		AuthenticationPage authenticationPage = homePage.signIn();
		authenticationPage.enterEmailAddress(config.getEmail());
		CreateAccountPage createAccountPage = authenticationPage.createAccount();
		createAccountPage.setTitle(1);
		createAccountPage.enterFirstName(config.getFirstName());
		createAccountPage.enterLastName(config.getLastName());
		createAccountPage.enterPassword(config.getPassword());
		createAccountPage.setDateOfBirth(1, 2, 2000);
		createAccountPage.setAddress(config.getFirstName(), config.getLastName(), config.getAddress(),
				"Woking", "1", "12345", "21", "07528016936", config.getAddress());
		createAccountPage.register();
		Assert.assertTrue(createAccountPage.verifyElement(By.xpath("//h1[text()='My account']")));
	}
}
