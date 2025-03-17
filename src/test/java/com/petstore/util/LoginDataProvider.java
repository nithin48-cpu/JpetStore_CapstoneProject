package com.petstore.util;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
	
	@DataProvider(name = "login_data")
	public Object[][] dataProvider(){
		Object[][] data={
				{"standard_user","secret_sauce"},
				{"locked_out_user","secret_sauce"},
				{"problem_user","secret_sauce"}
		};
		return data;
	}
}
