package com.petstore.hooks;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;

import com.petstore.pages.HomePetPage;
import com.petstore.pages.LoginPetPage;
import com.petstore.runners.HomeRunner;
import com.petstore.util.ScreenshotUtil2;

import io.cucumber.java.*;



public class PetHooks {

	private static WebDriver driver;
	HomePetPage homePage;
	LoginPetPage loginPage;
	
	
	
    @Before
	public void setup() {
    	System.out.println("setup");
		String browser=HomeRunner.browser;
		String url=HomeRunner.url;
    	
		switch(browser.toLowerCase()) {
		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
//			edgeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/134.0.0.0 Safari/537.36");
			driver=new EdgeDriver(edgeOptions);
			break;
		case "chrome":
			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless");
			//options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/134.0.0.0 Safari/537.36");
//			options.addArguments("--incognito");
//			options.addArguments("-private");
//			options.addArguments("--disable-web-security");
//			options.addArguments("--disable-site-isolation-trials");
//			options.addArguments("--allow-running-insecure-content");

			driver=new ChromeDriver(options);
			break;
		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
//			firefoxOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/134.0.0.0 Safari/537.36");
			driver=new FirefoxDriver(firefoxOptions);
			break;
		default :
			throw new IllegalArgumentException(browser+" Browser not supported");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
    	homePage=new HomePetPage(driver);
 	    homePage.enterHomePage();
	
	}
    
    @Before("@Functionality")
    public void funtionality() throws InterruptedException {
 	    loginPage = new LoginPetPage(driver);
		loginPage.loginPetStore("j2ee", "j2ee");
    }
    
    
    @After
    public void teardown() {
        System.out.println("Closing browser...");
        if (driver != null) {
            driver.quit();
        }
    }
    
    
//    @BeforeStep
//    public void beforeStep() {
//        System.out.println("🔹 Before Step Hook Executed");
//    }
//
    @AfterStep
    public void afterStep(Scenario scenario) throws InterruptedException {
        Thread.sleep(1000);
        ScreenshotUtil2.captureScreenshot(driver, scenario);
    }
    

	public static WebDriver getDriver() {
		return driver;
	}


}
