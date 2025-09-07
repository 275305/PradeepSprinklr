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
                new File(reportsDir).mkdirs();

                // Build dynamic report file path
                String reportPath = reportsDir + File.separator + "ExtentReport_" + timestamp + ".html";

                ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

                // ✅ Load external config safely
                File configFile = new File(System.getProperty("user.dir") + File.separator + "extent-config.xml");
                if (configFile.exists()) {
                    spark.loadXMLConfig(configFile);
                }

                extent = new ExtentReports();
                extent.attachReporter(spark);

                // Add system/environment info
                extent.setSystemInfo("OS", System.getProperty("os.name"));
                extent.setSystemInfo("Java Version", System.getProperty("java.version"));
                extent.setSystemInfo("Tester", "Pradeep");

            } catch (Exception e) {
                throw new RuntimeException("❌ Failed to initialize ExtentReports", e);
            }
        }
        return extent;
    }
}
