package com.flipkart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.flipkart.actions.FlipKartHomePageAction;
import com.flipkart.config.ProductConfig;
import com.flipkart.utils.Waits;

public class FlipKartHomePageTest extends FlipKartBaseTest {

	@Test()
	private void verifyTitleProductFlipKartHomePage() {
		FlipKartHomePageAction amazonHomePageAction = new FlipKartHomePageAction(driver);
		//Get the expected Title from ProductConfig class
		FlipKartHomePageAction.expectedTitle = ProductConfig.get("expectedTitle");

		// Get both actual & expected titles
		String[] titles = amazonHomePageAction.verifyTitleFlipKartHomePage(FlipKartHomePageAction.expectedTitle);
		String actualTitle = titles[0];
		String expectedTitle = titles[1];

		// Assertion with detailed error message
		Assert.assertEquals(actualTitle, expectedTitle,
				"Validation Failed - Title mismatch!\nExpected: " + expectedTitle + "\nActual: " + actualTitle);
		Waits.forSometime(2000);
	}
	
	@Test
	private void searchProductFlipKartHomePage() {
		FlipKartHomePageAction flipkartHomePageAction = new FlipKartHomePageAction(driver);
		FlipKartHomePageAction.searchTextValue= ProductConfig.get("searchText");
		String searchResult = flipkartHomePageAction.searchProductFlipKartHomePage(FlipKartHomePageAction.searchTextValue);
		
	    // Validation (example: just check result text is not empty)
	    Assert.assertTrue(searchResult.contains(FlipKartHomePageAction.searchTextValue),
	            "Validation Failed - Search result text does not contain the product name!");

	}

	
}
