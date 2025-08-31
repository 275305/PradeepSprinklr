package com.flipkart.actions;

import com.flipkart.base.FlipKartBaseAction;
import com.flipkart.pages.FlipKartHomePage;
import com.flipkart.utils.Waits;

import org.openqa.selenium.WebDriver;

public class FlipKartHomePageAction extends FlipKartBaseAction {
	public static String searchTextValue;
	public static String expectedTitle;
	FlipKartHomePage homePage;
	Waits waits = new Waits(driver);

	// Constructor
	public FlipKartHomePageAction(WebDriver driver) {
		super(driver);
		createPage(FlipKartHomePage.class); // <-- corrected
	}

	// verifyTitleFlipKartHomePage
	public String[] verifyTitleFlipKartHomePage(String expectedTitle) {
		String actualTitle = driver.getTitle();
		System.out.println("Actual Title is: " + actualTitle);
		return new String[] { actualTitle, expectedTitle };
	}

	// search products
	public String searchProductFlipKartHomePage(String product) {
		waits.sendKeys(FlipKartHomePage.searchBox, product); // <-- added FlipKartHomePage reference
		waits.click(FlipKartHomePage.searchButton);
		waits.forPresenceOfElement(FlipKartHomePage.resultText);

		// Return the text from result element
		String results = waits.getText(FlipKartHomePage.resultText);
		System.out.println("Search Results: " + results);
		return results;
	}

}
