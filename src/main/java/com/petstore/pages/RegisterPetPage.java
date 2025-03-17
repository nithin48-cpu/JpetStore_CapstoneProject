package com.petstore.pages;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.petstore.basepage.BasePage;

public class RegisterPetPage extends BasePage{
	
	WebDriver driver;
	
	public RegisterPetPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Sign In")
	WebElement signInButton;
	
	@FindBy(linkText = "Register Now!")
	WebElement registerButton;
	
	@FindBy(name="username")
	WebElement userIdBox;
	
	@FindBy(name="password")
	WebElement passwordBox;
	
	@FindBy(name="repeatedPassword")
	WebElement repasswordBox;
	
	@FindBy(name="account.firstName")
	WebElement firstnameBox;
	
	@FindBy(name="account.lastName")
	WebElement lastnameBox;
	
	@FindBy(name="account.email")
	WebElement emailBox;
	
	@FindBy(name="account.phone")
	WebElement phoneBox;
	
	@FindBy(name="account.address1")
	WebElement address1Box;
	
	@FindBy(name="account.address2")
	WebElement address2Box;
	
	@FindBy(name="account.city")
	WebElement cityBox;
	
	@FindBy(name="account.state")
	WebElement stateBox;
	
	@FindBy(name="account.zip")
	WebElement pincodeBox;
	
	@FindBy(name="account.country")
	WebElement countryBox;
	
	@FindBy(name="account.languagePreference")
	WebElement languageSelect;
	
	@FindBy(name="account.favouriteCategoryId")
	WebElement petSelect;
	
	@FindBy(name="account.listOption")
	WebElement listCheckBox;
	
	@FindBy(name="account.bannerOption")
	WebElement bannerCheckBox;
	
	@FindBy(name="newAccount")
	WebElement createAccountButton;
	
	//Enter the user name and password for register
	public void enterCredentials(String username,String password) throws InterruptedException {
				
		onClick(signInButton);
		onClick(registerButton);
		
		enterText(userIdBox, username);
		enterText(passwordBox, password);
		enterText(repasswordBox, password);
	}
	
	//Enter the personal Details for register
	public void enterPersonalDetails(String firstname,
			String lastname,String email,
			String phone,String Address1,
			String Address2,String city,
			String state,String pincode,
			String country
			) throws InterruptedException {
		
		
		enterText(firstnameBox, firstname);
		enterText(lastnameBox, lastname);
		enterText(emailBox, email);
		enterText(phoneBox, phone);
		enterText(address1Box, Address1);
		enterText(address2Box, Address2);
		enterText(cityBox, city);
		enterText(stateBox, state);
		enterText(pincodeBox, pincode);
		enterText(countryBox, country);
	}
	
	//Enter the Profile details for register
	public void enterProfileDetails(String language,String pet,Boolean list,Boolean banner) throws InterruptedException {
		
		selectOption(languageSelect,language);
		selectOption(petSelect, pet);
		
		if(list) {
			onClick(listCheckBox);
		}
		if(banner) {
			onClick(bannerCheckBox);
		}
		onClick(createAccountButton);
		
	}
	
	

}
