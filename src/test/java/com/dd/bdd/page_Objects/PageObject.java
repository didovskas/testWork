package com.dd.bdd.page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public  class PageObject {
	
	protected  WebDriver driver;
	
	public PageObject(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public LoginPage goToLoginPage(){
		driver.get("http://m.vk.com");
		return new LoginPage(driver);
	}
	
	
}
