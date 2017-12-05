package com.Libre.Registration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class InstallationOfficerTest {
	
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
//		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("deviceName", "CB512BDF07");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability(CapabilityType.VERSION, "4.4.4");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.tenone.libre.registration");
		capabilities.setCapability("appActivity", "com.tenone.libre.activities.SplashActivity");
//		capabilities.setCapability("skipUnlock", true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
/*	
	@Test(priority = 1)
	public void loginAsIOTest() throws InterruptedException {
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsIO();
		isSuccess = true;
		driver.closeApp();
	}
	
	@Test(priority = 2)
	public void verifyMenuSectionsTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsIO();
		MenuScreen menu = new MenuScreen(driver);
		menu.verifyInstallationOfficerMenuSections();	
		isSuccess1 = true;
		driver.closeApp();
		
	}
	@Test(priority = 3)
	public void verifyEditFMNameTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsIO();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnMyProfileSection();
		EditProfileScreen edit = new EditProfileScreen(driver);
		edit.editNameOfUser();
		isSuccess2 = true;
		driver.closeApp();
	}
	@Test(priority = 4)
	public void verifyEditFMTelephoneTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsIO();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnMyProfileSection();
		EditProfileScreen edit = new EditProfileScreen(driver);
		edit.editTelephoneOfUser();
		isSuccess3 = true;
		driver.closeApp();
	}
	
	@Test(priority = 5)
	public void verifyInstallationsListTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsIO();
		InstallationsScreen inst = new InstallationsScreen(driver);
		inst.verifyInstallationsList();
		isSuccess4 = true;
		driver.closeApp();
		
	}
*/	
	@Test(priority = 6)
	public void verifyCreateInstallationFunctionTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsIO();
		InstallationsScreen inst = new InstallationsScreen(driver);
		inst.verifyInstallationsList();
		inst.tapOnCreateInstallation();
		isSuccess5 = true;
//		driver.closeApp();
	}

}
