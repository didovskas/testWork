package com.dd.bdd.page_Objects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public String pageUrl = "http://m.vk.com/login";
	public String pageTitle = "Login | VK";
	
	@FindBy(name = "email")
		private WebElement emailField;
	
	@FindBy(name = "pass")
	private WebElement passwordField;
	
	@FindBy(className = "wide_button")
	private WebElement loginButton;
	
	@FindBy(className = "service_msg_warning")
	private WebElement errorMessage;
	
	public LoginPage fillEmail(String email){
		emailField.sendKeys(email);
		return this;
	}
	
	public LoginPage fillPassword(String password){
		passwordField.sendKeys(password);
		return this;
	}
	
	public LoginPage clickLoginButton(){
		loginButton.click();
		return this;
	}
	
	public FeedPage fillFormAndLogin(String email, String password){
		this.fillEmail(email).fillPassword(password).clickLoginButton();
		return new FeedPage(driver);
	}
	public boolean isErrorMessageDisplayed(){
		boolean isDisplayed = true;
		 
		 
		 try {
			 errorMessage.isDisplayed();
		 } catch (NoSuchElementException e) {
			 isDisplayed = false;
		 }
		 return isDisplayed;
	}

}
