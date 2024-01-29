package com.CodeRed.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginLogoutPage {

		WebDriver ldriver;
		WebDriver driver;
		JavascriptExecutor js;
	   
		public LoginLogoutPage(WebDriver rdriver) {
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
		@FindBy(xpath="//span[text()=' Log in ']")
		@CacheLookup
		WebElement clkLogin;
		
	
		@FindBy(xpath="//img[@class='dropdown-toggle img-fluid pointer ml-md-2 h-100 rounded-circle profile-image ng-star-inserted']")
		@CacheLookup
		WebElement userImage;
		
		
		
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
		public void userImage() {
			userImage.click();
		}
		public void btnLogout() {
			btnLogout.click();
		}
		
		
		
		
		
		
		
}
