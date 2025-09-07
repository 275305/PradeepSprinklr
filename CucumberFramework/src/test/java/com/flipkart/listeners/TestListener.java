package com.flipkart.listeners;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.flipkart.reports.ExtentManager;
import com.flipkart.utils.ScreenshotUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        driverThread.set(driver);
    }

    public static WebDriver getDriver() {
        return driverThread.get();
    }

    private static ExtentReports getExtent() {
        if (extent == null) {
            extent = ExtentManager.getInstance(); // ✅ No try/catch needed now
        }
        return extent;
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = getExtent().createTest(result.getMethod().getMethodName());
        testThread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testThread.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        testThread.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());

        WebDriver driver = getDriver();
        if (driver != null) {
            try {
                String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
                testThread.get().addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                testThread.get().log(Status.WARNING, " Screenshot could not be attached: " + e.getMessage());
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testThread.get().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        getExtent().flush();
    }
}
