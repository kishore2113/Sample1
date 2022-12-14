package org.practice;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Parameters extends BaseClass {
	@org.testng.annotations.Parameters({"user" ,"pass"})
@Test
	public void tc01(String username, String password) {
		getdriver();
		launchUrl("http://adactinhotelapp.com/");
		PageObject p = new PageObject();
		WebElement txtUserName = p.getTxtUserName();
		sendvalue(txtUserName, username);
		WebElement txtPassword = p.getTxtPassword();
		sendvalue(txtPassword, password);
	}





}
