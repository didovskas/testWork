package com.dd.bdd.page_Objects;

import org.openqa.selenium.WebDriver;

public class FeedPage extends PageObject {

	public FeedPage(WebDriver driver) {
		super(driver);		
	}
	
	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}



}
