package com.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.amazon.actions.AmazonHomePageAction;
import com.amazon.utils.Waits;

public class AmazonHomePageTest extends AmazonBaseTest {

	@Test()
	public void verifySearchProduct() {
		AmazonHomePageAction homeAction = new AmazonHomePageAction(driver);
		homeAction.searchProduct("Laptop");
		boolean isTitle = homeAction.verifyTitle("Laptop");
		Assert.assertTrue(isTitle, "Validation Failed- Title is not Matching");
		Waits.forSometime(2000);

	}

	@Test
	public void verifyCartNavigation() {
		AmazonHomePageAction homeAction = new AmazonHomePageAction(driver);
		homeAction.goToCart();

		Assert.assertTrue(driver.getTitle().toLowerCase().contains("cart"), "❌ Cart page did not load!");
	}
}
