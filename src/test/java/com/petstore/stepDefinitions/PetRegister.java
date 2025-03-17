package com.petstore.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.petstore.hooks.PetHooks;
import com.petstore.pages.HomePetPage;
import com.petstore.pages.RegisterPetPage;

import io.cucumber.java.en.*;

public class PetRegister {
	
	WebDriver driver;
	HomePetPage homePage;
	RegisterPetPage registerPage;
	
    private static final Logger logger = LogManager.getLogger(PetDetails.class);

    //user is on home page
	@Given("User is on the home page")
	public void user_is_on_the_home_page() {
	    logger.info("User is on the home page");
	    
	    try {		
			driver=PetHooks.getDriver();
		    Assert.assertEquals("https://petstore.octoperf.com/actions/Catalog.action", driver.getCurrentUrl());
			registerPage = new RegisterPetPage(driver);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
	    }


	}
	
	//enter the username and password for register
	@When("User enters credentials {string} and {string}")
	public void user_enters_credentials_and(String string, String string2) throws InterruptedException {
	    logger.info("User enter the login credentials {string} and {string}");
	    
	    try {
			registerPage.enterCredentials(string, string2);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
	    }
	}

	//enter the personal details for register
	@When("User enters personal details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
	public void user_enters_personal_details_and(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) throws InterruptedException {
	    logger.info("User enters personal details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}");
	    
	    try {
		    registerPage.enterPersonalDetails(string, string2, string3 , string4, string5, string6, string7, string8,string9 ,string10);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
	    }

	}
	
	//enter the profile details for register
	@When("User enters profile details {string}, {string}, {string}, and {string}")
	public void user_enters_profile_details_and(String string, String string2, String string3, String string4) throws InterruptedException {
	    logger.info("User enters profile details {string}, {string}, {string}, and {string}");
	    
	    try {
		    registerPage.enterProfileDetails(string, string2, Boolean.parseBoolean(string3), Boolean.parseBoolean(string4));
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
	    }
	}

	//Validate register successfully
	@Then("User is registered successfully")
	public void user_is_registered_successfully() {
	    logger.info("User is registered successfully");
	    Assert.assertEquals("https://petstore.octoperf.com/actions/Account.action", driver.getCurrentUrl());
	}



}
