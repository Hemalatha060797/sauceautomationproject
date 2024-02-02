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

	public void personalDetails(String User, String Pass, String fstname, String lstname, String email, String mobile, String country, String crntpass) throws InterruptedException {
		launchUrl();
		logger.info("Url is Opened-personalDetails");
		maxWindow();
		toHold(8000);
		Percy percy = new Percy(driver);
		
		PersonalDetailsPage lp = new PersonalDetailsPage(driver);
		lp.clickLoginButton();
		logger.info("Clicked on Login Button-personalDetails");
		toHold(8000);
		
		lp.setUsername(User);
		logger.info("Passed Username in UserField-personalDetails");
	    toHold(5000);
	    
	    lp.setPassword(Pass);
		logger.info("Passed Password in PwdField-personalDetails");
	    toHold(5000);  
	    
	    lp.clickLogin();
	    logger.info("Clicked on Login Button-personalDetails");
	    toHold(8000);
	    
	   
			if (driver.getCurrentUrl().equals(rbn.getString("HomeURL"))) {
				Assert.assertTrue(true);
				logger.info("Login Test is Passed-personalDetails");
				toHold(8000);
			}

			else {

				Assert.assertFalse(false);
				logger.info("Login Test is Failed-personalDetails");
				toHold(8000);
			}
			
		lp.usrProfile();
		logger.info("Passed clicking on user profile-personalDetails");
		toHold(5000);
		
		lp.actSettings();
		logger.info("Passed clicking on account settings-personalDetails");
		toHold(5000);
			
		lp.personalDetails();
		logger.info("Passed clicking on update password-personalDetails");
		toHold(5000);
		percy.screenshot("Personal Details Page");
		lp.firstName(fstname);
		logger.info("Passed first name-personalDetails");
		toHold(5000);
		
		lp.lastName(lstname);
		logger.info("Passed last name-personalDetails");
		toHold(5000);
		
		lp.emailId(email);
		logger.info("Passed email-personalDetails");
		toHold(5000);
		
		lp.mobileNum(mobile);
	    logger.info("Passed mobile number-personalDetails");
	    toHold(8000);
        scrollDown(); 
        toHold(8000);

	    lp.countryName(country);
	    logger.info("Clicked on  country name-personalDetails");
	    toHold(8000);
	    
	    lp.currentPassword(crntpass);
	    logger.info("Passed current password-personalDetails");
	    toHold(8000);
	    
	    lp.savechangesBtn();
	    logger.info("Clicked on Login Button-personalDetails");
	    toHold(8000);
	    percy.screenshot("After Updation of Personal Details ");
	    
	    toHold(8000);
		lp.usrProfile();
		logger.info("Clicked on User Profile-personalDetails ");
		Thread.sleep(2000);
		lp.btnLogout();
		logger.info("Clicked on Logout-personalDetails");
	   
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
	
	

}
