package com.flipkart.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            try {
                // Create timestamp (e.g., 2025-09-07_12-45-30)
                String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

                // Ensure output directory exists
                String reportsDir = System.getProperty("user.dir") + File.separator + "test-output";
                File dir = new File(reportsDir);
                if (!dir.exists()) {
                    if (!dir.mkdirs()) {
                        System.err.println("⚠️ Could not create reports directory: " + reportsDir);
                    }
                }

                // Build dynamic timestamped report file path
                String reportPathTimestamped = reportsDir + File.separator + "ExtentReport_" + timestamp + ".html";

                // Build fixed "latest" report file path
                String reportPathLatest = reportsDir + File.separator + "ExtentReport.html";

                // Create reporters
                ExtentSparkReporter sparkTimestamped = new ExtentSparkReporter(reportPathTimestamped);
                ExtentSparkReporter sparkLatest = new ExtentSparkReporter(reportPathLatest);

                // Load external XML config safely (apply to both reporters)
                File xmlConfig = new File(System.getProperty("user.dir")
                        + File.separator + "src"
                        + File.separator + "main"
                        + File.separator + "resources"
                        + File.separator + "extent-config.xml");
                if (xmlConfig.exists()) {
                    try {
                        sparkTimestamped.loadXMLConfig(xmlConfig);
                        sparkLatest.loadXMLConfig(xmlConfig);
                    } catch (Exception e) {
                        System.err.println("⚠️ Failed to load extent-config.xml: " + e.getMessage());
                    }
                } else {
                    System.err.println("⚠️ extent-config.xml not found at " + xmlConfig.getAbsolutePath());

                    // Fallback configs (applied only if XML not found)
                    sparkTimestamped.config().setDocumentTitle("Flipkart Automation Report");
                    sparkTimestamped.config().setReportName("Regression Test Report");

                    sparkLatest.config().setDocumentTitle("Flipkart Automation Report");
                    sparkLatest.config().setReportName("Regression Test Report");
                }

                extent = new ExtentReports();
                extent.attachReporter(sparkTimestamped, sparkLatest);
                

                // Add system/environment info
                extent.setSystemInfo("OS", System.getProperty("os.name"));
                extent.setSystemInfo("Java Version", System.getProperty("java.version"));
                extent.setSystemInfo("Tester", "Pradeep");

            } catch (Exception e) {
                // Catch-all to ensure extent instance is returned even if something goes wrong
                System.err.println("❌ Error initializing ExtentReports: " + e.getMessage());
                e.printStackTrace();
                extent = new ExtentReports(); // fallback empty instance
            }
        }
        return extent;
    }
}
