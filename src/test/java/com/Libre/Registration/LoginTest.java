package com.Libre.Registration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class LoginTest{
	AndroidDriver driver;
	boolean isSuccess;
	boolean isSuccess1;
	boolean isSuccess2;
	boolean isSuccess3;
	boolean isSuccess4;
	boolean isSuccess5;
	boolean isSuccess6;

	@BeforeSuite()
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "HJF0D0EN");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.tenone.libre.registration");
		capabilities.setCapability("appActivity", "com.tenone.libre.activities.SplashActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	@Test(priority = 1)
	public void elementAreDisplayedTest() {
		LoginScreen login = new LoginScreen(driver);
		login.elemtnsAreVisible();
		isSuccess = true;


	}

	// C644
	@Test(priority = 2)
	public void loginWithEmptyFieldsTest() throws IOException, com.gurock.testrail.APIException {
		LoginScreen login = new LoginScreen(driver);
		login.loginWithEmptyFIelds();
		Assert.assertTrue(login.loginButtonIsDisplayed());
		isSuccess1 = true;

	}

	// C645
	@Test(priority = 3)
	public void emptyEmailFieldTest() throws IOException, com.gurock.testrail.APIException {
		LoginScreen login = new LoginScreen(driver);
		login.emptyEmailField();
		Assert.assertTrue(login.loginButtonIsDisplayed());
		isSuccess2 = true;


	}

	// C646
	@Test(priority = 4)
	public void emptyPasswordFieldTest() throws IOException, com.gurock.testrail.APIException {
		LoginScreen login = new LoginScreen(driver);
		login.emptyPasswordField();
		Assert.assertTrue(login.loginButtonIsDisplayed());
		isSuccess3 = true;


	}

	// C647
	@Test(priority = 5)
	public void invalidEmailFormatTest() throws IOException, com.gurock.testrail.APIException {
		LoginScreen login = new LoginScreen(driver);
		login.invalidMailFormat();
		Assert.assertTrue(login.loginButtonIsDisplayed());
		isSuccess4 = true;


	}
	
	@Test(priority = 7)
	public void spaceInEmailTest() throws IOException, com.gurock.testrail.APIException {

		LoginScreen login = new LoginScreen(driver);
		login.spacesInEmail();
		Assert.assertTrue(login.loginButtonIsDisplayed());
		driver.closeApp();
		isSuccess6 = true;
	}
	
	//C652
	@Test(priority = 8)
	public void spacesInPasswordTest(){
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.spacesInPassword();
		login.logout();
		driver.closeApp();
		isSuccess2 = true;
	}

	@Test(priority = 9)
	public void successfulLoginWithValidEMailPasswordTest(){
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.successfulLoginWithValidEMailPassword();
		login.logout();
		isSuccess1 = true;
		
	}
	
	
	



	}


