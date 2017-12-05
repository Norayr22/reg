package com.Libre.Registration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class SuperAdminTest {

	AndroidDriver driver;
	boolean isSuccess;
	boolean isSuccess1;
	boolean isSuccess2;
	boolean isSuccess3;
	boolean isSuccess4;
	boolean isSuccess5;
	boolean isSuccess6;
    boolean isSuccess7;
    boolean isSuccess8;
	boolean isSuccess9;
	boolean isSuccess10;
	boolean isSuccess11;
	boolean isSuccess12;
	boolean isSuccess13;
	boolean isSuccess14;
    boolean isSuccess15;
    boolean isSuccess16;
    boolean isSuccess17;
    
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
	public void loginAsSATest() throws InterruptedException {
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSA();
		isSuccess = true;
		driver.closeApp();

	}
	@Test(priority = 2)
	public void verifyMenuSectionsTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSA();
		MenuScreen menu = new MenuScreen(driver);
		menu.verifySuperAdminMenuSections();	
		isSuccess1 = true;
		driver.closeApp();
	}
	
	@Test(priority = 3)
	public void verifyEditFMNameTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSA();
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
		login.verifyLoginAsSA();
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
		login.verifyLoginAsSA();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnInstallationMenuSection();
		InstallationsScreen inst = new InstallationsScreen(driver);
		inst.verifyInstallationsList();
		isSuccess4 = true;
		driver.closeApp();

	}
	@Test(priority = 4)
	public void verifyInstallationOfficersListTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSA();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnInstallationOfficerMenuSection();
		InstallationOfficerScreen io = new InstallationOfficerScreen(driver);
		io.verifyInstallationOfficersList();
		io.verifyCreateButton();
		isSuccess3 = true;
		driver.closeApp();
	}
	
	@Test(priority = 5)
	public void verifyCreateInstallationFunctionTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSA();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnInstallationOfficerMenuSection();
		InstallationOfficerScreen instoff = new InstallationOfficerScreen(driver);
		instoff.verifyInstallationOfficersList();
		instoff.tapOnCreateInstallationOfficer();
		isSuccess4 = true;
		driver.closeApp();
}
	@Test(priority = 6)
	public void VerifyEditFunctionalityForIO() throws InterruptedException {
     	driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSA();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnInstallationOfficerMenuSection();
		InstallationOfficerScreen instoff = new InstallationOfficerScreen(driver);
		instoff.verifyInstallationOfficersList();
		instoff.editInstallationOfficer();
		isSuccess5 = true;
		driver.closeApp();
}
	@Test(priority = 7)
	public void VerifyCancelEditingFunctionalityForIO() throws InterruptedException {
     	driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSA();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnInstallationOfficerMenuSection();
		InstallationOfficerScreen instoff = new InstallationOfficerScreen(driver);
		instoff.verifyInstallationOfficersList();
		instoff.cancelEditingInstallationOfficer();
		isSuccess6 = true;
		driver.closeApp();
}
	@Test(priority = 8)
	public void VerifyDeleteFunctionalityForIO() throws InterruptedException {
     	driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSA();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnInstallationOfficerMenuSection();
		InstallationOfficerScreen instoff = new InstallationOfficerScreen(driver);
		instoff.verifyInstallationOfficersList();
		instoff.deleteInstallationOfficer();
		isSuccess7 = true;
		driver.closeApp();
}
	@Test(priority = 9)
	public void verifyFacilityManagersListTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSA();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnFacilityManagersMenuSection();
		FacilityManagersScreen fm = new FacilityManagersScreen(driver);
		fm.verifyFacilityManagersList();
		fm.verifyCreateButton();
		isSuccess8 = true;
		driver.closeApp();	
	}
	
	@Test(priority = 10)
	public void verifyCreateFacilityManagerFunctionTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSA();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnFacilityManagersMenuSection();
		FacilityManagersScreen fm = new FacilityManagersScreen(driver);
		fm.verifyFacilityManagersList();
		fm.tapOnCreateFacilityManager();
		isSuccess9 = true;
		driver.closeApp();
}
	@Test(priority = 11)
	public void verifyEditFunctionalityForFM() throws InterruptedException {
     	driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSA();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnFacilityManagersMenuSection();
		FacilityManagersScreen fm = new FacilityManagersScreen(driver);
		fm.verifyFacilityManagersList();
		fm.editFacilityManager();
		isSuccess10 = true;
		driver.closeApp();
}
	@Test(priority = 12)
	public void verifyCancelEditingFunctionalityForFM() throws InterruptedException {
     	driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSA();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnFacilityManagersMenuSection();
		FacilityManagersScreen fm = new FacilityManagersScreen(driver);
		fm.verifyFacilityManagersList();
		fm.cancelEditingFacilityManager();
		isSuccess11 = true;
		driver.closeApp();
}
	@Test(priority = 13)
	public void verifyDeleteFunctionalityForFM() throws InterruptedException {
     	driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSA();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnFacilityManagersMenuSection();
		FacilityManagersScreen fm = new FacilityManagersScreen(driver);
		fm.verifyFacilityManagersList();
		fm.deleteFacilityManager();
		isSuccess12 = true;
		driver.closeApp();
}
	@Test(priority = 14)
	public void verifyFacilitiesListTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSA();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnFacilitiesMenuSection();
		FacilityScreen facility = new FacilityScreen(driver);
		facility.verifyFacilitiesList();
		facility.verifyCreateButton();
		isSuccess13 = true;
		driver.closeApp();	
	}
	
	@Test(priority = 15)
	public void verifyCreateFacilityFunctionTest() throws InterruptedException {
		driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSA();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnFacilitiesMenuSection();
		FacilityScreen facility = new FacilityScreen(driver);
		facility.verifyFacilitiesList();
		facility.tapOnCreateFacility();
		isSuccess14 = true;
		driver.closeApp();
}
	@Test(priority = 16)
	public void verifyEditFunctionalityForFacility() throws InterruptedException {
     	driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSA();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnFacilitiesMenuSection();
		FacilityScreen facility = new FacilityScreen(driver);
		facility.verifyFacilitiesList();
		facility.editFacility();
		isSuccess15 = true;
		driver.closeApp();
}
	@Test(priority = 17)
	public void verifyCancelEditingFunctionalityForFacility() throws InterruptedException {
     	driver.launchApp();
		LoginScreen login = new LoginScreen(driver);
		login.verifyLoginAsSA();
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnFacilitiesMenuSection();
		FacilityScreen facility = new FacilityScreen(driver);
		facility.verifyFacilitiesList();
		facility.cancelEditingFacility();
		isSuccess16 = true;
		driver.closeApp();
}

	
}