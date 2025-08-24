package com.amazon.base;
import org.openqa.selenium.WebDriver;
import com.amazon.utils.Waits;

public class AmazonBasePage {
	
	

	    protected WebDriver driver;
	    protected Waits waits;

	    public AmazonBasePage(WebDriver driver) {
	        this.driver = driver;
	        this.waits = new Waits(driver);
	    }
	}



