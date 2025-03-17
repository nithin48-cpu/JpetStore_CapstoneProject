package com.petstore.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.petstore.hooks.PetHooks;
import com.petstore.pages.HomePetPage;
import com.petstore.pages.LoginPetPage;
import com.petstore.pages.ListPetPage;
import com.petstore.pages.PricePetPage;
import com.petstore.pages.RegisterPetPage;
import com.petstore.pages.SearchPetPage;

import io.cucumber.java.en.*;

public class PetSearch {
	
	WebDriver driver;
	HomePetPage homePage;
    SearchPetPage searchPage;
    ListPetPage petListPage;
    PricePetPage petpricePage;
    
    private static final Logger logger = LogManager.getLogger(PetDetails.class);

	//user on home page
	@Given("the user is on home page")
	public void the_user_is_on_home_page() {
		logger.info("the user is on home page");
		
		try {
			driver=PetHooks.getDriver();
			Assert.assertEquals("https://petstore.octoperf.com/actions/Catalog.action", driver.getCurrentUrl());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
	    }

	}

	//search for a pet
	@When("user search for a {string}, get the pet list and select a pet")
	public void user_search_for_a_get_the_pet_list_and_select_a_pet(String string) {
		logger.info("user search for a {string}, get the pet list and select a pet");
		
		try {
			searchPage = new SearchPetPage(driver);
			petListPage= new ListPetPage(driver);
			
			searchPage.searchPet(string);
			petListPage.getFirstPet();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
	    }
		

	}
	
	//validate the price of pet
	@Then("user validate the price of the pet")
	public void user_validate_the_price_of_the_pet() {
		logger.info("user validate the price of the pet");
		
		try {
			petpricePage=new PricePetPage(driver);
		    Assert.assertTrue(petpricePage.priceElement.isDisplayed());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
	    }

	}

}
