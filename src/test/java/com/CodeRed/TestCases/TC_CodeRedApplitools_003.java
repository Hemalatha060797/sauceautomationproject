package com.CodeRed.TestCases;
import com.applitools.eyes.*;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.config.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.StitchMode;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TC_CodeRedApplitools_003 {
	
	    private final int viewPortWidth = 800;
	    private final int viewPortHeight = 600;
	    String myEyesServer = "https://eyesapi.applitools.com/"; //set to your server/cloud URL
	    String appName = "CodeRed";
	    String batchName = "Login Page";
	    private String apiKey = "rv99hsw30eh3i9h1118QJCBMBtM8NXbiLpd206mdOp1RiM110";
	    private EyesRunner runner = null;
	    private com.applitools.eyes.config.Configuration suiteConfig;
	    private Eyes eyes;
	    private WebDriver webDriver;
        public static  JavascriptExecutor js;
	   
        @BeforeSuite
	    public void beforeTestSuite() {
	        runner = new ClassicRunner();
	     
	        suiteConfig = new Configuration()
	                // Checkpoint configurations
	                .setForceFullPageScreenshot(true)
	                .setStitchMode(StitchMode.CSS)
	                .setHideScrollbars(true)
	                .setHideCaret(true)
	             // .setViewportSize( new RectangleSize(viewPortWidth, viewPortHeight))
	                // Test suite configurations
	                .setApiKey(apiKey)
	              //  .setServerUrl(myEyesServer)
	                .setAppName(appName)
	                .setBatch(new BatchInfo(batchName)
	                        /* ... more configurations */ );
	    }


	    @BeforeMethod
	    public void beforeEachTest(ITestResult result) {

	        
	        eyes = new Eyes(runner);
	        
	        eyes.setConfiguration(suiteConfig);
	        
	        webDriver = new ChromeDriver();
	    }


	    @Test(priority = 0, description = "Verify Login Button before and after increasing font- size")
		@Severity(SeverityLevel.CRITICAL)
	    public void testHelloWorld() {
	        // Update the Eyes configuration with test specific values
	        Configuration testConfig = eyes.getConfiguration();
	        testConfig.setTestName("Hello User");
	        eyes.setConfiguration(testConfig);

	        // Open Eyes, the application,test name
	        WebDriver driver = eyes.open(webDriver);
			//driver.manage().window().maximize();

	        js = (JavascriptExecutor) driver;
	        driver.get("https://uat-eccl.eccouncil.org/?logged=false"); 
	      
	        WebElement btnLogin = driver.findElement(By.xpath(" (//a[text()='Login'])[1]"));
	        js.executeScript("arguments[0].click()", btnLogin);
	        
	       // btnLogin.click();
	       
	        eyes.checkWindow("Login Button Before font increase");
	        WebElement element = driver.findElement(By.xpath("//span[text()=' Log in ']"));

	    	js.executeScript("arguments[0].style.fontSize = '80px'", element);
	        
	        // Visual checkpoint #2
	      	 eyes.checkWindow("Login Button after font increase");
	    }
	    
	    @Test(priority = 1, description = "Verify Login with Before and After Font Increase")
	    public void testHelloWorld2() {
	       
	        Configuration testConfig = eyes.getConfiguration();
	        testConfig.setTestName("Hello User");
	        eyes.setConfiguration(testConfig);

	       
	        WebDriver driver = eyes.open(webDriver);

	        js = (JavascriptExecutor) driver;
	        driver.get("https://uat-eccl.eccouncil.org/?logged=false"); 
	       
	        WebElement btnLogin = driver.findElement(By.xpath(" (//a[text()='Login'])[1]"));
	        js.executeScript("arguments[0].click()", btnLogin);
	        
	        eyes.checkWindow("Login Button before font increase");
	        WebElement element = driver.findElement(By.xpath("//span[text()=' Log in ']"));

	    // 	js.executeScript("arguments[0].style.fontSize = '80px'", element);
	        
	        // Visual checkpoint #2
	     eyes.checkWindow("Login Button after font increase");
	    }

	    
	    
	    
	    
	    
	    @AfterMethod
	    public void afterEachTest(ITestResult result) {
	        // check if an exception was thrown
	        boolean testPassed = result.getStatus() != ITestResult.FAILURE;
	        if (testPassed) {
	            // Close the Eyes instance, no need to wait for results, we'll get those at the end in afterTestSuite
	            eyes.closeAsync();
	        } else {
	            // There was an exception so the test may be incomplete - abort the test
	            eyes.abortAsync();
	        }
	        webDriver.quit();
	    }

	    @AfterSuite
	    public void afterTestSuite(ITestContext testContext) {
	        //Wait until the test results are available and retrieve them
	        TestResultsSummary allTestResults = runner.getAllTestResults(false);
	        for (TestResultContainer result : allTestResults) {
	            handleTestResults(result);
	        }
	    }
	 public void handleTestResults(TestResultContainer summary) {
	        Throwable ex = summary.getException();
	        if (ex != null ) {
	            System.out.printf("System error occured while checking target.\n");
	        }
	        TestResults result = summary.getTestResults();
	        if (result == null) {
	            System.out.printf("No test results information available\n");
	        } else {
	            System.out.printf("URL = %s, AppName = %s, testname = %s, Browser = %s,OS = %s, viewport = %dx%d, matched = %d,mismatched = %d, missing = %d,aborted = %s\n",
	                    result.getUrl(),
	                    result.getAppName(),
	                    result.getName(),
	                    result.getHostApp(),
	                    result.getHostOS(),
	                    result.getHostDisplaySize().getWidth(),
	                    result.getHostDisplaySize().getHeight(),
	                    result.getMatches(),
	                    result.getMismatches(),
	                    result.getMissing(),
	                    (result.isAborted() ? "aborted" : "no"));
	        }
	    }
	}

