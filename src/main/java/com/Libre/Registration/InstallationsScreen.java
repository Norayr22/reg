package com.Libre.Registration;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;


public class InstallationsScreen {

	AndroidDriver driver;

	@FindBy(id = Constants.INSTALLATION_TITLE)
	public static WebElement installations_title;
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
	@FindBy(id = Constants.CREATE)
	WebElement create;
	@FindBy(id = Constants.LICENSE_PLATE_FIELD)
	WebElement license_plate_field;
	@FindBy(id = Constants.SUBMIT)
	WebElement submit;
	@FindBy(xpath = Constants.VEHICLE_DATA_TITLE)
	WebElement vehicle_data_title;
	@FindBy(id = Constants.NEXT_BUTTON)
	WebElement next_button;
	@FindBy(id = Constants.TEST)
	List<WebElement> test;
	@FindBy(id = Constants.PASS_BUTTON)
	WebElement pass_button;
	@FindBy(id = Constants.SUBMIT_TEST)
	WebElement submit_test;
	@FindBy(id = Constants.LICENSE_NUMBER)
	WebElement license_number;
	@FindBy(id = Constants.SUBMIT_LICENSE_NUMBER)
	WebElement submit_license_number;
	@FindBy(xpath = Constants.LICENSE_DATA)
	WebElement license_data;
	@FindBy(id = Constants.ATTACH_PHOTO_BUTTON)
	WebElement attach_photo_button;
	@FindBy(id = Constants.TAKE_PHOTO_BUTTON)
	WebElement take_photo_button;
	@FindBy(id = Constants.DONE_BUTTON)
	WebElement done_button;
	@FindBy(xpath = Constants.LICENSE_PLATE_ERROR_MESSAGE)
	List<WebElement> license_plate_error_message;
	@FindBy(id = Constants.OK_BUTTON)
	WebElement ok_button;
	@FindBy(id = Constants.MAKE)
	WebElement make;
	@FindBy(id = Constants.MODEL)
	WebElement model;
	@FindBy(id = Constants.MODEL_YEAR)
	WebElement model_year;
	@FindBy(id = Constants.VIN)
	WebElement vin;
	@FindBy(id = Constants.LICENSE_FULL_NAME)
	WebElement license_full_name;
	@FindBy(id = Constants.LICENSE_EXPIRATION_DATE)
	WebElement license_expiration_date;
	@FindBy(xpath = Constants.DATE2)
	WebElement date2;
	@FindBy(xpath = Constants.DATE1)
	WebElement date1;
	@FindBy(id = Constants.DONE)
	WebElement done;
	@FindBy(id = Constants.DATE_OF_BIRTH)
	WebElement date_of_birth;
	@FindBy(id = Constants.AVATAR)
	WebElement avatar;
	@FindBy(xpath = Constants.DATE_INPUT)
	WebElement date_input;
	@FindBy(id = Constants.EMAIL)
	WebElement email;
	@FindBy(id = Constants.BIRTH_STATE)
	WebElement birth_state;
	@FindBy(id = Constants.STATES)
	List<WebElement> states;
	@FindBy(xpath = Constants.GENDER)
	WebElement gender;
	@FindBy(id = Constants.GENDERS)
	List<WebElement> genders;
	@FindBy(id = Constants.TELEPHONE_MOBILE)
	WebElement telephone_mobile;
	@FindBy(xpath = Constants.ID_TYPE)
	WebElement id_type;
	@FindBy(id = Constants.ID_TYPES)
	List<WebElement> id_types;
	@FindBy(id = Constants.OFFICIAL_ID_NUMBER)
	WebElement official_id_number;
	@FindBy(id = Constants.EXPIRATION_DATE)
	WebElement expiration_date;
	@FindBy(xpath = Constants.ISSUING_COUNTRY)
	WebElement issuing_country;
	@FindBy(xpath = Constants.PASSPORT)
	WebElement passport;
	

	
	
