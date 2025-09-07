package com.flipkart.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.flipkart.base.FlipKartBaseAction;
import com.flipkart.utils.Waits;

import static com.flipkart.pages.FlipKartLoginPage.*;
import static com.flipkart.actions.FlipKartReusableBaseActions.*;

public class FlipKartLoginPageActions extends FlipKartBaseAction {

	public static String mobileNumberValue;
	 FlipKartReusableBaseActions reusable;

	public FlipKartLoginPageActions(WebDriver driver) {
		super(driver);
		reusable = new FlipKartReusableBaseActions(driver);

	}

	Waits waits = new Waits(driver);

	public boolean verifyLoginFunctionalityFlipKartLoginPage(String mobileNumberValue) {
        boolean isEditButton=false;
		waits.forElementToBeClickable(loginButton).click();
		waits.forPresenceOfElement(mobileNumber).sendKeys(mobileNumberValue);
		Waits.forSometime(2000);
		waits.forElementToBeClickable(requestOTP).click();
		waits.forSomeTime(40000);
		
		WebElement pradeepMyProfileLink=waits.forElementToBeClickable(pradeepMyProfile);
		reusable.hoverOnElement(pradeepMyProfileLink);
		waits.forSomeTime(2000);
		waits.forElementToBeClickable(myProfile).click();
		waits.forSomeTime(2000);
		waits.forElementToBeClickable(manageAddress).click();
		waits.forSomeTime(2000);
		
		WebElement threeDotsElement=waits.forElementToBeClickable(threeDots);
		waits.forSomeTime(2000);
		reusable.hoverOnElement(threeDotsElement);
		
		WebElement editButtonElement=waits.forVisibilityOfElement(editButton);
		waits.forSomeTime(2000);
		
		if(editButtonElement.isDisplayed()) {
			 isEditButton=true;
			
		}

		return isEditButton;
	}

}
