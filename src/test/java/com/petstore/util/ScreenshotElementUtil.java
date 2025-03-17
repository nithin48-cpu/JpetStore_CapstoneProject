package com.petstore.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenshotElementUtil {

	 public static void captureScreenshot(WebDriver driver,WebElement element) {
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        String filePath = "./screenshots/screenshot_element_" + timestamp + ".png";
	        
	        File source = element.getScreenshotAs(OutputType.FILE);
	        File destination = new File(filePath);       

	        try {
	            FileUtils.copyFile(source, destination);
	            System.out.println("Screenshot saved: " + filePath);
	        } catch (IOException e) {
	            System.out.println("Failed to save screenshot: " + e.getMessage());
	        }
	    }

}
