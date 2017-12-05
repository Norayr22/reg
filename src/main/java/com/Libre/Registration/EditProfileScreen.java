package com.Libre.Registration;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class EditProfileScreen {
	


	AndroidDriver driver;
		
		@FindBy(id = Constants.AVATAR)
	    WebElement avatar;
		@FindBy(id = Constants.NAME_FIELD)
		WebElement name_field;
	    @FindBy(id = Constants.TELEPHONE)
	    WebElement telephone;
	    @FindBy(id = Constants.CHANGE_PASSWORD)
	    WebElement change_password;
	    @FindBy(id = Constants.SAVE_)
	    WebElement save;
	    @FindBy(xpath = Constants.EDIT_SUCCESS_MESSAGE)
	    WebElement edit_success_message;
	    
		public EditProfileScreen(AndroidDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);

		}
		
	public void editNameOfUser() {
		this.name_field.click();
		this.name_field.sendKeys("1");
		this.save.click();
	    Assert.assertTrue(this.edit_success_message.isDisplayed());
	}
	
	public void editTelephoneOfUser() {
		this.telephone.click();
		this.telephone.sendKeys("1");
		this.save.click();
	    Assert.assertTrue(this.edit_success_message.isDisplayed());
	}

}
