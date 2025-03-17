package com.petstore.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.petstore.hooks.PetHooks;
import com.petstore.pages.HomePetPage;

import io.cucumber.java.en.*;

public class PetHome {
	
	WebDriver driver;
	HomePetPage homePage;
	
    private static final Logger logger = LogManager.getLogger(PetDetails.class);

	//user on home page
	@Given("User enter the home page")
	public void user_enter_the_home_page() {
	    logger.info("User enter the home page");

	    try {
		    driver=PetHooks.getDriver();
		    Assert.assertEquals("https://petstore.octoperf.com/actions/Catalog.action", driver.getCurrentUrl());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
	    }

	}

	//veriying the title
	@Then("I verify the page title")
	public void i_verify_the_page_title() {
	    logger.info("I verify the page title");
	    
		Assert.assertEquals("JPetStore Demo", driver.getTitle());
	}

}
