package com.CodeRed.TestCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.CodeRed.PageObjects.UpdatePasswordPage;

import com.CodeRed.Utilities.BaseClassNew;

import io.percy.selenium.Percy;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TC_UpdatePasswordPercy_007 extends BaseClassNew{
	
	@Test(priority = 0, description = "Password Update", dataProvider = "UpdatePasswordMinLen", dataProviderClass = BaseClassNew.class)
	@Severity(SeverityLevel.CRITICAL)

	public void updatePasswordMinLen(String User, String Pass, String oldpass, String newpass, String cnfrmpass) throws InterruptedException {
		launchUrl();
		logger.info("Url is Opened");
		maxWindow();
		toHold(8000);
		
		Percy percy = new Percy(driver);
		
		UpdatePasswordPage lp = new UpdatePasswordPage(driver);
		
		lp.clickLoginButton();
		logger.info("Clicked on Login Button");
		toHold(8000);
		
		lp.setUsername(User);
		logger.info("Passed Username in UserField");
	    toHold(5000);
	    
	    lp.setPassword(Pass);
		logger.info("Passed Password in PwdField");
	    toHold(5000);  
	    
	    lp.clickLogin();
	    logger.info("Clicked on Login Button");
	    toHold(8000);
	    
	   
			if (driver.getCurrentUrl().equals(rbn.getString("HomeURL"))) {
				Assert.assertTrue(true);
				logger.info("Login Test is Passed");
				toHold(8000);
			}

			else {

				Assert.assertFalse(false);
				logger.info("Login Test is Failed");
				toHold(8000);
			}
			
		percy.snapshot("Home Page");
		lp.usrProfile();
		logger.info("Passed clicking on user profile");
		toHold(5000);
		
		lp.actSettings();
		logger.info("Passed clicking on account settings");
		toHold(5000);

		percy.snapshot("act Settings Page");	
		
		lp.updatePassword();
		logger.info("Passed clicking on update password");
		toHold(5000);
		
		lp.oldPassword(oldpass);
		logger.info("Passed Old Password in PwdField");
		toHold(5000);
		
		lp.newPassword(newpass);
		logger.info("Passed New Password in PwdField");
		toHold(5000);
		
		lp.confirmPassword(cnfrmpass);
		logger.info("Passed confirm Password in confirmPwdField");
		toHold(5000);
		
		lp.savechangesBtn();
	    logger.info("Clicked on save button Button");
	    toHold(8000);
	    
	    percy.snapshot("Update Password");
	    
		if (driver.findElement(By.xpath("//div[text()=' Password changed successfully ']")).equals("Password changed successfully")) {
				Assert.assertTrue(true);
				logger.info("password changed successfully");
				toHold(8000);
			}

			else {

				Assert.assertFalse(false);
				logger.info("change password is failed");
				toHold(8000);
			}
			
			toHold(8000);
			lp.usrProfile();
			logger.info("Clicked on User Profile ");
			Thread.sleep(2000);
			lp.btnLogout();
			logger.info("Clicked on Logout");
	
	    }
	
	@Test(priority = 1, description = "Password Update with max length", dataProvider = "UpdatePasswordMaxLen", dataProviderClass = BaseClassNew.class)
	@Severity(SeverityLevel.CRITICAL)

	public void updatePasswordMaxLen(String User, String Pass,String oldpass, String newpass, String cnfrmpass,String testPass) throws InterruptedException {
		launchUrl();
		logger.info("Url is Opened");
		maxWindow();
		toHold(8000);
		
		Percy percy = new Percy(driver);
		
		UpdatePasswordPage lp = new UpdatePasswordPage(driver);
		lp.clickLoginButton();
		logger.info("Clicked on Login Button");
		toHold(8000);
		
		percy.snapshot("Login Page");
		lp.setUsername(User);
		logger.info("Passed Username in UserField");
	    toHold(5000);
	    
	    lp.setPassword(Pass);
		logger.info("Passed Password in PwdField");
	    toHold(5000);  
	    
	    lp.clickLogin();
	    logger.info("Clicked on Login Button");
	    toHold(8000);
	    
	   
			if (driver.getCurrentUrl().equals(rbn.getString("HomeURL"))) {
				Assert.assertTrue(true);
				logger.info("Login Test is Passed");
				toHold(8000);
			}

			else {

				Assert.assertFalse(false);
				logger.info("Login Test is Failed");
				toHold(8000);
			}
			
		lp.usrProfile();
		logger.info("Passed clicking on user profile");
		toHold(5000);
		
		lp.actSettings();
		logger.info("Passed clicking on account settings");
		toHold(5000);
		percy.snapshot("Acc Settings Page");	
		
		lp.updatePassword();
		logger.info("Passed clicking on update password");
		toHold(5000);
		percy.snapshot("Update Password Page");
		
		lp.oldPassword(oldpass);
		logger.info("Passed Old Password in PwdField");
		toHold(5000);
		
		lp.newPassword(newpass);
		logger.info("Passed New Password in PwdField");
		toHold(5000);
		
		lp.confirmPassword(cnfrmpass);
		logger.info("Passed confirm Password in confirmPwdField");
		toHold(5000);
		
		lp.savechangesBtn();
	    logger.info("Clicked on Login Button");
	    toHold(8000);
	    percy.snapshot("After Password Update ");
	   
			if (driver.findElement(By.xpath("//div[text()=' Password changed successfully ']")).equals("Password changed successfully")) {
				Assert.assertTrue(true);
				logger.info("password changed successfully");
				toHold(4000);
			}

			else {

				Assert.assertFalse(false);
				logger.info("change password is failed");
				toHold(8000);
			}
			
			toHold(8000);
			lp.usrProfile();
			logger.info("Clicked on User Profile ");
			Thread.sleep(2000);
			lp.btnLogout();
			logger.info("Clicked on Logout");
	
	    }
	
	@Test(priority = 2, description = "Password Update with max length", dataProvider = "UpdatePasswordMaxLen", dataProviderClass = BaseClassNew.class)
	@Severity(SeverityLevel.CRITICAL)

	public void updatePasswordMaxLenAgain(String User, String Pass, String oldpass, String newpass, String cnfrmpass,String testPass) throws InterruptedException {
		launchUrl();
		logger.info("Url is Opened");
		maxWindow();
		toHold(8000);
		
		UpdatePasswordPage lp = new UpdatePasswordPage(driver);
		lp.clickLoginButton();
		logger.info("Clicked on Login Button");
		toHold(8000);
		
		lp.setUsername(User);
		logger.info("Passed Username in UserField");
	    toHold(5000);
	    
	    lp.setPassword(newpass);
		logger.info("Passed Password in PwdField");
	    toHold(5000);  
	    
	    lp.clickLogin();
	    logger.info("Clicked on Login Button");
	    toHold(8000);
	    
	   
			if (driver.getCurrentUrl().equals(rbn.getString("HomeURL"))) {
				Assert.assertTrue(true);
				logger.info("Login Test is Passed");
				toHold(8000);
			}

			else {

				Assert.assertFalse(false);
				logger.info("Login Test is Failed");
				toHold(8000);
			}
			
		lp.usrProfile();
		logger.info("Passed clicking on user profile");
		toHold(5000);
		
		lp.actSettings();
		logger.info("Passed clicking on account settings");
		toHold(5000);
			
		lp.updatePassword();
		logger.info("Passed clicking on update password");
		toHold(5000);
		
		lp.oldPassword(newpass);
		logger.info("Passed Old Password in PwdField");
		toHold(5000);
		
		lp.newPassword(testPass);
		logger.info("Passed New Password in PwdField");
		toHold(5000);
		
		lp.confirmPassword(testPass);
		logger.info("Passed confirm Password in confirmPwdField");
		toHold(5000);
		
		lp.savechangesBtn();
	    logger.info("Clicked on Login Button");
	    toHold(8000);
	    
	   
			if (driver.findElement(By.xpath("//div[text()=' Password changed successfully ']")).equals("Password changed successfully")) {
				Assert.assertTrue(true);
				logger.info("password changed successfully");
				toHold(8000);
			}

			else {

				Assert.assertFalse(false);
				logger.info("change password is failed");
				toHold(8000);
			}
			
			toHold(8000);
			lp.usrProfile();
			logger.info("Clicked on User Profile ");
			Thread.sleep(2000);
			lp.btnLogout();
			logger.info("Clicked on Logout");
	
	    }
	
}
