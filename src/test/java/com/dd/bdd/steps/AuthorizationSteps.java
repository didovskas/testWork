package  com.dd.bdd.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import com.bdd.dd.helpers.UserData;
import com.dd.bdd.page_Objects.FeedPage;
import com.dd.bdd.page_Objects.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;

public class AuthorizationSteps {

	public WebDriver driver;
	public LoginPage loginPage;
	public FeedPage feedPage;
		
	@Given("^user is on the login page$")
	public void user_is_on_the_login_page() throws InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("deviceName", "TCY9KA9680706960");
		capabilities.setCapability("platformName", "Android");		
		try
		{
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.goToLoginPage();
			Thread.sleep(5000);
		}
		catch(MalformedURLException e)
		{
			e.printStackTrace();
		}
	}

	@When("^user loggin, using his email$")
	public void user_loggin_using_his_email()  {
		loginPage.fillFormAndLogin(UserData.userEmail,UserData.userPassword);
	}
	
	@When("^user logs in using his phone number$")
	public void user_logs_in_using_his_phone_number()  {
		loginPage.fillFormAndLogin(UserData.userPhone,UserData.userPassword);
	}
	
	@When("^user logs in using wrong phone number$")
	public void user_logs_in_using_wrong_phone_number()  {
		loginPage.fillFormAndLogin(UserData.userPassword,UserData.userPassword);
	}

	@Then("^user see error message$")
	public void user_see_error_message() {
		Assert.assertTrue(loginPage.isErrorMessageDisplayed());
	}
	
	@Then("^user gets on the profile page$")
	public void  user_gets_on_the_feed_page() throws Throwable {
		Assert.assertEquals("https://m.vk.com/feed", driver.getCurrentUrl());
	}
	
	@Then("^browser closing$")
	public void browser_closing(){
		driver.quit();
	}
}
