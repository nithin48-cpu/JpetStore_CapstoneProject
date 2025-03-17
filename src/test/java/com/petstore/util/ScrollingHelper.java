package com.petstore.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollingHelper {
		
//		WebDriver driver;
//		
//		public ScrollingHelper(WebDriver driver) {
//			 this.driver=driver;
//		}
	

	    //scroll down by pixels
		public static void scrollDownByPixels(WebDriver webDriver,int pixels) {
			JavascriptExecutor js=(JavascriptExecutor) webDriver;
			js.executeScript("window.scrollBy(0,"+pixels+");");
		}
		
		
		//scroll up by pixels
		public static void scrollUpByPixels(WebDriver webDriver,int pixels) {
			JavascriptExecutor js=(JavascriptExecutor) webDriver;
			js.executeScript("window.scrollBy(0,-"+pixels+");");
		}
		
		
		//scroll right by pixels
		public static void scrollRightByPixels(WebDriver webDriver,int pixels) {
			JavascriptExecutor js=(JavascriptExecutor) webDriver;
			js.executeScript("window.scrollBy("+pixels+",0);");
		}
		
		
		//scroll left by pixels
		public static void scrollLeftByPixels(WebDriver webDriver,int pixels) {
			JavascriptExecutor js=(JavascriptExecutor) webDriver;
			js.executeScript("window.scrollBy(-"+pixels+",0);");
		}
		
		//scroll to top of the page
		public static void scrollToTop(WebDriver webDriver) {
			JavascriptExecutor js=(JavascriptExecutor) webDriver;
			js.executeScript("window.scrollTo(0,0);");
		}
		
		
		//scroll to bottom of the page
		public static void scrollToBottom(WebDriver webDriver) {
			JavascriptExecutor js=(JavascriptExecutor) webDriver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		}
					
			
		//scroll to a specific element
		public static void scrollToElement(WebDriver webDriver,WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor) webDriver;
			  js.executeScript("arguments[0].scrollIntoView(); ", element);
		}
			
	

}
