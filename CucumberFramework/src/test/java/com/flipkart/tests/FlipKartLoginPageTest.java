package com.flipkart.tests;

import org.testng.annotations.Test;

import com.flipkart.actions.FlipKartLoginPageActions;


public class FlipKartLoginPageTest extends FlipKartBaseTest {

	@Test
	private void verify_Login_Functionality_FlipKartLoginPage() {

		FlipKartLoginPageActions flipKartLoginPageActions = new FlipKartLoginPageActions(driver);
		FlipKartLoginPageActions.mobileNumberValue = "8919384728";
		

		flipKartLoginPageActions.verifyLoginFunctionalityFlipKartLoginPage(FlipKartLoginPageActions.mobileNumberValue);

	}

}
