package com.petstore.basepage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.petstore.*;

public class BasePage {

	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;
	Actions action;
	public BasePage(WebDriver driver) {
		this.driver = driver;
		js=(JavascriptExecutor)driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		action= new Actions(driver);
	}

	
	public WebElement findWebElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> findWebElements(By locator){
		return driver.findElements(locator);
	}
	
	
	
	public void enterText(WebElement element,String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public void onClick(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public void onClickVisiblity(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}
	
	
	public void desideClick(String str1,String str2,WebElement element,WebElement element2) {
		if (str1==str2)
			element.click();
		else
			element2.click();
	}
	
	public void selectOption(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void JS_enterText(String value,WebElement element) {
		js.executeScript("arguments[0].value='"+value+"';", element);
	}
	
	public void JS_click(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}
	
	public void JS_scroll(String pixel) {
		js.executeScript("window.scrollBy(0,"+pixel+");");
	}
	
	public void JS_scrollToElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(); ", element);
	}
	
	public void enterTextWithActions(WebElement element,String value) {
		
		action.click(element)
	        .keyDown(Keys.CONTROL)
	        .sendKeys("a")
	        .sendKeys(Keys.BACK_SPACE)
	        .keyUp(Keys.CONTROL)
	        .perform(); 
		
		action.moveToElement(element)
		      .click()
              .sendKeys(value)
              .perform(); 
	}

	public void onClickWithActions(WebElement element) {
		action.moveToElement(element)
		      .click()
              .perform(); 
	}
	
	public void back() {
		driver.navigate().back(); 
	}
	
}

