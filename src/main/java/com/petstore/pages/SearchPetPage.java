package com.petstore.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.petstore.basepage.BasePage;

public class SearchPetPage extends BasePage{
	
	WebDriver driver;


	public SearchPetPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="keyword")
	WebElement searchBox;
	
	@FindBy(name="searchProducts")
	WebElement searchButton;
	
	@FindBy(xpath = "//*[@id='QuickLinks']/a[2]")
	WebElement dogButton;
	
	@FindBy(linkText = "K9-RT-02")
	WebElement labradorRetrieverButton;
	
	@FindBy(linkText = "EST-25")
	public WebElement labradorRetrieverID;
	
	@FindBy(xpath = "//*[@id=\"Catalog\"]/table/tbody/tr[4]/td")
	public WebElement title;
	
	@FindBy(xpath = "//*[@id=\"Catalog\"]/table/tbody/tr[3]/td/b/font")
	public WebElement description;
	
	@FindBy(xpath = "//*[@id=\"Catalog\"]/table/tbody/tr[6]/td")
	public WebElement price;
	
	@FindBy(xpath = "//*[@id=\"Catalog\"]/table/tbody/tr[1]/td/img")
	public WebElement image;
	
	@FindBy(xpath = "//*[@id=\"Catalog\"]/table/tbody/tr[5]/td")
	public WebElement stock;
	
	@FindBy(linkText = "Add to Cart")
	WebElement addToCart;
	
	@FindBy(xpath = "//*[@id='Cart']/h2")
	public WebElement shoppingCartTitle;
	
	@FindBy(linkText = "Remove")
	WebElement removeFromCart;
	
	@FindBy(name="updateCartQuantities")
	WebElement updateCart;
	
	@FindBy(linkText = "Proceed to Checkout")
	WebElement checkout;
	
	@FindBy(xpath = "//*[@id='Catalog']/table/tbody/tr[2]/td[1]/a")
	WebElement firstPet;
	
	
	public void searchPet(String name) {
		enterText(searchBox, name);
		onClick(searchButton);
	}
	
	public void openPetList() {
		onClick(dogButton);
	}
	
	public void openLabradorRetrieverList() {
		onClick(labradorRetrieverButton);
	}
	
	public void openLabradorRetriever() {
		onClick(labradorRetrieverID);
	}
	
	public void addToCart() {
		onClick(addToCart);
	}
	
	
	public void addPetsToCart() throws InterruptedException {
		List<WebElement> pets = findWebElements(By.xpath("//*[@id='Catalog']//table//a"));
		
		for(int i=0;i<pets.size();i++) {
			Thread.sleep(1000);
			onClick(pets.get(i));
			onClick(addToCart);
			if(i<pets.size()-1) {
				back();
				back();
			}
		}
	}
	
	
	public void removePetFromCart() {
		onClick(removeFromCart);
	}
	
	public void updatePetInCart() {
		onClick(updateCart);
	}
	
	public void checkout() {
		onClick(updateCart);
	}
	
}
