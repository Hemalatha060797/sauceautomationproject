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
		logger.info("Url is Opened");
		maxWindow();
		toHold(8000);
		
		Percy percy = new Percy(driver);
		
		 
		
		LoginLogoutPage lp = new LoginLogoutPage(driver);
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
			
			toHold(12000);
			percy.snapshot("Home Page");
			lp.userImage();
			logger.info("Clicked on User Profile ");
			Thread.sleep(2000);
			lp.btnLogout();
			logger.info("Clicked on Logout");
		//	eye.close();
	    }	
	
	
	
	
	
	
	
	
	
}
	

