package com.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.amazon.actions.AmazonHomePageAction;
import com.amazon.config.ProductConfig;
import com.amazon.utils.Waits;

public class AmazonHomePageTest extends AmazonBaseTest {

	@Test()
	private void verifyTitleProductFlipKartHomePage() {
		AmazonHomePageAction amazonHomePageAction = new AmazonHomePageAction(driver);
		//Get the expected Title from ProductConfig class
		AmazonHomePageAction.expectedTitle = ProductConfig.get("expectedTitle");

		// Get both actual & expected titles
		String[] titles = amazonHomePageAction.verifyTitleFlipKartHomePage(AmazonHomePageAction.expectedTitle);
		String actualTitle = titles[0];
		String expectedTitle = titles[1];

		// Assertion with detailed error message
		Assert.assertEquals(actualTitle, expectedTitle,
				"Validation Failed - Title mismatch!\nExpected: " + expectedTitle + "\nActual: " + actualTitle);
		Waits.forSometime(2000);
	}
	
	@Test
	private void searchProductFlipKartHomePage() {
		AmazonHomePageAction amazonHomePageAction = new AmazonHomePageAction(driver);
		AmazonHomePageAction.serachTextValue = ProductConfig.get("searchText");
		String searchResult = amazonHomePageAction.searchProductFlipKartHomePage(AmazonHomePageAction.serachTextValue);
		
	    // Validation (example: just check result text is not empty)
	    Assert.assertTrue(searchResult.contains(AmazonHomePageAction.serachTextValue),
	            "Validation Failed - Search result text does not contain the product name!");

	}

	
}
