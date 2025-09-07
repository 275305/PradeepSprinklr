package com.flipkart.utils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {
	
		    // Method to capture screenshot and return file path
	    public static String captureScreenshot(WebDriver driver, String testName) {
	        // Timestamp for unique screenshot name
	        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
	        String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshots/" 
	                                + testName + "_" + timestamp + ".png";
	        try {
	            // Take screenshot
	            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            File dest = new File(screenshotPath);

	            // Create directory if not exists
	            dest.getParentFile().mkdirs();

	            // Save screenshot
	            FileUtils.copyFile(src, dest);
	        } catch (IOException e) {
	            System.out.println("❌ Failed to capture screenshot: " + e.getMessage());
	        }
	        return screenshotPath;
	    }
	}



