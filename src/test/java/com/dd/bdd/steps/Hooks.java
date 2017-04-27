package com.dd.bdd.steps;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.Before;

public class Hooks{
	
	public static WebDriver driver;	
	
	@Before("@web")
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
	
	
    public void openBrowser() throws IOException {
		Runtime.getRuntime().exec("appium");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/");
    	driver = new ChromeDriver();
    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();

	}	
	
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
		
	}

}
