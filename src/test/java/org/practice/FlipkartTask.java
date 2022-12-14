package org.practice;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.xml.sax.Locator;

public class FlipkartTask extends BaseClass {
	@Test
	public void page1() {
		getdriver();
		launchUrl("https://www.flipkart.com/");
		getTitle();
		Locators("xpath", "//button[@class='_2KpZ6l _2doB4z']").click();
		Locators("xpath", "//input[@class='_3704LK']").sendKeys("iphone 13 pro", Keys.ENTER);
	}
@Test
	public void page2() {
	List<WebElement> name = locatorss("//div[contains(text(),'APPLE')]/ancestor::div[@class='_3pLy-c row']/descendant::div[@class='_30jeq3 _1_WHN1']");	
	for (int i = 0; i < name.size(); i++) {
		System.out.println(i);
	}	
	}
}
