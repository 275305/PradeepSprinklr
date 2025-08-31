package com.flipkart.pages;


import org.openqa.selenium.By;

import com.flipkart.base.FlipKartBasePage;



public class FlipKartHomePage extends FlipKartBasePage{

    // Constructor
    public FlipKartHomePage(org.openqa.selenium.WebDriver driver) {
        super(driver);
    }
	
	    // Locators
	    
	    public static By searchBox = By.cssSelector("input[placeholder=\"Search for Products, Brands and More\"]");
	    
	    public static By searchButton = By.cssSelector("button[type=\"submit\"]");
	    
	    public static By resultText = By.xpath("//span[starts-with(normalize-space(text()),'Showing')]");
	    
	    
	    
	   
	    


	   
	    

	   
	}



