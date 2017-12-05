package com.Libre.Registration;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class InstallationOfficerScreen {
	
AndroidDriver driver;
	
	@FindBy(xpath = Constants.INSTALLATION_OFFICER_TITLE)
    WebElement installation_officer_title;
	@FindBy(id = Constants.NAME_FIELD_FOR_CREATE)
	WebElement name_field_for_create;
    @FindBy(className = Constants.CREATE_)
    List<WebElement> create_;
	@FindBy(id = Constants.INSTALLATION_OFFICER)
	List<WebElement> installation_officer;
	@FindBy(id = Constants.EDIT_BUTTON)
	WebElement edit_button;
	@FindBy(id = Constants.PHONE_NUMBER)
	WebElement phone_number;
	@FindBy(id = Constants.SAVE_BUTTON)
	public static WebElement save_button;
	@FindBy(id = Constants.DELETE_BUTTON)
	WebElement delete_button;
	@FindBy(id = Constants.CANCEL_BUTTON)
	WebElement cancel_button;
	@FindBy(xpath = Constants.UPDATE_MESSAGE)
	WebElement update_message;
	@FindBy(className = Constants.BACK_BUTTON)
	List<WebElement> back_button;
	@FindBy(id = Constants.CONFIRM_DELETE)
	WebElement confirm_delete;
	@FindBy(id = Constants.CHOOSE_FACILITY)
	WebElement choose_facility;
	@FindBy(id = Constants.EMAIL_FIELD)
	WebElement email_field;
	@FindBy(id = Constants.FACILITIES)
	List<WebElement> facilities;
	
	public InstallationOfficerScreen(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void verifyInstallationOfficersList() {
		
		Assert.assertTrue(this.installation_officer_title.isDisplayed());
	}
	
	public void tapOnCreateInstallationOfficer() throws InterruptedException{
		this.create_.get(1).click();
		Assert.assertTrue(this.name_field_for_create.isDisplayed());
		this.choose_facility.click();
		Thread.sleep(2000);
		int y = new Random().nextInt(5)+1;
		this.facilities.get(y).click();
		this.name_field_for_create.click();
		int x = new Random().nextInt(999999);
		this.name_field_for_create.sendKeys("Test"+x+"");
		this.phone_number.sendKeys("+37455"+ x + "");
		this.email_field.click();
		this.email_field.sendKeys("test"+x+"@malinator.com");
		this.save_button.click();
	}
	
	
	public void verifyCreateButton() {
		Assert.assertTrue(this.create_.get(1).isDisplayed());
	}
	public void verifyReadOnlyMode() {
		Assert.assertTrue((Constants.CREATE_).isEmpty());
	}

	public void editInstallationOfficer() {
	    this.installation_officer.get(1).click();
	    this.edit_button.click();
	    this.phone_number.click();	
	    String expected = this.phone_number.getText();
	    this.phone_number.clear();
	    int x = new Random().nextInt(999999);
	    this.phone_number.sendKeys("+37455"+ x + "");
	    this.save_button.click();
	    Assert.assertTrue(this.update_message.isDisplayed());
	    this.installation_officer.get(1).click();
	    String actual = this.phone_number.getText();
	    Assert.assertNotEquals(actual, expected);
	    
	    
	}

	public void cancelEditingInstallationOfficer() {
	    this.installation_officer.get(1).click();
	    this.edit_button.click();
	    this.phone_number.click();	
	    String expected = this.phone_number.getText();
	    this.phone_number.clear();
	    int x = new Random().nextInt(999999);
	    this.phone_number.sendKeys("+37455"+ x + "");
	    this.cancel_button.click();
	    this.back_button.get(0).click();
	    this.installation_officer.get(1).click();
	    String actual = this.phone_number.getText();
	    Assert.assertEquals(actual, expected);
	    
	    
	}
	
	public void deleteInstallationOfficer() {
		String expected = this.installation_officer.get(7).getText();
	    this.installation_officer.get(7).click();
	    this.edit_button.click();
	    this.delete_button.click();
	    this.confirm_delete.click();
	    String actual = this.installation_officer.get(7).getText();
	    Assert.assertNotEquals(actual, expected);
	    
	    
	}


}
