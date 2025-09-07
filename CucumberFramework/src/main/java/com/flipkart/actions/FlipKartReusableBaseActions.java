package com.flipkart.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.flipkart.base.FlipKartBaseAction;


public class FlipKartReusableBaseActions extends FlipKartBaseAction {
	
	public FlipKartReusableBaseActions(WebDriver driver) {
        super(driver);
    }

    // Reusable method to hover over an element
    public void hoverOnElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
