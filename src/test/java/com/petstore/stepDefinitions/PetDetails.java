package com.petstore.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.petstore.hooks.PetHooks;
import com.petstore.pages.HomePetPage;
import com.petstore.pages.ListPetPage;
import com.petstore.pages.PricePetPage;
import com.petstore.pages.SearchPetPage;

import io.cucumber.java.en.*;

public class PetDetails {
	
	WebDriver driver;
	HomePetPage homePage;
    SearchPetPage searchPage;
    ListPetPage petListPage;
    PricePetPage petpricePage;
	
    private static final Logger logger = LogManager.getLogger(PetDetails.class);

	//user is on home page
	@Given("The user is on home page")
	public void the_user_is_on_home_page() {
	    logger.info("The user is on home page");
	    
	    try {
			driver=PetHooks.getDriver();
		    Assert.assertEquals("https://petstore.octoperf.com/actions/Catalog.action", driver.getCurrentUrl());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
	    }
	}
	
	//search and select the pet
	@When("Select the pet,Get the pet list and select the pet you like")
	public void select_the_pet_get_the_pet_list_and_select_the_pet_you_like() {
	    logger.info("Select the pet,Get the pet list and select the pet you like");
	    
	    try {
			searchPage = new SearchPetPage(driver);
			petListPage= new ListPetPage(driver);
			
			searchPage.openPetList();
			searchPage.openLabradorRetrieverList();
			searchPage.openLabradorRetriever();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
	    }
	}
	
	//validate price, title, description, image, availability
	@Then("Validating the product title, description, price, images, and availability.")
	public void validate_the_product_title_description_price_images_and_availability() {
	    logger.info("Validating the product title, description, price, images, and availability.");

	    try {
			Assert.assertEquals("Labrador Retriever", searchPage.title.getText());
			Assert.assertEquals("Adult Female Labrador Retriever", searchPage.description.getText());
			Assert.assertEquals("$325.29", searchPage.price.getText());
			Assert.assertTrue(searchPage.stock.getText().contains("in stock"));
			Assert.assertTrue(searchPage.image.isDisplayed());
			
			searchPage.addToCart();
	    }catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
	    }
	}
	
	//validate pet added to cart
	@And("Validate pet added products to the cart.")
	public void test_adding_products_to_the_cart() {
	    logger.info("Validate pet added products to the cart.");
	    
	    try {
			Assert.assertEquals("Shopping Cart", searchPage.shoppingCartTitle.getText());
			Assert.assertTrue(searchPage.labradorRetrieverID.isDisplayed());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
	    }
	}

}
