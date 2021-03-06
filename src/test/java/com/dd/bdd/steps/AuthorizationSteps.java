package  com.dd.bdd.steps;
import org.openqa.selenium.WebDriver;
import com.dd.bdd.page_Objects.FeedPage;
import com.dd.bdd.page_Objects.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

public class AuthorizationSteps {
	
	public WebDriver driver = Hooks.driver;
	public LoginPage loginPage = new LoginPage(driver);
	public FeedPage feedPage = new FeedPage(driver);
	
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
	
	
}
