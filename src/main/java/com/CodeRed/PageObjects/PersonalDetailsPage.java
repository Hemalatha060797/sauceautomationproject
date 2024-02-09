package com.CodeRed.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage {
	
	WebDriver ldriver;
	WebDriver driver;
	JavascriptExecutor js;
   
	public PersonalDetailsPage(WebDriver rdriver) {
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
	
	//Personal Details
	@FindBy(xpath="//span[text()='Personal Details']")
	@CacheLookup
	WebElement personaldetails;
	
	//First Name
	@FindBy(xpath="//input[@placeholder='First Name']")
	@CacheLookup
	WebElement firstname;
	
	//Last Name
	@FindBy(xpath="(//input[@type='text'])[2]")
	@CacheLookup
	WebElement lastname;
	
	//Email
	@FindBy(xpath="//input[@placeholder='Email']")
	@CacheLookup
	WebElement emailid;
	
	//Mobile
	@FindBy(xpath="//input[@placeholder='Mobile']")
	@CacheLookup
	WebElement mobilenum;
	
	@FindBy(xpath="//select[@id='7fad60cc-a580-4c5c-9bb4-f3636f54819e']")
	@CacheLookup
	WebElement clkDropDown;
	
	
	
//	//Display name
//	@FindBy(xpath="//input[@placeholder='Display Name']")
//	@CacheLookup
//	WebElement displayname;
	
	//Verify your current password
	@FindBy(xpath="//input[@placeholder='enter your password ...']")
	@CacheLookup
	WebElement currentpassword;
	
	//Save Changes Button
	@FindBy(xpath="//span[text()=' Save Changes ']")
	@CacheLookup
	WebElement savechangesBtn;
	
	//Logout
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
	
	public void personalDetails() {
		personaldetails.click();
	}
	
	public void firstName(String fstname) {
		firstname.clear();
		firstname.sendKeys(fstname);
	}
	
	public void lastName(String lstname) {
		lastname.sendKeys(lstname);
	}
	
	public void emailId(String email) {
		emailid.clear();
		emailid.sendKeys(email);
	}
	
	public void mobileNum(String mobile) {
		mobilenum.sendKeys(mobile);
	}
	
	public void countryName(String country) throws InterruptedException {
		clkDropDown.sendKeys(country);
		
	}
	
//	public void displayname(String oldpass) {
//		countryname.sendKeys(oldpass);
//	}
	
	public void currentPassword(String crntpass) {
		currentpassword.sendKeys(crntpass);
	}
	
	public void savechangesBtn() {
		savechangesBtn.click();
	}
	
	public void btnLogout() {
		btnLogout.click();
	}

}
