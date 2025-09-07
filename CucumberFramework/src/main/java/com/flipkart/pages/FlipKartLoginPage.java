package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.flipkart.base.FlipKartBasePage;

public class FlipKartLoginPage extends FlipKartBasePage {

	public FlipKartLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Locators

	public static By loginButton = By.cssSelector("a[title='Login'] span");

	public static By mobileNumber = By.xpath("(//input[@type='text' and @autocomplete='off'])[2]");
	
	public static By requestOTP = By.xpath("//button[text()='Request OTP']");
	
	public static By pradeepMyProfile = By.xpath("//span[normalize-space()='Pradeep']");
	
	public static By myProfile = By.xpath("//li[normalize-space()='My Profile']");
	
	public static By manageAddress = By.xpath("//div[normalize-space()='Manage Addresses']");
	
	public static By threeDots = By.xpath("//div[@class='rApBmn']//img");
	
	public static By editButton = By.xpath("//span[normalize-space()='Edit']");
	
		
	

}
