package com.flipkart.base;
import org.openqa.selenium.WebDriver;

import com.flipkart.utils.Waits;

public class FlipKartBasePage {
	
	

	    protected WebDriver driver;
	    protected Waits waits;

	    public FlipKartBasePage(WebDriver driver) {
	        this.driver = driver;
	        this.waits = new Waits(driver);
	    }
	}



