package com.amazon.actions;


import com.amazon.base.AmazonBaseAction;
import com.amazon.pages.AmazonHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class AmazonHomePageAction extends AmazonBaseAction{
	

	

	    private AmazonHomePage homePage;

	    public AmazonHomePageAction(WebDriver driver) {
	        super(driver);
	        homePage = createPage(AmazonHomePage.class);
	    }

	    public void searchProduct(String product) {
	        homePage.enterSearchText(product);
	        homePage.clickSearchButton();
	        
	        
	    }
	    public boolean verifyTitle() {
	        String actualTitle = driver.getTitle();
	        System.out.println("Page Title: " + actualTitle);
	        String expectedKeyword = "laptop";
	        return actualTitle != null && actualTitle.toLowerCase().contains(expectedKeyword.toLowerCase());
	    }


	    public void goToAccountMenu() {
	        homePage.openAccountMenu();
	    }

	    public void goToCart() {
	        homePage.openCart();
	    }
	}



