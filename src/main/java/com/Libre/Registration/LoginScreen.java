package com.Libre.Registration;


import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;



public class LoginScreen {

	AndroidDriver driver;

	@FindBy(id = Constants.USERNAME_EMAIL)
	private WebElement email_field;
	@FindBy(id = Constants.PASSWORD_FIELD)
	private WebElement password_field;
	@FindBy(id = Constants.LOGIN_BUTTON)
	private WebElement login_button;
	@FindBy(className = Constants.LIBRE_ICON)
	private WebElement libre_icon;
	@FindBy(xpath = Constants.FORGOT_PASSWORD)
	private WebElement forgot_password;


	public LoginScreen(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public void elemtnsAreVisible(){
		Assert.assertTrue(this.libre_icon.isDisplayed());
		Assert.assertTrue(this.email_field.isDisplayed());
		Assert.assertTrue(this.password_field.isDisplayed());
		Assert.assertTrue(this.login_button.isDisplayed());


	}

	
	public boolean libreIconIsDisplayed(){
		return this.libre_icon.isDisplayed();	
	}
	

	public boolean emailFieldIsDisplayed(){
		return this.email_field.isDisplayed();	}

	public boolean passwordFieldIsDisplayed(){
		return this.password_field.isDisplayed();	}

	public boolean loginButtonIsDisplayed(){
		return this.login_button.isDisplayed();	}

	
	
	public void loginWithEmptyFIelds()
	{
		this.email_field.click();
		this.email_field.sendKeys("");
		driver.hideKeyboard();
		this.password_field.click();
		this.password_field.sendKeys("");
		driver.hideKeyboard();
		this.login_button.click();

	}

	public void emptyEmailField(){
		this.email_field.click();
		this.email_field.sendKeys("");
		driver.hideKeyboard();
		this.password_field.click();
		this.password_field.sendKeys("555555");
		driver.hideKeyboard();
		this.login_button.click();
	}

	public void emptyPasswordField()
	{
		this.email_field.click();
		this.email_field.sendKeys("jack_installation@mailinator.com");
		driver.hideKeyboard();
		this.password_field.clear();
		this.password_field.click();
		driver.hideKeyboard();
		this.login_button.click();


	}

	public void invalidMailFormat(){
		this.email_field.clear();
		this.email_field.click();
		String email[] = {"test.develandoo@", "test.develandoo@mailinator","test.develandoo@mailinator."};
		this.email_field.sendKeys(email[new Random().nextInt(email.length)]);
		driver.hideKeyboard();
		this.password_field.clear();
		this.password_field.click();
		this.password_field.sendKeys("555555");
		driver.hideKeyboard();
		this.login_button.click();

	}

	public void spacesInEmail(){
		this.email_field.clear();
		this.email_field.click();
		this.email_field.sendKeys("jack_ installation@maili nator.com");
		driver.hideKeyboard();
		this.password_field.clear();
		this.password_field.click();
		this.password_field.sendKeys("555555");
		driver.hideKeyboard();
		this.login_button.click();
	}

	

	public void successfulLoginWithValidEMailPassword(){
		this.email_field.click();
		this.email_field.clear();
		this.email_field.sendKeys("jack_installation@mailinator.com");
		driver.hideKeyboard();
		this.password_field.click();
		this.password_field.clear();
		this.password_field.sendKeys("555555");
		driver.hideKeyboard();
		this.login_button.click();
		Assert.assertTrue(MenuScreen.logout_button.isDisplayed());

	}

	public void spacesInPassword(){
		this.email_field.click();
		this.email_field.clear();
		this.email_field.sendKeys("jack_installation@mailinator.com");
		driver.hideKeyboard();
		this.password_field.click();
		this.password_field.clear();
		this.password_field.sendKeys("555 5 55");
		driver.hideKeyboard();
		this.login_button.click();
		Assert.assertTrue(MenuScreen.menu_icon.isDisplayed());
		
	}

	public void logout(){
		MenuScreen.menu_icon.click();
		MenuScreen.logout_button.click();
		Assert.assertTrue(login_button.isDisplayed());
	}
	public void autoLogin() throws InterruptedException {
		if(!Constants.MENU_ICON.isEmpty()) {
			driver.launchApp();
			Thread.sleep(5000);
		}
		else {
		this.email_field.click();
		this.email_field.clear();
		this.email_field.sendKeys("jack_installation@mailinator.com");
		driver.hideKeyboard();
		this.password_field.click();
		this.password_field.clear();
		this.password_field.sendKeys("555555");
		driver.hideKeyboard();
		this.login_button.click();
		Assert.assertTrue(MenuScreen.menu_icon.isDisplayed());
		Thread.sleep(5000);
		driver.launchApp();
		Thread.sleep(5000);
		}
	}
	
	public void verifyLoginAsIO() throws InterruptedException {
		
		this.email_field.click();
		this.email_field.clear();
		email_field.sendKeys("william_installation@mailinator.com");
		driver.hideKeyboard();
		this.password_field.click();
		this.password_field.clear();
		this.password_field.sendKeys("555555");
		driver.hideKeyboard();
		this.login_button.click();
		Thread.sleep(2000);
		MenuScreen menu = new MenuScreen(driver);
		menu.tapOnMenuIcon();
		Assert.assertEquals(MenuScreen.role_name.getText(), "Installation Officer");
		Assert.assertTrue(MenuScreen.menu_icon.isDisplayed());
		menu.tapOnMenuIcon();
	}
	public void verifyLoginAsFM() throws InterruptedException {
		this.email_field.click();
		this.email_field.clear();
		this.email_field.sendKeys("will_facility@mailinator.com");
		driver.hideKeyboard();
		this.password_field.click();
		this.password_field.clear();
		this.password_field.sendKeys("333333");
		driver.hideKeyboard();
		this.login_button.click();
		Thread.sleep(2000);
		MenuScreen menu = new MenuScreen(driver);
		Assert.assertTrue(MenuScreen.menu_icon.isDisplayed());
		menu.tapOnMenuIcon();
		Assert.assertEquals(MenuScreen.role_name.getText(), "Facility Manager");
		
	}
	
	public void verifyLoginAsSAA() throws InterruptedException {
		this.email_field.click();
		this.email_field.clear();
		this.email_field.sendKeys("jane_assist@mailinator.com");
		driver.hideKeyboard();
		this.password_field.click();
		this.password_field.clear();
		this.password_field.sendKeys("222222");
		driver.hideKeyboard();
		this.login_button.click();
		Thread.sleep(2000);
		MenuScreen menu = new MenuScreen(driver);
		Assert.assertTrue(MenuScreen.menu_icon.isDisplayed());
		menu.tapOnMenuIcon();
		Assert.assertEquals(MenuScreen.role_name.getText(), "Super Admin Assistant");
		
	}
	public void verifyLoginAsSA() throws InterruptedException {
		this.email_field.click();
		this.email_field.clear();
		this.email_field.sendKeys("joy12@mailinator.com");
		driver.hideKeyboard();
		this.password_field.click();
		this.password_field.clear();
		this.password_field.sendKeys("12345678");
		driver.hideKeyboard();
		this.login_button.click();
		Thread.sleep(2000);
		MenuScreen menu = new MenuScreen(driver);
		Assert.assertTrue(MenuScreen.menu_icon.isDisplayed());
		menu.tapOnMenuIcon();
		Assert.assertEquals(MenuScreen.role_name.getText(), "Super Admin");
		
	}
	public void verifyLoginAsSV() throws InterruptedException {
		this.email_field.click();
		this.email_field.clear();
		this.email_field.sendKeys("mia_supervisor@mailinator.com");
		driver.hideKeyboard();
		this.password_field.click();
		this.password_field.clear();
		this.password_field.sendKeys("444444");
		driver.hideKeyboard();
		this.login_button.click();
		Thread.sleep(2000);
		MenuScreen menu = new MenuScreen(driver);
		Assert.assertTrue(MenuScreen.menu_icon.isDisplayed());
		menu.tapOnMenuIcon();
		Assert.assertEquals(MenuScreen.role_name.getText(), "Supervisor");
	}	

}
