package com.petstore.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.petstore.basepage.BasePage;

public class HomePetPage extends BasePage{
	
	public HomePetPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Enter the Store")
	public WebElement enterStore;
	
	//Entered the home page
	public void enterHomePage() {	
		  enterStore.click();
	}

}
