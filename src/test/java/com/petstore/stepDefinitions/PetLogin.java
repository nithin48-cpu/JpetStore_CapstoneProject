package com.petstore.stepDefinitions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.petstore.hooks.PetHooks;
import com.petstore.pages.HomePetPage;
import com.petstore.pages.LoginPetPage;
import com.petstore.pages.RegisterPetPage;
import com.petstore.util.ExcelReader;

import io.cucumber.java.en.*;

public class PetLogin {
	
	WebDriver driver;
	HomePetPage homePage;
	LoginPetPage loginPage;
	
    private static final Logger logger = LogManager.getLogger(PetDetails.class);
	
    private static List<List<String>> excelData;

	//user is on home page
	@Given("The user is on the home page")
	public void the_user_is_on_the_home_page() {
	    logger.info("The user is on the home page");
		
	    try {
			driver=PetHooks.getDriver();
			System.out.println(driver);
		    loginPage = new LoginPetPage(driver);

		    Assert.assertEquals("https://petstore.octoperf.com/actions/Catalog.action", driver.getCurrentUrl());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
	    }

	}

	//enter the credential
	@When("User enter the login credentials {string} and {string}")
	public void user_enter_the_login_credentials_and(String string, String string2) throws InterruptedException {
	    logger.info("User enter the login credentials {string} and {string}");
	    
	    try {
			loginPage.loginPetStore(string, string2);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
	    }

	}

	//validate login successfully
	@Then("Validate user login successfully")
	public void user_login_successfully() {
	    logger.info("Validate user login successfully");

		Assert.assertEquals("https://petstore.octoperf.com/actions/Catalog.action", driver.getCurrentUrl());
	}

}
