package com.Libre.Registration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CheckTest {
	@FindBy(xpath = Constants.ID_TYPE)
	MobileElement id_type;
	@FindBy(id = Constants.ID_TYPES)
	List<MobileElement> id_types;
	@FindBy(id = Constants.OFFICIAL_ID_NUMBER)
	MobileElement official_id_number;
	@FindBy(id = Constants.EXPIRATION_DATE)
	MobileElement expiration_date;
	@FindBy(xpath = Constants.ISSUING_COUNTRY)
	MobileElement issuing_country;
	@FindBy(id = Constants.DATE_INPUT)
	WebElement date_input;
	@FindBy(id = Constants.DONE)
	WebElement done;
	
	AndroidDriver driver;
	boolean isSuccess;
	
	
	@BeforeSuite()
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "HJF0D0EN");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.tenone.libre.registration");
		capabilities.setCapability("appActivity", "com.tenone.libre.activities.SplashActivity");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test()
	public void check() {
		id_type.click();
		official_id_number.click();
    	official_id_number.sendKeys("11111");
    	issuing_country.click();
    	MobileElement scrollToText = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Mexico\"));"));
    	scrollToText.click();
    	expiration_date.click();
    	date_input.sendKeys("2020");
    	done.click();	
	}

}
