package com.Libre.Registration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class SupervisorTest {
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
	public void loginAsSVTest() throws InterruptedException {
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSV();
		isSuccess = true;
		driver.closeApp();
	}
	@Test(priority = 2)
	public void verifyMenuSectionsTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSV();
		MenuScreen menu = new MenuScreen(driver);
		menu.verifySupervisorMenuSections();	
		isSuccess1 = true;
		driver.closeApp();

	}
	
	@Test(priority = 3)
	public void verifyEditFMNameTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSV();
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
		login.verifyLoginAsSV();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnMyProfileSection();
		EditProfileScreen edit = new EditProfileScreen(driver);
		edit.editTelephoneOfUser();
		isSuccess3 = true;
		driver.closeApp();
	}
	@Test(priority = 3)
	public void verifyInstallationsListTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSV();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnInstallationMenuSection();
		InstallationsScreen inst = new InstallationsScreen(driver);
		inst.verifyInstallationsList();
		inst.verifyReadOnlyMode();
		isSuccess2 = true;
		driver.closeApp();
	}
	@Test(priority = 4)
	public void verifyInstallationOfficersListTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSV();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnInstallationOfficerMenuSection();
		InstallationOfficerScreen io = new InstallationOfficerScreen(driver);
		io.verifyInstallationOfficersList();
		io.verifyReadOnlyMode();
		isSuccess3 = true;
		driver.closeApp();
	}
	
	@Test(priority = 5)
	public void verifyFacilityManagersListTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSV();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnFacilityManagersMenuSection();
		FacilityManagersScreen fm = new FacilityManagersScreen(driver);
		fm.verifyFacilityManagersList();
		fm.verifyReadOnlyMode();
		isSuccess4 = true;
		driver.closeApp();	
	}
	@Test(priority = 6)
	public void verifyFacilitiesListTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSAA();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnFacilitiesMenuSection();
		FacilityScreen facility = new FacilityScreen(driver);
		facility.verifyFacilitiesList();
		facility.verifyReadOnlyMode();
		isSuccess5 = true;
		driver.closeApp();	
	}
}