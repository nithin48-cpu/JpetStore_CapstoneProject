package com.petstore.runners;

import java.util.HashMap;
import java.util.Map;


import org.testng.annotations.*;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.petstore.util.ExcelReader;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/Features/",
		glue = {"com.petstore.hooks","com.petstore.stepDefinitions"},
	    plugin = {
	    		"pretty",
	    		"html:Business_Components/Cucumber-Reports/cucumber_report.html",
	    		"json:Business_Components/Cucumber-Reports/cucumber_report.json",
	    		"junit:Business_Components/Cucumber-Reports/cucumber_report.xml",
	    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	    		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" 
	    },
		monochrome = true
		)
public class HomeRunner extends AbstractTestNGCucumberTests{
	
	public static String browser;
	public static String url;
	
	//here we are passing the browser and Url from xml files
	@BeforeTest()
	@Parameters(value = {"browser","url"})
	public void setup(@Optional("chrome") String browser,@Optional("https://petstore.octoperf.com/") String  url) {
		this.browser=browser;
		this.url=url;
        
		
		//below code make the run every features multiple times using testdata from the excel sheets dynamically
//        Map<String, String> featureToExcelMap = new HashMap<>();
//        featureToExcelMap.put(System.getProperty("user.dir")+"\\src\\test\\resources\\Features\\loginPage.feature", System.getProperty("user.dir")+"\\test-data\\user_login_data.xlsx");
//        featureToExcelMap.put(System.getProperty("user.dir")+"\\src\\test\\resources\\Features\\registerPage.feature", System.getProperty("user.dir")+"\\test-data\\user_reg_data.xlsx");
//        featureToExcelMap.put(System.getProperty("user.dir")+"\\src\\test\\resources\\Features\\searchPage.feature", System.getProperty("user.dir")+"\\test-data\\search_data.xlsx");
//
//        // Loop through each feature file and update with Excel data
//        for (Map.Entry<String, String> entry : featureToExcelMap.entrySet()) {
//            String featurePath = entry.getKey();
//            String excelPath = entry.getValue();
//            ExcelReader.updateFeatureFileWithData(excelPath, featurePath);
//        }
	}

}
