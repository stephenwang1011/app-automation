package com.incito.logistics.base;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseParpare {
	
	 protected AppiumDriver driver;
	protected ITestContext testContext = null;

	    @BeforeClass
	    public void setUp(ITestContext context) throws Exception {
	        // set up appium
	    	this.testContext = context;
	        File app = new File("res/apps/ContactManager.apk");
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	        capabilities.setCapability("platformName", "Android");
	        capabilities.setCapability("deviceName","INCITO_8inch_PAD");
	        capabilities.setCapability("platformVersion", "4.3");
	        capabilities.setCapability("app", app.getAbsolutePath());
	        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
	        capabilities.setCapability("appActivity", ".ContactManager");
	        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			testContext.setAttribute("SELENIUM_DRIVER", driver);
	 
	    }
	    
	    
	    @AfterClass
	    public void tearDown() throws Exception {
	        driver.quit();
	    }

}
