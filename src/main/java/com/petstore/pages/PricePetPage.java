package com.petstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.petstore.basepage.BasePage;

public class PricePetPage extends BasePage{

	WebDriver driver;
	
	public PricePetPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='Catalog']/table/tbody/tr[2]/td[4]")
	public static WebElement priceElement;

}
