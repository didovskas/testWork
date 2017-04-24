package com.dd.bdd.page_Objects;

import org.openqa.selenium.WebDriver;

public  class PageObject {
	
	protected  WebDriver driver;
	
	public PageObject(WebDriver driver){
		this.driver = driver;
	}
	
	public LoginPage goToLoginPage(){
		driver.get("http://m.vk.com");
		return new LoginPage(driver);
	}
	
	public void closeDriver(){
		driver.quit();
	}
}
