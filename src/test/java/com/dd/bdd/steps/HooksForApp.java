package com.dd.bdd.steps;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.Before;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class HooksForApp {
	public static AppiumDriverLocalService service;
	public static WebDriver driver;	
		
	
	
	@Before("@mobileApp")
	public void initMobileWebDribver() throws InterruptedException{
		if(service == null){
			AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
			service = AppiumDriverLocalService.buildService(serviceBuilder);
			service.start();
            System.out.println("APPIUM URL: " + service.getUrl());
            System.out.println("*******************************************************************************************");
            System.out.println("");
		}
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app", "src/main/java/apkFolder/app-debug.apk");
		capabilities.setCapability("appPackage", "com.example.testapp");
		capabilities.setCapability("deviceName", "TCY9KA9680706960");
		capabilities.setCapability("platformName", "Android");
		try
		{
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		}
		catch(MalformedURLException e)
		{
			e.printStackTrace();
		}
	}

}
