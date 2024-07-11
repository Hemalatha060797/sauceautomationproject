package com.SauceDemoProject.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Assert;
public class UpdatePasswordPage {
	
	WebDriver ldriver;
	WebDriver driver;
	JavascriptExecutor js;
	public static WebDriverWait wait;
	public UpdatePasswordPage(WebDriver driver) {
    	ldriver= driver;
		PageFactory.initElements(driver, this);	
	}

	
	//Profile
	@FindBy(xpath="(//button[@class='dropdown-item py-1-custom pl-2 pr-5 primary font-semi-bold drop-border'])[1]")
	@CacheLookup
	WebElement profile;
	
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
	
	@FindBy(xpath="//div[text()=' Password changed successfully ']")
	@CacheLookup
	WebElement successmsg;
	
	@FindBy(xpath="(//div[@class='btn-group dropleft dropdown'])[2]")
	@CacheLookup
	WebElement userProfileImage;
	
	public void profile(int intvalue) {
		
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		wait.until(ExpectedConditions.visibilityOf(profile));
		profile.click();
	}
	
	public void successMessage(String uname) {
		String text = successmsg.getText();
		System.out.println(text);
		Assert.assertEquals(text, uname);
	}
	
	public void updatePassword(int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		wait.until(ExpectedConditions.visibilityOf(updatepassword));
		updatepassword.click();
	}
	
	public void oldPassword(String oldpass, int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		wait.until(ExpectedConditions.visibilityOf(oldPassword));
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
	
//	public void userProfImage(int intvalue) {
//		try {
//		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
//		WebElement userImageProfile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='dropdown-toggle img-fluid pointer ml-md-2 h-100 rounded-circle profile-image ng-star-inserted']")));
//		js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click()", userImageProfile);
//		}
//		catch(Exception e) {
//			wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
//			WebElement userImageProf = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='btn-group dropleft dropdown'])[2]")));
//			js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click()", userImageProf);
//		}
		
	//}
	public void userProfImage(int intvalue) {
	   try {
	        wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
	        WebElement userImageProfile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='btn-group dropleft dropdown']/img)[2]")));
	        js = (JavascriptExecutor) ldriver;
	        js.executeScript("arguments[0].click()", userImageProfile);
	    } 
	   catch (Exception e) {
	         	
	            wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
	            WebElement userImageProf = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='btn-group dropleft dropdown']/img)[2]")));
	            js = (JavascriptExecutor) ldriver;
	            js.executeScript("arguments[0].click()", userImageProf);
	        } 
	
	}
	
	public WebElement getSavechangesBtn() {
		return savechangesBtn;
	
	}
	
	
	
	
	

}
