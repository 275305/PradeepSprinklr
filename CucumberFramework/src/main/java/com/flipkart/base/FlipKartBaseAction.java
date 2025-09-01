package com.flipkart.base;


import org.openqa.selenium.WebDriver;

public class FlipKartBaseAction {
	
	    protected WebDriver driver;

	    public FlipKartBaseAction(WebDriver driver) {
	        this.driver = driver;
	    }

	  	 // Generic page creator
	    public <T extends FlipKartBasePage> T createPage(Class<T> pageClass) {
	        try {
	            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
	        } catch (Exception e) {
	        
	        	throw new RuntimeException("Failed to create page" + pageClass.getName(), e);
	          
	        }
	    }

	}



