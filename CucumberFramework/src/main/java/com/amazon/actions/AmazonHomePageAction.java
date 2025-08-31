package com.amazon.actions;

import com.amazon.base.AmazonBaseAction;
import com.amazon.pages.AmazonHomePage;
import com.amazon.utils.Waits;

import org.openqa.selenium.WebDriver;
import static com.amazon.pages.AmazonHomePage.*;

public class AmazonHomePageAction extends AmazonBaseAction {

	public static String serachTextValue;
	public static String expectedTitle;
	AmazonHomePage homePage;
	Waits waits = new Waits(driver);

	public AmazonHomePageAction(WebDriver driver) {
		super(driver);
		createPage(AmazonHomePage.class);
	}

	// verifyTitleFlipKartHomePage
	public String[] verifyTitleFlipKartHomePage(String expectedTitle) {
		String actualTitle = driver.getTitle();
		System.out.println("Actual Title is: " + actualTitle);
		return new String[] { actualTitle, expectedTitle };
	}

	// search products
	public String searchProductFlipKartHomePage(String product) {

		waits.sendKeys(searchBox, product);
		waits.click(searchButton);
		waits.forPresenceOfElement(resultText);
		 // Return the text from result element
	    String results = waits.getText(resultText);
	    System.out.println("Search Results: " + results);
	    return results;

		

	}

}
