package com.flipkart.actions;

import org.openqa.selenium.WebDriver;
import com.flipkart.base.FlipKartBaseAction;
import com.flipkart.utils.Waits;

import static com.flipkart.pages.FlipKartLoginPage.*;

public class FlipKartLoginPageActions extends FlipKartBaseAction {

	public static String mobileNumberValue;

	public FlipKartLoginPageActions(WebDriver driver) {
		super(driver);

	}

	Waits waits = new Waits(driver);

	public FlipKartLoginPageActions verifyLoginFunctionalityFlipKartLoginPage(String mobileNumberValue) {

		waits.forElementToBeClickable(loginButton).click();
		waits.forPresenceOfElement(mobileNumber).sendKeys(mobileNumberValue);
		Waits.forSometime(2000);
		waits.forElementToBeClickable(requestOTP).click();
		waits.forSomeTime(20000);
		

		return this;
	}

}
