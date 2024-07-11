package com.SauceDemoProject.TestScripts;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


import com.SauceDemoProject.PageObjects.LoginPage;
import com.SauceDemoProject.PageObjects.UpdatePasswordPage;
import com.SauceDemoProject.Utilities.BaseClass;
import com.SauceDemoProject.Utilities.BaseClass2;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TC_UpdatePassword_004 extends BaseClass2 {
	
	@Test(priority = 0, description = "Password Update", dataProvider = "updatePasswordMinLength", dataProviderClass = BaseClass2.class)
	@Severity(SeverityLevel.CRITICAL)

	public void updatePassword(String user, String pass, String oldpass, String newpass, String cnfrmpass)
			throws InterruptedException {

		WebDriver driver = getDriver();
		launchUrl();
		logger.info("URL is Opened");
		maxWindow();
		implicitWait(30);

		LoginPage lp = new LoginPage(driver);
		lp.closePopup(30);
		logger.info("Clicked on popup");

		lp.clickLoginButton(20);
		logger.info("Clicked on Login Button");

		lp.setUsername(user, 10);
		logger.info("Entered Username");
		lp.setPassword(pass, 10);
		logger.info("Entered Password");
		lp.clickLogin(20);
		logger.info("Clicked on Login Button");
		toHold(12000);

		if (driver.getCurrentUrl().equals(rbn.getString("HomeUrl"))) {
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		} else {
			Assert.assertFalse(false);
			logger.info("Login Test Failed");
		}

		lp.userImage(30);
		logger.info("Clicked on User Profile");

		UpdatePasswordPage up = new UpdatePasswordPage(driver);

		up.profile(30);
		logger.info("Passed clicking on account settings- updatePasswordMinLen");

		up.updatePassword(20);
		logger.info("Passed clicking on update password- updatePasswordMinLen");

		up.oldPassword(oldpass, 20);
		logger.info("Passed Old Password in PwdField- updatePasswordMinLen");

		up.newPassword(newpass);
		logger.info("Passed New Password in PwdField- updatePasswordMinLen");

		up.confirmPassword(cnfrmpass);
		logger.info("Passed confirm Password in confirmPwdField- updatePasswordMinLen");
       
		javascriptexecutor(up.getSavechangesBtn());
        
		up.savechangesBtn();
		logger.info("Clicked on save button Button- updatePasswordMinLen");
		toHold(5000);

		up.successMessage("Password Changed Successfully");	

	}
	@Test(priority = 2, description = "Password Update with max length", dataProvider = "changePasswordMinLength", dataProviderClass = BaseClass2.class)
	@Severity(SeverityLevel.CRITICAL)

	public void updatePasswordMaxLenAgain(String User, String Pass, String oldpass, String newpass, String cnfrmpass) throws InterruptedException {
		
		WebDriver driver = getDriver();
		toRefresh();
		LoginPage lp = new LoginPage(driver);

		lp.closePopup(10);
		logger.info("Clicked on popup");

		UpdatePasswordPage up = new UpdatePasswordPage(driver);
		
		up.oldPassword(oldpass, 20);
		logger.info("Passed Old Password in PwdField- updatePasswordMinLen");

		up.newPassword(newpass);
		logger.info("Passed New Password in PwdField- updatePasswordMinLen");

		up.confirmPassword(cnfrmpass);
		logger.info("Passed confirm Password in confirmPwdField- updatePasswordMinLen");
       
		javascriptexecutor(up.getSavechangesBtn());
        
		up.savechangesBtn();
		logger.info("Clicked on save button Button- updatePasswordMinLen");
		toHold(5000);

		up.successMessage("Password Changed Successfully");
        toHold(5000);
		lp.userImage(30);
		logger.info("Clicked on User Profile - updatePasswordMinLen");
		
		lp.btnLogout(10);
		logger.info("Clicked on Logout- updatePasswordMinLen");
	    
	    }
}
