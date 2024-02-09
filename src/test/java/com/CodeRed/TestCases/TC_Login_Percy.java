package com.CodeRed.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.CodeRed.PageObjects.LoginLogoutPage;
import com.CodeRed.Utilities.BaseClassNew;
import com.applitools.eyes.selenium.Eyes;

import io.percy.selenium.Percy;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TC_Login_Percy extends BaseClassNew{

	@Test(priority = 0, description = "Verify Login with valid username/password", dataProvider = "loginCoderedDataParticipant", dataProviderClass = BaseClassNew.class)
	@Severity(SeverityLevel.CRITICAL)

	public void userLoginUsernamePwd(String User, String Pass) throws InterruptedException, IOException {
		
		
       	launchUrl();
		logger.info("Url is Opened - LoginPage");
		maxWindow();
		toHold(8000);
		
		Percy percy = new Percy(driver);
		
		 
		percy.screenshot("Url Redirection");
		
		LoginLogoutPage lp = new LoginLogoutPage(driver);
		lp.clickLoginButton();
		logger.info("Clicked on Login Button- LoginPage");
		toHold(8000);
	  
		percy.screenshot("Login Page");
		lp.setUsername(User);
		logger.info("Passed Username in UserField- LoginPage");
	    toHold(5000);
	    
	    lp.setPassword(Pass);
		logger.info("Passed Password in PwdField- LoginPage");
	    toHold(5000);
	    
	    lp.clickLogin();
	    logger.info("Clicked on Login Button- LoginPage");
	    toHold(8000);
	   
	   
			if (driver.getCurrentUrl().equals(rbn.getString("HomeURL"))) {
				Assert.assertTrue(true);
				logger.info("Login Test is Passed- LoginPage");
				toHold(8000);
			}

			else {

				Assert.assertFalse(false);
				logger.info("Login Test is Failed- LoginPage");
				toHold(8000);
			}
			
			toHold(12000);
			percy.screenshot("Home Page");
			lp.userImage();
			logger.info("Clicked on User Profile- LoginPage ");
			Thread.sleep(2000);
			lp.btnLogout();
			logger.info("Clicked on Logout- LoginPage");
			percy.screenshot("Logout Page");
		//	eye.close();
	    }	
	
	
	
	
	
	
	
	
	
}
	

