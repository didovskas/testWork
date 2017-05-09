package com.dd.bdd.steps;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


import cucumber.api.java.Before;

public class Hooks{
	
	
	
	
	public static AppiumDriverLocalService service;
	public static WebDriver driver;	
	
	
	
	@Before("@web")
  	
	
    public void openBrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
		System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver");
    	driver = new ChromeDriver();
    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();

	}	
	
	@Before("@mobile")
	public void initMobileWebDribver() throws InterruptedException{
		if(service == null){
			AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
			service = AppiumDriverLocalService.buildService(serviceBuilder);
			service.start();
            System.out.println("APPIUM URL: " + service.getUrl());
            System.out.println("*******************************************************************************************");
            System.out.println("");
            
            
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                	service.stop();
                }
            });
		}
		
		
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






