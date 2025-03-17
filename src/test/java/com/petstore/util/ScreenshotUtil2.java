package com.petstore.util;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import io.cucumber.java.Scenario;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil2 {

    // Method to capture and save screenshots
    public static void captureScreenshot(WebDriver driver, Scenario result) {
        // Get test name and status
        String testName = result.getName();
        String status = result.isFailed() ? "Failed": "Passed";

        // Timestamp for unique naming
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String folderPath = "./screenshots/" + status;

        // Create directory if not exists
        File directory = new File(folderPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Define screenshot file path
        String filePath = folderPath + "/" + testName + "_" + timestamp + ".png";

        try {
            // Capture screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File(filePath);

            // Save the screenshot
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot saved: " + filePath);

        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}