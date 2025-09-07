package com.flipkart.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.flipkart.reports.ExtentManager;
import com.flipkart.reports.ExtentTestManager;
import com.flipkart.utils.ScreenshotUtil;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    // Helper to set driver in listener
    public static void setDriver(WebDriver driver) {
        driverThread.set(driver);
    }

    private WebDriver getDriver() {
        return driverThread.get();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        ExtentTestManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().pass("✅ Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Capture screenshot
        String screenshotPath = ScreenshotUtil.captureScreenshot(getDriver(), result.getMethod().getMethodName());

        try {
            ExtentTestManager.getTest()
                    .fail("❌ Test Failed: " + result.getThrowable(),
                            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (Exception e) {
            ExtentTestManager.getTest().fail("❌ Failed but screenshot could not be attached.");
        }

        Reporter.log("Screenshot saved at: " + screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().skip("⚠️ Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // Save report
    }
}
