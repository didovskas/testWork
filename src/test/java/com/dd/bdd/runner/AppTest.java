package com.dd.bdd.runner;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import com.bdd.dd.helpers.UserData;
import com.dd.bdd.page_Objects.FeedPage;
import com.dd.bdd.page_Objects.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest
{
	public WebDriver driver;
	public LoginPage loginPage;
	public FeedPage feedPage;
	@Before
	public void setUp() throws Exception
	{
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

	@Test
	public void Login() throws Exception
	{
		loginPage.fillFormAndLogin(UserData.userEmail,UserData.userPassword);
		Assert.assertEquals("https://m.vk.com/feed", driver.getCurrentUrl());
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}

}