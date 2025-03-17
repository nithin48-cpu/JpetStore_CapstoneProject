package com.petstore.util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHelper {
	
	WebDriver driver;

	public AlertHelper(WebDriver driver) {
		this.driver=driver;
	}	
	
	public void acceptAlertBox() {
		Alert alert= driver.switchTo().alert();
			alert.accept();
	}

	public void acceptConfirmAlertBox(String decision) {
		Alert alert= driver.switchTo().alert();
		if(decision=="accept")
			alert.accept();
		else
			alert.dismiss();
	}
	
	public void acceptPromptAlertBox(String decision) {
		Alert alert= driver.switchTo().alert();
		if(decision=="accept")
			alert.accept();
		else
			alert.dismiss();
	}

}
