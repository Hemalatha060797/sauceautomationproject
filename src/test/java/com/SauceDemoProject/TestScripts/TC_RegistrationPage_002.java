package com.SauceDemoProject.TestScripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import com.SauceDemoProject.PageObjects.LoginPage;
import com.SauceDemoProject.PageObjects.PersonalDetailsPage;
import com.SauceDemoProject.PageObjects.RegistrationPage;
import com.SauceDemoProject.Utilities.BaseClass;
import com.SauceDemoProject.Utilities.BaseClass2;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TC_RegistrationPage_002 extends BaseClass2{

	@Test(priority = 1, description = "Verify User Registration", dataProvider = "sauceBrowsersReg", dataProviderClass = BaseClass2.class)
	@Severity(SeverityLevel.CRITICAL)

	public void userRegistration(String User, String Pass) throws InterruptedException {
		
		WebDriver driver = getDriver();
		launchUrl();
		logger.info("Url is Opened");
		maxWindow();
		implicitWait(60);
    	toRefresh();
		LoginPage lp = new LoginPage(driver);
	    lp.closePopup(30);
	    logger.info("Clicked on popup");
	    
		RegistrationPage rp = new RegistrationPage(driver);
		
		//rp.getFreeAccess(50);
		rp.clickFreeAccess(50);
		logger.info("Clicked on Click Free Access");

		String tarname = generateRandomName(5);
		
		toRefresh();
		rp.closeRegPopup(30);
	    logger.info("Clicked on popup");
	    rp.firstName(tarname,30);
	    logger.info("Passed Firstname in FirstName Field");
	    
	    String targetName = generateRandomEmail();
	    
	    rp.email( targetName,20);
	    logger.info("Passed Email in Email Field");
	    
	    javascriptexecutor(rp.getStartedButton());
	    rp.countryDropdown();
	    logger.info("Selected country India from the dropdown");
		
	   
	    rp.password(Pass);
	    logger.info("Passed Password in Password Field");
	    
	    rp.checkBox();
	    logger.info("Clicked on checkbox ");
	    
        rp.signUp(20);
        logger.info("Clicked on signup button");
	   
        rp.attemptGetStartedEmailExists(10,targetName);
       
	    rp.startButton(30);
	    logger.info("Clicked on Start Button");
	    
	    
	    rp.categoriesFirstPage();
	    logger.info("Selected categories in first page");
	    
	    rp.nextButton();
	    logger.info("Clicked on Next Button");
	  
	   
	    rp.categoriesSecondPage();
	    logger.info("Selected categories in second page ");
	 
	    rp.nextButton();
	    logger.info("Clicked on Next Button");
	   
	    
	    rp.categoriesThirdPage();
	    logger.info("Selected categories in Third Page");
	 
	    rp.nextButton();
	    logger.info("Clicked on Next Button");
	
	   
	    rp.categoriesFourthPage();
	    logger.info("Selected categories in Fourth Page");

	    rp.finishButton(60);
	    logger.info("Clicked on Finish Button");

    	
	   
	    if (driver.getCurrentUrl().equals(rbn.getString("onboardUrl"))) {
	    	Assert.assertTrue(true);
	    	System.out.println("User onboarded successfully");
	    	
	    	rp.goToDashboard(30);
	        logger.info("Clicked on Go To Dashboard ");
		}

		else {

			Assert.assertFalse(false);
			logger.info("Failed to register user");
		
		}
		
	    	
	    
		lp.userImage(30);
		logger.info("Clicked on User Profile ");
		lp.btnLogout(20);
		logger.info("Clicked on Logout");
 }	
	
	
	
	
}

