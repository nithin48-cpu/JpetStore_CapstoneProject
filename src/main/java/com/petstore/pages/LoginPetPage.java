package com.petstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.petstore.basepage.BasePage;

public class LoginPetPage extends BasePage{
	
	WebDriver driver;
	public LoginPetPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(linkText = "Sign In")
	WebElement signInButton;
	
	@FindBy(name="username")
	WebElement userIdBox;
	
	@FindBy(name="password")
	WebElement passwordBox;
	
	@FindBy(name="signon")
	WebElement loginButton;
	
	//Login into petstore
	public void loginPetStore(String username,String password) {
		onClick(signInButton);
		enterTextWithActions(userIdBox, username);

		enterText(passwordBox, password);	
		onClick(loginButton);
	}

}
