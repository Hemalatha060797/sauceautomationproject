package com.CodeRed.Utilities;

import java.time.Duration;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger; // for logging
	public ResourceBundle rb;

	@BeforeTest(alwaysRun = true)
	@Parameters("browser")
	public void setup(String br) {

//		logger = LogManager.getLogger(this.getClass()); // logging
//		rb = ResourceBundle.getBundle("config");

		if (br.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
//			options.addArguments("--remote-allow-origins=*", "--headless", "--window-size=1920,1080");
			driver = new ChromeDriver(options);
		} else if (br.equals("edge")) {
//				EdgeOptions options=new EdgeOptions();
//				options.addArguments("--headless", "--window-size=1920,1080");
			driver = new EdgeDriver();
		} else {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless", "--window-size=1920,1080");
			driver = new FirefoxDriver(options);
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
//			driver.get("https://uat-eccl.eccouncil.org/?logged=false");
//			driver.get(rb.getString("appurl"));
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}

	@BeforeClass(alwaysRun = true)
	public void intialization() {
		logger = LogManager.getLogger(this.getClass()); // logging
		rb = ResourceBundle.getBundle("config");
	}

	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.quit();

	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}
