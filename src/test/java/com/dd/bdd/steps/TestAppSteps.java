package com.dd.bdd.steps;

import org.junit.Assert;
import org.junit.Assume;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class TestAppSteps {

	public WebDriver driver = HooksForApp.driver;
	
	@Given("^user is on the main page$")
	public void user_is_on_the_main_page() throws Throwable {
		System.out.println("main_page");
	}

	@When("^user send his text$")
	public void user_send_his_text() throws Throwable {
		driver.findElement(By.id("edit_message")).sendKeys("abc");;
	    driver.findElement(By.id("button")).click();
	}

	@Then("^user can see his text on result page$")
	public void user_can_see_his_text_on_result_page() throws Throwable {
	    WebElement element =  driver.findElement(By.id("content")).findElement(By.className("android.widget.TextView"));
	    Assert.assertEquals("abc", element.getText());
	}
	
}
