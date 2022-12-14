package org.practice;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DataProvider extends BaseClass {

	public Object[][] tc01(){
		return new Object[][] {{"1","2"}, {"3", "4"}};
	}
	

	
	public void tc02(String userName, String Password) {
		getdriver();
		launchUrl("https://adactinhotelapp.com/");
		WebElement locators = Locators("id", "username");
		sendvalue(locators, userName);
		WebElement locators2 = Locators("id", "password");
		sendvalue(locators2, Password);
		Locators("id", "login").click();
	}
	
}
