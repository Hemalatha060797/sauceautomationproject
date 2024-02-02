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
		logger.info("Url is Opened-updatePasswordMinLen");
		maxWindow();
		toHold(8000);
		
		Percy percy = new Percy(driver);
		
		UpdatePasswordPage lp = new UpdatePasswordPage(driver);
		
		lp.clickLoginButton();
		logger.info("Clicked on Login Button-updatePasswordMinLen");
		toHold(8000);
		
		lp.setUsername(User);
		logger.info("Passed Username in UserField-updatePasswordMinLen");
	    toHold(5000);
	    
	    lp.setPassword(Pass);
		logger.info("Passed Password in PwdField-updatePasswordMinLen");
	    toHold(5000);  
	    
	    lp.clickLogin();
	    logger.info("Clicked on Login Button-updatePasswordMinLen");
	    toHold(8000);
	    
	   
			if (driver.getCurrentUrl().equals(rbn.getString("HomeURL"))) {
				Assert.assertTrue(true);
				logger.info("Login Test is Passed-updatePasswordMinLen");
				toHold(8000);
			}

			else {

				Assert.assertFalse(false);
				logger.info("Login Test is Failed-updatePasswordMinLen");
				toHold(8000);
			}
			
		percy.snapshot("Home Page");
		lp.usrProfile();
		logger.info("Passed clicking on user profile-updatePasswordMinLen");
		toHold(5000);
		
		lp.actSettings();
		logger.info("Passed clicking on account settings-updatePasswordMinLen");
		toHold(5000);

		percy.snapshot("act Settings Page");	
		
		lp.updatePassword();
		logger.info("Passed clicking on update password-updatePasswordMinLen");
		toHold(5000);
		
		lp.oldPassword(oldpass);
		logger.info("Passed Old Password in PwdField-updatePasswordMinLen");
		toHold(5000);
		
		lp.newPassword(newpass);
		logger.info("Passed New Password in PwdField-updatePasswordMinLen");
		toHold(5000);
		
		lp.confirmPassword(cnfrmpass);
		logger.info("Passed confirm Password in confirmPwdField-updatePasswordMinLen");
		toHold(5000);
		
		lp.savechangesBtn();
	    logger.info("Clicked on save button Button-updatePasswordMinLen");
	    toHold(8000);
	    
	    percy.snapshot("Update Password");
	    
		if (driver.findElement(By.xpath("//div[text()=' Password changed successfully ']")).equals("Password changed successfully")) {
				Assert.assertTrue(true);
				logger.info("password changed successfully-updatePasswordMinLen");
				toHold(8000);
			}

			else {

				Assert.assertFalse(false);
				logger.info("change password is failed-updatePasswordMinLen");
				toHold(8000);
			}
			
			toHold(8000);
			lp.usrProfile();
			logger.info("Clicked on User Profile-updatePasswordMinLen ");
			Thread.sleep(2000);
			lp.btnLogout();
			logger.info("Clicked on Logout-updatePasswordMinLen");
	
	    }
	
	@Test(priority = 1, description = "Password Update with max length", dataProvider = "UpdatePasswordMaxLen", dataProviderClass = BaseClassNew.class)
	@Severity(SeverityLevel.CRITICAL)

	public void updatePasswordMaxLen(String User, String Pass,String oldpass, String newpass, String cnfrmpass,String testPass) throws InterruptedException {
		launchUrl();
		logger.info("Url is Opened-updatePasswordMaxLen");
		maxWindow();
		toHold(8000);
		
		Percy percy = new Percy(driver);
		
		UpdatePasswordPage lp = new UpdatePasswordPage(driver);
		lp.clickLoginButton();
		logger.info("Clicked on Login Button-updatePasswordMaxLen");
		toHold(8000);
		
		percy.snapshot("Login Page");
		lp.setUsername(User);
		logger.info("Passed Username in UserField-updatePasswordMaxLen");
	    toHold(5000);
	    
	    lp.setPassword(Pass);
		logger.info("Passed Password in PwdField-updatePasswordMaxLen");
	    toHold(5000);  
	    
	    lp.clickLogin();
	    logger.info("Clicked on Login Button-updatePasswordMaxLen");
	    toHold(8000);
	    
	   
			if (driver.getCurrentUrl().equals(rbn.getString("HomeURL"))) {
				Assert.assertTrue(true);
				logger.info("Login Test is Passed-updatePasswordMaxLen");
				toHold(8000);
			}

			else {

				Assert.assertFalse(false);
				logger.info("Login Test is Failed-updatePasswordMaxLen");
				toHold(8000);
			}
			
		lp.usrProfile();
		logger.info("Passed clicking on user profile-updatePasswordMaxLen");
		toHold(5000);
		
		lp.actSettings();
		logger.info("Passed clicking on account settings-updatePasswordMaxLen");
		toHold(5000);
		percy.snapshot("Acc Settings Page-updatePasswordMaxLen");	
		
		lp.updatePassword();
		logger.info("Passed clicking on update password-updatePasswordMaxLen");
		toHold(5000);
		percy.snapshot("Update Password Page");
		
		lp.oldPassword(oldpass);
		logger.info("Passed Old Password in PwdField-updatePasswordMaxLen");
		toHold(5000);
		
		lp.newPassword(newpass);
		logger.info("Passed New Password in PwdField-updatePasswordMaxLen");
		toHold(5000);
		
		lp.confirmPassword(cnfrmpass);
		logger.info("Passed confirm Password in confirmPwdField-updatePasswordMaxLen");
		toHold(5000);
		
		lp.savechangesBtn();
	    logger.info("Clicked on Login Button-updatePasswordMaxLen");
	    toHold(8000);
	    percy.snapshot("After Password Update ");
	   
			if (driver.findElement(By.xpath("//div[text()=' Password changed successfully ']")).equals("Password changed successfully")) {
				Assert.assertTrue(true);
				logger.info("password changed successfully-updatePasswordMaxLen");
				toHold(4000);
			}

			else {

				Assert.assertFalse(false);
				logger.info("change password is failed-updatePasswordMaxLen");
				toHold(8000);
			}
			
			toHold(8000);
			lp.usrProfile();
			logger.info("Clicked on User Profile-updatePasswordMaxLen ");
			Thread.sleep(2000);
			lp.btnLogout();
			logger.info("Clicked on Logout-updatePasswordMaxLen");
	
	    }
	
	@Test(priority = 2, description = "Password Update with max length", dataProvider = "UpdatePasswordMaxLen", dataProviderClass = BaseClassNew.class)
	@Severity(SeverityLevel.CRITICAL)

	public void updatePasswordMaxLenAgain(String User, String Pass, String oldpass, String newpass, String cnfrmpass,String testPass) throws InterruptedException {
		launchUrl();
		logger.info("Url is Opened-updatePasswordMaxLen");
		maxWindow();
		toHold(8000);
		
		UpdatePasswordPage lp = new UpdatePasswordPage(driver);
		lp.clickLoginButton();
		logger.info("Clicked on Login Button-updatePasswordMaxLen");
		toHold(8000);
		
		lp.setUsername(User);
		logger.info("Passed Username in UserField-updatePasswordMaxLen");
	    toHold(5000);
	    
	    lp.setPassword(newpass);
		logger.info("Passed Password in PwdField-updatePasswordMaxLen");
	    toHold(5000);  
	    
	    lp.clickLogin();
	    logger.info("Clicked on Login Button-updatePasswordMaxLen");
	    toHold(8000);
	    
	   
			if (driver.getCurrentUrl().equals(rbn.getString("HomeURL"))) {
				Assert.assertTrue(true);
				logger.info("Login Test is Passed-updatePasswordMaxLen");
				toHold(8000);
			}

			else {

				Assert.assertFalse(false);
				logger.info("Login Test is Failed-updatePasswordMaxLen");
				toHold(8000);
			}
			
		lp.usrProfile();
		logger.info("Passed clicking on user profile-updatePasswordMaxLen");
		toHold(5000);
		
		lp.actSettings();
		logger.info("Passed clicking on account settings-updatePasswordMaxLen");
		toHold(5000);
			
		lp.updatePassword();
		logger.info("Passed clicking on update password-updatePasswordMaxLen");
		toHold(5000);
		
		lp.oldPassword(newpass);
		logger.info("Passed Old Password in PwdField-updatePasswordMaxLen");
		toHold(5000);
		
		lp.newPassword(testPass);
		logger.info("Passed New Password in PwdField-updatePasswordMaxLen");
		toHold(5000);
		
		lp.confirmPassword(testPass);
		logger.info("Passed confirm Password in confirmPwdField-updatePasswordMaxLen");
		toHold(5000);
		
		lp.savechangesBtn();
	    logger.info("Clicked on Login Button-updatePasswordMaxLen");
	    toHold(8000);
	    
	   
			if (driver.findElement(By.xpath("//div[text()=' Password changed successfully ']")).equals("Password changed successfully")) {
				Assert.assertTrue(true);
				logger.info("password changed successfully-updatePasswordMaxLen");
				toHold(8000);
			}

			else {

				Assert.assertFalse(false);
				logger.info("change password is failed-updatePasswordMaxLen");
				toHold(8000);
			}
			
			toHold(8000);
			lp.usrProfile();
			logger.info("Clicked on User Profile-updatePasswordMaxLen ");
			Thread.sleep(2000);
			lp.btnLogout();
			logger.info("Clicked on Logout-updatePasswordMaxLen");
	
	    }
	
}
