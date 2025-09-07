package com.flipkart.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date; // ✅ use java.util.Date (NOT java.sql.Date)

public class ExtentManager {
    private static ExtentReports extent;

    public static synchronized ExtentReports getInstance() throws Exception {
        if (extent == null) {
            // Create timestamp (e.g., 2025-09-07_12-45-30)
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

            // Ensure output directory exists
            String reportsDir = System.getProperty("user.dir") + File.separator + "test-output";
            new File(reportsDir).mkdirs();

            // Build dynamic report file path
            String reportPath = reportsDir + File.separator + "ExtentReport_" + timestamp + ".html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            // ✅ Load external XML config for styling
            spark.loadXMLConfig(new File(System.getProperty("user.dir") 
                                + File.separator + "src" 
                                + File.separator + "main" 
                                + File.separator + "resources" 
                                + File.separator + "extent-config.xml"));

            // Fallback configs (can be overridden by XML)
            spark.config().setDocumentTitle("Flipkart Automation Report");
            spark.config().setReportName("Regression Test Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            // Add system/environment info
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Tester", "Pradeep");
        }
        return extent;
    }
}
