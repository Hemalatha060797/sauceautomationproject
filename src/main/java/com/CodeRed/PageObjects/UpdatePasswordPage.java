package com.CodeRed.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdatePasswordPage {
	
	WebDriver ldriver;
	WebDriver driver;
	JavascriptExecutor js;
   
	public UpdatePasswordPage(WebDriver rdriver) {
    	ldriver= rdriver;
		PageFactory.initElements(rdriver, this);	
	}

	//Login Button
	@FindBy(xpath="(//a[text()='Login'])[1]")
	@CacheLookup
	WebElement loginButton;
	
	//Username
	@FindBy(xpath="//input[@type='email']")
	@CacheLookup
	WebElement txtUsername;

	//Password
	@FindBy(xpath="//input[@type='password']")
	@CacheLookup
	WebElement txtPassword;
	
	//login 
	@FindBy(xpath="//span[text()=' Login ']")
	@CacheLookup
	WebElement clkLogin;

	//UserProfile
	@FindBy(xpath="(//div[@class='btn-group dropleft dropdown']//img)[2]")
	@CacheLookup
	WebElement userProfile;
	
	//Account Settings
	@FindBy(xpath="(//button[text()='Account Settings'])[2]")
	@CacheLookup
	WebElement actsettings;
	
	//Update Password
	@FindBy(xpath="//span[text()='Update Password']")
	@CacheLookup
	WebElement updatepassword;
	
	//Old Password
	@FindBy(xpath="//input[@placeholder='Enter Your Old Password']")
	@CacheLookup
	WebElement oldPassword;
	
	//New Password
	@FindBy(xpath="//input[@placeholder='Enter Your New Password']")
	@CacheLookup
	WebElement newPassword;
	
	//Confirm Password
	@FindBy(xpath="//input[@placeholder='Confirm  Password']")
	@CacheLookup
	WebElement confirmPassword;
	
	//Save Changes Button
	@FindBy(xpath="//span[text()=' Save Changes ']")
	@CacheLookup
	WebElement savechangesBtn;
	
	@FindBy(xpath="(//button[text()='Log Out'])[2]")
	@CacheLookup
	WebElement btnLogout;
	
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void setUsername(String uname) {
		txtUsername.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		clkLogin.click();
	}
	
	public void usrProfile() {
		userProfile.click();
	}
	
	public void actSettings() {
		actsettings.click();
	}
	
	public void updatePassword() {
		updatepassword.click();
	}
	
	public void oldPassword(String oldpass) {
		oldPassword.sendKeys(oldpass);
	}
	
	public void newPassword(String newpass) {
		newPassword.sendKeys(newpass);
	}
	
	public void confirmPassword(String cnfrmpass) {
		confirmPassword.sendKeys(cnfrmpass);
	}
	
	public void savechangesBtn() {
		savechangesBtn.click();
	}
	
	public void btnLogout() {
		btnLogout.click();
	}
	
	
	
	
	

}
