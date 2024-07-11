package com.SauceDemoProject.TestScripts;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import com.SauceDemoProject.PageObjects.LoginPage;
import com.SauceDemoProject.PageObjects.LoginPage2;
import com.SauceDemoProject.PageObjects.PersonalDetailsPage;
import com.SauceDemoProject.PageObjects.PersonalDetailsPage2;
import com.SauceDemoProject.Utilities.BaseClass;
import com.SauceDemoProject.Utilities.BaseClass2;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TC_PersonalDetails_006 extends BaseClass{
	
	@Test(priority = 0, description = "Update user personal details", dataProvider = "PersonalDetails", dataProviderClass = BaseClass.class)
	@Severity(SeverityLevel.CRITICAL)

	public void personalDetails(String User, String Pass, String fstname, String lstname,String mobile, String crntpass) throws InterruptedException {
		
		WebDriver driver = getDriver();

		launchUrl();
		logger.info("URL is Opened");

		LoginPage2 lp = new LoginPage2(driver);
      
		lp.closePopups(30);
		logger.info("Clicked on popup");
		
		lp.checkAndClickLogin(10);
		logger.info("Clicked on Login Button");
		lp.setUsername(User, 10);
		logger.info("Entered Username");
		lp.setPassword(Pass, 10);
		logger.info("Entered Password");
		lp.clickLogin(30);
		logger.info("Clicked on Login Button");
		toHold(12000);

//	    if (driver.getCurrentUrl().equals(rbn.getString("HomeUrl"))) {
//	        Assert.assertTrue(true);
//	        logger.info("Login Test Passed");
//	       
//	    } else {
//	        Assert.assertFalse(false);
//	        logger.info("Login Test Failed");
//	    }

		lp.userImage(30);
		logger.info("Clicked on User Profile");
	    
	   PersonalDetailsPage2 p = new PersonalDetailsPage2(driver);
	    p.profile(20);
	    logger.info("Passed clicking on account settings - Personal Details");
//		toRefresh();
//		lp.closePopup(20);
//		logger.info("Closed on popup");
		p.firstName(fstname,20);
		logger.info("Passed first name - Personal Details");
		
		p.lastName(lstname);
		logger.info("Passed last name - Personal Details");
		toHold(5000);
		
		p.mobileNum(mobile,10);
	    logger.info("Passed mobile number - Personal Details");
	    
	    p.currentPassword(crntpass);
	    logger.info("Passed current password - Personal Details");
	       
	    p.savechangesBtn();
	    logger.info("Clicked on save changes"); 
	    
	    lp.userImage(30);
		logger.info("Clicked on User Profile - updatePasswordMinLen");
		
		lp.btnLogout(10);
		logger.info("Clicked on Logout- updatePasswordMinLen");  
	   
	}
	
	
}
