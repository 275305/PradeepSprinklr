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

                // Build dynamic report file path
                String reportPath = reportsDir + File.separator + "ExtentReport_" + timestamp + ".html";

                ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

                // Load external XML config safely
                File xmlConfig = new File(System.getProperty("user.dir")
                        + File.separator + "src"
                        + File.separator + "main"
                        + File.separator + "resources"
                        + File.separator + "extent-config.xml");
                if (xmlConfig.exists()) {
                    try {
                        spark.loadXMLConfig(xmlConfig);
                    } catch (Exception e) {
                        System.err.println("⚠️ Failed to load extent-config.xml: " + e.getMessage());
                    }
                } else {
                    System.err.println("⚠️ extent-config.xml not found at " + xmlConfig.getAbsolutePath());
                }

                // Fallback configs (can be overridden by XML)
                spark.config().setDocumentTitle("Flipkart Automation Report");
                spark.config().setReportName("Regression Test Report");

                extent = new ExtentReports();
                extent.attachReporter(spark);

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
