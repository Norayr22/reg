package com.Libre.Registration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class SuperAdminScreen {
	
	
AndroidDriver driver;
	
	@FindBy(xpath = Constants.INSTALLATION_OFFICER_TITLE)
	public static WebElement installation_officer_title;
	@FindBy(id = Constants.NAME_FIELD_FOR_CREATE)
	WebElement name_field_for_create;
	
	public SuperAdminScreen(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	

}
