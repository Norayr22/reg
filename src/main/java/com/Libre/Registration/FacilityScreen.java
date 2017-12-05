package com.Libre.Registration;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class FacilityScreen {
	AndroidDriver driver;

	@FindBy(xpath = Constants.FACILITY_TITLE)
	WebElement facility_title;
	@FindBy(id = Constants.NAME_FIELD_FOR_CREATE)
	WebElement name_field_for_create;
	@FindBy(className = Constants.CREATE_)
	List<WebElement> create_;
	@FindBy(id = Constants.FACILITY)
	List<WebElement> facility;
	@FindBy(id = Constants.EDIT_BUTTON)
	WebElement edit_button;
	@FindBy(id = Constants.ADDRESS_FIELD)
	WebElement address_field;
	@FindBy(id = Constants.SAVE_BUTTON)
    WebElement save_button;
	@FindBy(id = Constants.DELETE_BUTTON)
	WebElement delete_button;
	@FindBy(id = Constants.CANCEL_BUTTON)
	WebElement cancel_button;
	@FindBy(xpath = Constants.UPDATE_MESSAGE1)
	WebElement update_message1;
	@FindBy(className = Constants.BACK_BUTTON)
	List<WebElement> back_button;
	@FindBy(id = Constants.NON_WORKING_DAYS)
	WebElement non_working_days;
	@FindBy(id = Constants.START_TIME)
	WebElement start_time;
	@FindBy(id = Constants.GOOGLE_SEARCH)
	WebElement google_search;
	@FindBy(className = Constants.ADRESSES)
	List<WebElement> addresses;
	@FindBy(className = Constants.SELECT_DAY)
	List<WebElement> select_day;
	@FindBy(id = Constants.SELECT_BUTTON)
	WebElement select_button;
	@FindBy(xpath = Constants.SELECT_START_TIME)
	WebElement select_start_time;
	@FindBy(xpath = Constants.SELECT_END_TIME)
	WebElement select_end_time;
	@FindBy(id = Constants.SUBMIT_BUTTON)
	WebElement submit_button;
	@FindBy(id = Constants.SAVE)
    WebElement save;
	
	public FacilityScreen(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public void verifyFacilitiesList() {

		Assert.assertTrue(this.facility_title.isDisplayed());
	}

	public void tapOnCreateFacility() throws InterruptedException{
		
		this.create_.get(1).click();
		Assert.assertTrue(this.name_field_for_create.isDisplayed());
		int x = new Random().nextInt(999999);
		this.name_field_for_create.sendKeys("a"+x+"b");
		this.address_field.click();
		this.google_search.click();
		this.google_search.sendKeys("Mexico");
		Thread.sleep(3000);
		int y = new Random().nextInt(6);
		this.addresses.get(y).click();
		System.out.println(this.addresses.size());
		Thread.sleep(1000);
		this.non_working_days.click();
		this.select_day.get(y).click();
		this.select_button.click();
		this.start_time.click();
		this.select_start_time.click();
		Thread.sleep(1000);
		this.select_end_time.click();
		this.submit_button.click();
		Thread.sleep(1000);
		this.save.click();
	
	}

	public void verifyCreateButton() {
		Assert.assertTrue(this.create_.get(1).isDisplayed());
	}
	public void verifyReadOnlyMode() {
		Assert.assertTrue((Constants.CREATE_).isEmpty());
	}


	public void editFacility() {
		this.facility.get(1).click();
		this.edit_button.click();
		this.name_field_for_create.click();	
		String expected = this.name_field_for_create.getText();
		this.name_field_for_create.clear();
		int x = new Random().nextInt(999999);
		this.name_field_for_create.sendKeys(""+ x +"");
		driver.hideKeyboard();
		this.save.click();
		Assert.assertTrue(this.update_message1.isDisplayed());
		this.facility.get(1).click();
		String actual = this.name_field_for_create.getText();
		Assert.assertNotEquals(actual, expected);


	}

	public void cancelEditingFacility() {
		this.facility.get(1).click();
		this.edit_button.click();
		this.name_field_for_create.click();	
		String expected = this.name_field_for_create.getText();
		this.name_field_for_create.clear();
		int x = new Random().nextInt(999999);
		this.name_field_for_create.sendKeys(""+ x +"");
		driver.hideKeyboard();
		this.cancel_button.click();
		this.back_button.get(0).click();
		this.facility.get(1).click();
		String actual = this.name_field_for_create.getText();
		Assert.assertEquals(actual, expected);


	}



}
