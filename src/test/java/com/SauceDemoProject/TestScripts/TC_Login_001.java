package com.SauceDemoProject.TestScripts;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import com.SauceDemoProject.PageObjects.LoginPage;
import com.SauceDemoProject.Utilities.BaseClass;
import com.SauceDemoProject.Utilities.BaseClass2;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TC_Login_001 extends BaseClass2 {
	
	
	@Test(priority = 0, description = "Verify Login with valid username/password", dataProvider = "sauceBrowsersLogin", dataProviderClass = BaseClass2.class)
	@Severity(SeverityLevel.CRITICAL)
	public void userLogin(String user, String pass) throws InterruptedException, IOException {
	    
		 WebDriver driver = getDriver();
		
		 launchUrl();
	    logger.info("URL is Opened");
	    maxWindow();
	   
	    LoginPage lp = new LoginPage(driver);
	    
	    lp.closePopup(30);
	    logger.info("Clicked on popup");
        lp.clickLoginButton(20);
	    logger.info("Clicked on Login Button");   
//        toRefresh();
//        toHold(10000);
//        lp.closeLoginPopup();
//        logger.info("Closed Popup");
	    lp.setUsername(user, 10);
	    logger.info("Entered Username");
	    lp.setPassword(pass, 10);
	    logger.info("Entered Password");
	    lp.clickLogin(10);
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
    
	    lp.userImage(50);
	    logger.info("Clicked on User Profile");
	    lp.btnLogout(10);
	    logger.info("Clicked on Logout");
	}
}