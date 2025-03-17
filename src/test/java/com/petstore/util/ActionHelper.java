package com.petstore.util;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;


public class ActionHelper{
	
	WebDriver driver;
	Actions action;
	public ActionHelper(WebDriver driver) {
		this.driver=driver;
		action = new Actions(driver);
	}
	
	
	public void clearInputBox(WebElement element) {
		
		action.click(element)
	          .keyDown(Keys.CONTROL)
	          .sendKeys("a")
	          .sendKeys(Keys.BACK_SPACE)
	          .keyUp(Keys.CONTROL)
	          .perform(); 
		
	}

	public void sendInputBox(WebElement element,String value) {
		
		action.moveToElement(element)
			  .click()
	          .sendKeys(value)
	          .perform(); 
		
	}
	

}
