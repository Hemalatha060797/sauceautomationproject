package com.CodeRed.TestCases;

import java.util.Arrays;
import java.util.HashMap;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.percy.selenium.Percy;
import com.CodeRed.Utilities.BaseClassNew;
import com.applitools.eyes.selenium.Eyes;
import com.CodeRed.PageObjects.LoginLogoutPage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TC_LoginLogout_001Test extends BaseClassNew{

//	   
//
//	@Test(priority = 0, description = "Verify Login with valid username/password", dataProvider = "loginCoderedDataParticipant", dataProviderClass = BaseClassNew.class)
//	@Severity(SeverityLevel.CRITICAL)
//
//	public void userLoginUsernamePwd(String User, String Pass) throws InterruptedException, IOException {
//		
//		
//       	launchUrl();
//		logger.info("Url is Opened");
//		maxWindow();
//		toHold(8000);
//		
//		Eyes eye = new Eyes();
//		eye.setApiKey("rv99hsw30eh3i9h1118QJCBMBtM8NXbiLpd206mdOp1RiM110");
//		eye.open(driver, "CodeRedPage", "LoginTest");
//		 
//		
//		LoginLogoutPage lp = new LoginLogoutPage(driver);
//		lp.clickLoginButton();
//		logger.info("Clicked on Login Button");
//		toHold(8000);
//	    eye.checkWindow();
//		captureScreen("Login");
//		lp.setUsername(User);
//		logger.info("Passed Username in UserField");
//	    toHold(5000);
//	    
//	    lp.setPassword(Pass);
//		logger.info("Passed Password in PwdField");
//	    toHold(5000);
//	    
//	    lp.clickLogin();
//	    logger.info("Clicked on Login Button");
//	    toHold(8000);
//	   
//	   
//			if (driver.getCurrentUrl().equals(rbn.getString("HomeURL"))) {
//				Assert.assertTrue(true);
//				logger.info("Login Test is Passed");
//				toHold(8000);
//			}
//
//			else {
//
//				Assert.assertFalse(false);
//				logger.info("Login Test is Failed");
//				toHold(8000);
//			}
//			//LoginLogoutPage lp = new LoginLogoutPage(driver);
//			toHold(12000);
//			lp.userImage();
//			logger.info("Clicked on User Profile ");
//			Thread.sleep(2000);
//			lp.btnLogout();
//			logger.info("Clicked on Logout");
//		//	eye.close();
//	    }	
//	
//	@Ignore
//	@Test(priority = 1, description = "Verify Login for Case sensitivity", dataProvider = "loginCoderedDataCaseSensitivityParticipant", dataProviderClass = BaseClassNew.class)
//	@Severity(SeverityLevel.CRITICAL)
//
//	public void userLoginCaseSensitivity(String User, String Pass) throws InterruptedException {
//		toHold(8000);
//		launchUrl();
//		logger.info("Url is Opened");
//		maxWindow();
//		toHold(8000);
//		
//		LoginLogoutPage lp = new LoginLogoutPage(driver);
//		lp.clickLoginButton();
//		logger.info("Clicked on Login Button");
//		toHold(8000);
//		
//		lp.setUsername(User);
//		logger.info("Passed Username in UserField");
//	    toHold(5000);
//	    
//	    lp.setPassword(Pass);
//		logger.info("Passed Password in PwdField");
//	    toHold(5000);
//	    
//	    lp.clickLogin();
//	    logger.info("Clicked on Login Button");
//	    toHold(8000);
//	    
//	   
//			if (driver.getCurrentUrl().equals(rbn.getString("HomeURL"))) {
//				Assert.assertTrue(true);
//				logger.info("Login Test is Passed");
//				toHold(8000);
//			}
//
//			else {
//
//				Assert.assertFalse(false);
//				logger.info("Login Test is Failed");
//				toHold(8000);
//			}
//			//LoginLogoutPage lp = new LoginLogoutPage(driver);
//			toHold(8000);
//			lp.userImage();
//			logger.info("Clicked on User Profile ");
//			Thread.sleep(2000);
//			lp.btnLogout();
//			logger.info("Clicked on Logout");
//	    }	
//	
//	@Ignore
//	@Test(priority = 2, description = "Verify Login for White Spaces ", dataProvider = "loginCoderedDataWhiteSpacesParticipant", dataProviderClass = BaseClassNew.class)
//	@Severity(SeverityLevel.CRITICAL)
//
//	public void userLoginWhiteSpaces(String User, String Pass) throws InterruptedException {
//		toHold(8000);
//		launchUrl();
//		logger.info("Url is Opened");
//		//maxWindow();
//		toHold(8000);
//		
//		LoginLogoutPage lp = new LoginLogoutPage(driver);
//		lp.clickLoginButton();
//		logger.info("Clicked on Login Button");
//		toHold(8000);
//		
//		lp.setUsername(User);
//		logger.info("Passed Username in UserField");
//	    toHold(5000);
//	    
//	    lp.setPassword(Pass);
//		logger.info("Passed Password in PwdField");
//	    toHold(5000);
//	    
//	    lp.clickLogin();
//	    logger.info("Clicked on Login Button");
//	    toHold(8000);
//	    
//	   
//			if (driver.getCurrentUrl().equals(rbn.getString("HomeURL"))) {
//				Assert.assertTrue(true);
//				logger.info("Login Test is Passed");
//				toHold(8000);
//			}
//
//			else {
//
//				Assert.assertFalse(false);
//				logger.info("Login Test is Failed");
//				toHold(8000);
//			}
//			//LoginLogoutPage lp = new LoginLogoutPage(driver);
//			toHold(8000);
//			lp.userImage();
//			logger.info("Clicked on User Profile ");
//			Thread.sleep(2000);
//			lp.btnLogout();
//			logger.info("Clicked on Logout");
//	    }	
//	
//	
//	
}
