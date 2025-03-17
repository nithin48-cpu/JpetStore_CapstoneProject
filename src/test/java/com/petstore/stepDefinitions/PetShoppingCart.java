package com.petstore.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.petstore.hooks.PetHooks;
import com.petstore.pages.HomePetPage;
import com.petstore.pages.ListPetPage;
import com.petstore.pages.PricePetPage;
import com.petstore.pages.SearchPetPage;

import io.cucumber.java.en.*;

public class PetShoppingCart {
	
	WebDriver driver;
	HomePetPage homePage;
    SearchPetPage searchPage;
    ListPetPage petListPage;
    PricePetPage petpricePage;
	
    private static final Logger logger = LogManager.getLogger(PetDetails.class);

    //user is on home page
	@Given("the user is on home page to buy pet")
	public void the_user_is_on_home_page_to_buy_pet() {
		logger.info("the user is on home page to buy pet");
		
		try {
			driver=PetHooks.getDriver();
		    Assert.assertEquals("https://petstore.octoperf.com/actions/Catalog.action", driver.getCurrentUrl());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
	    }

	}
	
	//open pet list
	@When("Open pet list")
	public void open_pet_list() {
		logger.info("Open pet list");
		
		try {
			searchPage=new SearchPetPage(driver);
			searchPage.openPetList();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
	    }

	}
	
	//add to cart
	@And("add pets to cart")
	public void add_pets_to_cart() throws InterruptedException {
		logger.info("add pets to cart");
		
		try {
			searchPage.addPetsToCart();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
	    }
	}
	
	//Manipulate items
	@And("remove and update quantities")
	public void remove_and_update_quantities() {
		logger.info("remove and update quantities");
		
		try {
			searchPage.removePetFromCart();
			searchPage.removePetFromCart();
			searchPage.updatePetInCart();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
	    }

	}
	
	//validate in checkout
	@Then("validate proceeding to checkout")
	public void validate_proceeding_to_checkout() {
		logger.info("validate proceeding to checkout");
	    Assert.assertEquals(driver.getCurrentUrl(),"https://petstore.octoperf.com/actions/Cart.action");
	}

}
