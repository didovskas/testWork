package  com.dd.bdd.steps;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.ComparisonFailure;

import org.junit.Assert;



public class AuthorizationSteps {

	public WebDriver browser;	
	@Given("^user is on the login page$")
	public void user_is_on_the_login_page() {
		browser = new ChromeDriver();
		browser.get("http://m.vk.com");
	}

	@When("^user loggin, using his email$")
	public void user_loggin_using_his_email()  {
		browser.findElement(By.name("email")).sendKeys("didovskas@gmail.com");
		browser.findElement(By.name("pass")).sendKeys("Banan&Nutela");
		browser.findElement(By.className("wide_button")).click();
	}
	
	@When("^user logs in using his phone number$")
	public void user_logs_in_using_his_phone_number()  {
	    browser.findElement(By.name("email")).sendKeys("+380953579313");
		browser.findElement(By.name("pass")).sendKeys("Banan&Nutela");
		browser.findElement(By.className("wide_button")).click();
	}
	@When("^user logs in using wrong phone number$")
	public void user_logs_in_using_wrong_phone_number()  {
		browser.findElement(By.name("email")).sendKeys("zasdad");
		browser.findElement(By.name("pass")).sendKeys("Banan&Nutela");
		browser.findElement(By.className("wide_button")).click();
	}

	@Then("^user see error message$")
	public void user_see_error_message() {
		Assert.assertTrue(browser.findElement(By.className("service_msg_warning")).isDisplayed());
	}
	@Then("^user gets on the profile page$")
	public void  user_gets_on_the_feed_page() throws Throwable {
		Assert.assertEquals("https://m.vk.com/feed", browser.getCurrentUrl());
	}
	@Then("^browser closing$")
	public void browser_closing() throws Throwable {
		browser.quit();

	}
}
