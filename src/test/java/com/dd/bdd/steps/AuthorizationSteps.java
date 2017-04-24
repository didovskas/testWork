package  com.dd.bdd.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.dd.bdd.page_Objects.FeedPage;
import com.dd.bdd.page_Objects.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;

public class AuthorizationSteps {
	
	public WebDriver driver;
	public LoginPage loginPage;
	public FeedPage feedPage;
	
	@Before("@mobile")
	public void initMobileWebDribver() throws InterruptedException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("deviceName", "TCY9KA9680706960");
		capabilities.setCapability("platformName", "Android");		
		try
		{
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			Thread.sleep(5000);
		}
		catch(MalformedURLException e)
		{
			e.printStackTrace();
		}
		loginPage = new LoginPage(driver);
		feedPage = new FeedPage(driver);
	}
	
	@Before("@web")
	public void initWebDriver(){
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		feedPage = new FeedPage(driver);
	}
	

	@Given("^user is on the login page$")
	public void user_is_on_the_login_page(){
		loginPage.goToLoginPage();
		
	}

	@When("^user loggin, using his login (.*), and password (.*)$")
	public void user_loggin_using_his_email(String login, String passwrod)  {
		loginPage.fillFormAndLogin(login, passwrod);
	}

	@Then("^user steel on the login page and see error message$")
	public void user_see_error_message() {
		Assert.assertEquals(loginPage.pageTitle, driver.getTitle());
		Assert.assertTrue(loginPage.isErrorMessageDisplayed());
	}
	
	@Then("^user gets on the profile page and doesnt see error message$")
	public void  user_gets_on_the_feed_page() throws Throwable {
		Assert.assertFalse(loginPage.isErrorMessageDisplayed());
		Assert.assertEquals(feedPage.pageTitle, driver.getTitle());
	}
	
	@After
	public void driverQuit(){
		driver.quit();
	}
}
