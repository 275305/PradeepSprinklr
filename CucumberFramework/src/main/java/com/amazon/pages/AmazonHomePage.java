package com.amazon.pages;


import org.openqa.selenium.By;


import com.amazon.base.AmazonBasePage;

public class AmazonHomePage extends AmazonBasePage{

    // Constructor
    public AmazonHomePage(org.openqa.selenium.WebDriver driver) {
        super(driver);
    }
	
	    // Locators
	    
	    public static By searchBox = By.cssSelector("input[placeholder=\"Search for Products, Brands and More\"]");
	    public static By searchButton = By.cssSelector("button[type=\"submit\"]");
	    
	    public static By resultText = By.xpath("//span[starts-with(normalize-space(text()),'Showing')]");
	    
	   
	    


	   
	    

	   
	}



