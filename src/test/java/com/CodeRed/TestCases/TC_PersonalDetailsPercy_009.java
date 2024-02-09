package com.CodeRed.TestCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.CodeRed.PageObjects.PersonalDetailsPage;
import com.CodeRed.Utilities.BaseClassNew;

import io.percy.selenium.Percy;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TC_PersonalDetailsPercy_009 extends BaseClassNew {
	
	@Test(priority = 0, description = "Update user personal details", dataProvider = "PersonalDetails", dataProviderClass = BaseClassNew.class)
	@Severity(SeverityLevel.CRITICAL)

	public void invalidcurrentpassword(String User, String Pass, String fstname, String lstname, String email, String mobile, String country, String crntpass) throws InterruptedException {
		launchUrl();
		logger.info("Url is Opened - Personal Details");
		maxWindow();
		toHold(8000);
		Percy percy = new Percy(driver);
		
		PersonalDetailsPage lp = new PersonalDetailsPage(driver);
		lp.clickLoginButton();
		logger.info("Clicked on Login Button - Personal Details");
		toHold(8000);
		
		lp.setUsername(User);
		logger.info("Passed Username in UserField - Personal Details");
	    toHold(5000);
	    
	    lp.setPassword(Pass);
		logger.info("Passed Password in PwdField - Personal Details");
	    toHold(5000);  
	    
	    lp.clickLogin();
	    logger.info("Clicked on Login Button - Personal Details");
	    toHold(8000);
	    
	   
			if (driver.getCurrentUrl().equals(rbn.getString("HomeURL"))) {
				Assert.assertTrue(true);
				logger.info("Login Test is Passed - Personal Details");
				toHold(8000);
			}

			else {

				Assert.assertFalse(false);
				logger.info("Login Test is Failed - Personal Details");
				toHold(8000);
			}
			
		lp.usrProfile();
		logger.info("Passed clicking on user profile - Personal Details");
		toHold(5000);
		
		lp.actSettings();
		logger.info("Passed clicking on account settings - Personal Details");
		toHold(5000);
			
		
		percy.screenshot("Personal Details Page");
		
		lp.firstName(fstname);
		logger.info("Passed first name - Personal Details");
		toHold(5000);
		
		lp.lastName(lstname);
		logger.info("Passed last name - Personal Details");
		toHold(5000);
		
		lp.emailId(email);
		logger.info("Passed email - Personal Details");
		toHold(5000);
		
		lp.mobileNum(mobile);
	    logger.info("Passed mobile number - Personal Details");
	    toHold(8000);
        scrollDown(); 
        toHold(8000);

	    lp.countryName(country);
	    logger.info("Clicked on  country name - Personal Details");
	    toHold(8000);
	    
	    lp.currentPassword(crntpass);
	    logger.info("Passed current password - Personal Details");
	    toHold(8000);
	    
	    lp.savechangesBtn();
	    logger.info("Clicked on Login Button - Personal Details");
	    toHold(8000);
	    percy.screenshot("After Updation of Personal Details ");
	   
//			if (driver.findElement(By.xpath("//div[text()=' Password changed successfully ']")).equals(" Password changed successfully ")) {
//				Assert.assertTrue(true);
//				logger.info("password changed successfully");
//				toHold(8000);
//			}
//
//			else {
//
//				Assert.assertFalse(false);
//				logger.info("change password is failed");
//				toHold(8000);
//			}
	
	    }
	
	@Test(priority = 1, description = "verify Logout")
	@Severity(SeverityLevel.CRITICAL)

	public void userLogout() throws InterruptedException {
		PersonalDetailsPage lp = new PersonalDetailsPage(driver);
		toHold(8000);
		lp.usrProfile();
		logger.info("Clicked on User Profile - Personal Details ");
		Thread.sleep(2000);
		lp.btnLogout();
		logger.info("Clicked on Logout - Personal Details");
	}

}
