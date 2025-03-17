package com.petstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.petstore.basepage.BasePage;

public class ListPetPage extends BasePage{
	
	WebDriver driver;
	
	public ListPetPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//*[@id='Catalog']//img[1]")
	WebElement firstPetBox;
	
	@FindBy(xpath = "//*[@id='Catalog]/table/tbody/tr[2]/td[4]")
	public static WebElement priceElement;
	
	//Get the first pet from the search results
	public void getFirstPet() {
		onClick(firstPetBox);
	}

}
