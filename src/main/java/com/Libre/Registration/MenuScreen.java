package com.Libre.Registration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class MenuScreen {
	
	AndroidDriver driver;
	
	@FindBy(className = Constants.MENU_ICON)
	public static WebElement menu_icon;
	@FindBy(id = Constants.MENU_INSTALLATIONS)
	WebElement menu_installations;
	@FindBy(id = Constants.MENU_MY_PROFILE)
	WebElement menu_my_profile;
	@FindBy(id = Constants.MENU_HELP)
	WebElement menu_help;
	@FindBy(id = Constants.MENU_PRIVACY_POLICY)
	WebElement menu_privacy_policy;
	@FindBy(id = Constants.LOGOUT_BUTTON)
	public static WebElement logout_button;
	@FindBy(id = Constants.ROLE_NAME)
	public static WebElement role_name;
	@FindBy(id = Constants.MENU_INSTALLATIONS_OFFICER)
	WebElement menu_installations_officer;
	@FindBy(id = Constants.MENU_FACILITIES)
	public static WebElement menu_facilities;
	@FindBy(id = Constants.MENU_FACILITY_MANAGERS)
	WebElement menu_facility_managers;
	@FindBy(id = Constants.EDIT_PROFILE_TITLE)
	WebElement edit_profile_title;
	
	public MenuScreen(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void verifyInstallationOfficerMenuSections() {
		
		Assert.assertTrue(this.menu_installations.isDisplayed());
		Assert.assertTrue(this.menu_my_profile.isDisplayed());
		Assert.assertTrue(this.menu_privacy_policy.isDisplayed());
		Assert.assertTrue(this.menu_help.isDisplayed());
		Assert.assertTrue(this.logout_button.isDisplayed());

	}
	
	public void tapOnMenuIcon() {
		this.menu_icon.click();
	}
	
	public void verifyFacilityManagerMenuSection() {
		Assert.assertTrue(this.menu_installations_officer.isDisplayed());
		Assert.assertTrue(this.menu_installations.isDisplayed());
		Assert.assertTrue(this.menu_my_profile.isDisplayed());
		Assert.assertTrue(this.menu_privacy_policy.isDisplayed());
		Assert.assertTrue(this.menu_help.isDisplayed());
		Assert.assertTrue(this.logout_button.isDisplayed());
		
	}
	
	public void tapOnInstallationMenuSection() {
		this.menu_installations.click();
	}
	public void tapOnMyProfileSection() {
		this.menu_my_profile.click();
		Assert.assertTrue(this.edit_profile_title.isDisplayed());
	}
	public void tapOnInstallationOfficerMenuSection() {
		this.menu_installations_officer.click();
	}
	public void tapOnFacilityManagersMenuSection() {
		this.menu_facility_managers.click();
	}
	public void tapOnFacilitiesMenuSection() {
		this.menu_facilities.click();
	}

	public void verifySuperAdminAssistantMenuSections() {
		Assert.assertTrue(this.menu_installations_officer.isDisplayed());
		Assert.assertTrue(this.menu_installations.isDisplayed());
		Assert.assertTrue(this.menu_my_profile.isDisplayed());
		Assert.assertTrue(this.menu_privacy_policy.isDisplayed());
		Assert.assertTrue(this.menu_help.isDisplayed());
		Assert.assertTrue(this.logout_button.isDisplayed());
		Assert.assertTrue(this.menu_facilities.isDisplayed());
		Assert.assertTrue(this.menu_facility_managers.isDisplayed());	
	}
	public void verifySuperAdminMenuSections() {
		Assert.assertTrue(this.menu_installations_officer.isDisplayed());
		Assert.assertTrue(this.menu_installations.isDisplayed());
		Assert.assertTrue(this.menu_my_profile.isDisplayed());
		Assert.assertTrue(this.menu_privacy_policy.isDisplayed());
		Assert.assertTrue(this.menu_help.isDisplayed());
		Assert.assertTrue(this.logout_button.isDisplayed());
		Assert.assertTrue(this.menu_facilities.isDisplayed());
		Assert.assertTrue(this.menu_facility_managers.isDisplayed());	
	}
	
	public void verifySupervisorMenuSections() {
		Assert.assertTrue(this.menu_installations_officer.isDisplayed());
		Assert.assertTrue(this.menu_installations.isDisplayed());
		Assert.assertTrue(this.menu_my_profile.isDisplayed());
		Assert.assertTrue(this.menu_privacy_policy.isDisplayed());
		Assert.assertTrue(this.menu_help.isDisplayed());
		Assert.assertTrue(this.logout_button.isDisplayed());
		Assert.assertTrue(this.menu_facilities.isDisplayed());
		Assert.assertTrue(this.menu_facility_managers.isDisplayed());	
}

}