	public InstallationsScreen(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void verifyInstallationsList() {
		Assert.assertTrue(this.installations_title.isDisplayed());
	}

	public void tapOnCreateInstallation() throws InterruptedException {
		this.create.click();
		Assert.assertTrue(this.license_plate_field.isDisplayed());
		this.license_plate_field.click();
		String plate[] = {"B00022", "B00023","B00024","B00025", "B00026"};
		String number = plate[new Random().nextInt(plate.length)];
		this.license_plate_field.sendKeys("B00023");
		plate = ArrayUtils.removeElement(plate, number);
		this.submit.click();

		if(!license_plate_error_message.isEmpty()) {
			this.ok_button.click();
		    Assert.assertTrue(this.vehicle_data_title.isDisplayed());
		    this.make.click();
		    this.make.sendKeys("Kia");
		    this.model.click();
		    this.model.sendKeys("Forte");
		    this.model_year.click();
		    this.model_year.sendKeys("2010");
		    int x = new Random().nextInt(999999999);
		    this.vin.click();
		    this.vin.sendKeys("WBD"+x+"");
		    this.next_button.click();
		    }
		else {
			Assert.assertTrue(this.vehicle_data_title.isDisplayed());
			if(this.make.getText().isEmpty()) {
				this.make.click();
				this.make.sendKeys("Kia");
				}
			if(this.model.getText().isEmpty()) {
				this.model.click();
				this.model.sendKeys("Forte");
				}
			if(this.model_year.getText().isEmpty()) {
				this.model_year.click();
				this.model_year.sendKeys("2010");
				}
			if(this.vin.getText().isEmpty()) {
				int x = new Random().nextInt(999999999);
				this.vin.click();
				this.vin.sendKeys("WBD"+x+"");
				}
			this.next_button.click();
		}
			
		new TouchAction((MobileDriver)driver).longPress(this.test.get(0)).moveTo(16, 105).release().perform();
		Thread.sleep(1000);
		this.pass_button.click();
		this.submit_test.click();
		Thread.sleep(1000);
		this.license_number.click();
		int y = new Random().nextInt(99999);
		this.license_number.sendKeys("2"+y+"");
		this.submit_license_number.click();
		Assert.assertTrue(this.license_data.isDisplayed());
		
		if(this.license_full_name.getText().isEmpty()) {
			this.license_full_name.click();
			this.license_full_name.sendKeys("Morales Fonseca");
			}
		if(this.license_expiration_date.getText().isEmpty()) {
			this.license_expiration_date.click();
			new TouchAction((MobileDriver)driver).longPress(this.date2).moveTo(this.date1).release().perform();
			this.done.click();
			}
		
		this.next_button.click();
		new TouchAction((MobileDriver)driver).longPress(this.test.get(1)).moveTo(16, 185).release().perform();
		this.pass_button.click();
		this.attach_photo_button.click();
		Thread.sleep(2000);
		this.take_photo_button.click();
		Thread.sleep(1000);
		this.done_button.click();
		this.submit_test.click();
		Thread.sleep(2000);
		
		Assert.assertTrue(avatar.isDisplayed());
		date_of_birth.click();
		date_input.click();
		date_input.clear();
	    date_input.sendKeys("1957");		
	    done.click();
	    email.click();
	    email.sendKeys("test"+y+"");
	    birth_state.click();
	    states.get(new Random().nextInt(10)+1).click();
	    gender.click();
	    int i =	(int)(Math.random() * ((2-1)+1) + 1);
	    genders.get(i).click();
	    telephone_mobile.click();
	    telephone_mobile.sendKeys("+52155"+ y + "");
	    driver.hideKeyboard();
	    id_type.click();
	    int id =	(int)(Math.random() * ((3-1)+1) + 1);
	    id_types.get(id).click();
	    if(id == 3) {
	    	official_id_number.click();
	    	official_id_number.sendKeys(""+y+"");
	    	expiration_date.click();
	    	date_input.click();
	    	date_input.sendKeys("2020");
	    	done.click();
	    }
	   	else {
	   		official_id_number.click();
	    	official_id_number.sendKeys(""+y+"");
	    	issuing_country.click();
	    	MobileElement scrollToText = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Mexico\"));"));
	    	scrollToText.click();
	    	expiration_date.click();
	    	date_input.click();
	    	date_input.sendKeys("2020");
	    	done.click();	
	    		
	    	}
	    	
	    	
	    	
	}
	    	
	    	
	    	
	    
	    
	    
	    
	    










	public void verifyReadOnlyMode() {
		Assert.assertTrue((Constants.CREATE).isEmpty());
	}
}
