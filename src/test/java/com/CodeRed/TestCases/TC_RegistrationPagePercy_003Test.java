package com.CodeRed.TestCases;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.CodeRed.PageObjects.LoginLogoutPage;
import com.CodeRed.PageObjects.RegistrationPage;
import com.CodeRed.Utilities.BaseClassNew;

import io.percy.selenium.Percy;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import com.CodeRed.PageObjects.*;

public class TC_RegistrationPagePercy_003Test extends BaseClassNew{

	@Test(priority = 0, description = "Verify User Registration", dataProvider = "loginCoderedDataParticipant", dataProviderClass = BaseClassNew.class)
	@Severity(SeverityLevel.CRITICAL)

	public void userRegistration(String User, String Pass) throws InterruptedException {
		
		launchUrl();
		logger.info("Url is Opened");
		maxWindow();
		toHold(8000);
		
		Percy percy = new Percy(driver);
		
		RegistrationPage rp = new RegistrationPage(driver);
		String tarname = generateRandomname();
		percy.snapshot("Reg Page");
	    rp.firstName(tarname);
	    logger.info("Passed Firstname in FirstName Field");
	    String targetName = generateRandomEmail() + "@gmail.com";
	    rp.email(targetName);
	    logger.info("Passed Email in Email Field");
	    rp.password(Pass);
	    logger.info("Passed Password in Password Field");
	    rp.checkBox();
	    logger.info("Clicked on checkbox ");
	    toHold(3000);
        rp.signUp();
        logger.info("Clicked on signup button");
	    toHold(8000);
	    percy.snapshot("Landing Page ");
	    rp.startButton();
	    logger.info("Clicked on Start Button");
	    toHold(4000);
	    percy.snapshot("Categories List Page 1 ");
	    rp.categoriesFirstPage();
	    logger.info("Selected categories in first page");
	    toHold(4000);
	    rp.nextButton();
	    logger.info("Clicked on Next Button");
	    toHold(4000);
	    percy.snapshot("Categories List Page 2 ");
	    rp.categoriesSecondPage();
	    logger.info("Selected categories in second page ");
	    toHold(4000); 
	    rp.nextButton();
	    logger.info("Clicked on Next Button");
	    toHold(4000);
	    percy.snapshot("Categories List Page 3 ");
	    rp.categoriesThirdPage();
	    logger.info("Selected categories in Third Page");
	    toHold(4000);
	    rp.nextButton();
	    logger.info("Clicked on Next Button");
	    toHold(4000);
	    percy.snapshot("Categories List Page 4 ");
	    rp.categoriesFourthPage();
	    logger.info("Selected categories in Fourth Page");
	    toHold(4000);
	    rp.finishButton();
	    logger.info("Clicked on Finish Button");
	    toHold(8000);
	   
	    if (driver.getCurrentUrl().equals(rbn.getString("onboardUrl"))) {
	    	Assert.assertFalse(false);
	    	System.out.println("User onboarded successfully");
	    	toHold(8000);
	    	percy.snapshot(" Dashboard Page ");
	    	rp.goToDashboard();
	        logger.info("Clicked on Go To Dashboard ");
	        toHold(3000);  
		}

		else {

			Assert.assertFalse(false);
			logger.info("Failed to register user");
			toHold(8000);
		}
	    toHold(12000);
	    LoginLogoutPage lp = new LoginLogoutPage(driver);
	    percy.snapshot(" User Image Page ");
		lp.userImage();
		logger.info("Clicked on User Profile ");
		Thread.sleep(2000);
		lp.btnLogout();
		logger.info("Clicked on Logout");
    }	
	
	
	
	
}

