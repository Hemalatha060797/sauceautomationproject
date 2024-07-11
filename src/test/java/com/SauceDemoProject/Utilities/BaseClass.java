package com.SauceDemoProject.Utilities;

import java.awt.AWTException;
import org.openqa.selenium.MutableCapabilities;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.saucelabs.saucebindings.SauceSession;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.net.MalformedURLException;
import java.net.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class BaseClass {

	private static final int count = 0;
	// public static WebDriver driver = null;

	public static Logger logger;
	public static Robot r;
	public static Actions a;
	public static Alert al;
	public static JavascriptExecutor js;
	public static Select s;
	public static WebDriverWait w;
	public static FluentWait<WebDriver> f;
	public static ResourceBundle rbn;
	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
	public static XSSFCell Cell;
	public static String cellData;

	public static final String USERNAME = "HemalathaManikandan";
	public static final String ACCESS_KEY = "bdf09fc8-413c-4b58-a3cc-2356f7d5746b";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY
			+ "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	protected String browser;
	protected String version;
	protected String platform;
	protected String resolution;
	protected String deviceName;
	protected String devicePlatform;
	protected String devicePlatformVersion;
	protected String deviceOrientation;
	protected String appiumName;
	protected static ThreadLocal<RemoteWebDriver> threadDriver = new ThreadLocal<>();
	protected ThreadLocal<SauceSession> threadSession = new ThreadLocal<>();
	static {
		// Initialize ResourceBundle
		rbn = ResourceBundle.getBundle("config");
	}
	// public static WebDriver driver;

//    @BeforeClass
//    @Parameters({"browser", "version", "platform", "resolution"})
//    public void setUp(String browser, String version, String platform, String resolution) throws MalformedURLException {
//        System.out.println("Thread Id :" + Thread.currentThread().getId());
//        
//        RemoteWebDriver driver = null;
//        if (browser.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("edge")) {
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//        }
//        
//        threadDriver.set(driver);
//
//        logger = Logger.getLogger("SauceDemo");
//		PropertyConfigurator.configure("log4j.properties");
//    }

	public static WebDriver getDriver() {
		return threadDriver.get();
	}

	RemoteWebDriver driver;

	@BeforeClass
	@Parameters({ "browser", "deviceName", "devicePlatform", "appiumName", "devicePlatformVersion",
			"deviceOrientation" })
	public void setUp(String browser, String deviceName, String devicePlatform, String appiumName,
			String devicePlatformVersion, String deviceOrientation) throws MalformedURLException {

		this.browser = browser;
		this.deviceName = deviceName;
		this.devicePlatform = devicePlatform;
		this.devicePlatformVersion = devicePlatformVersion;
		this.appiumName = appiumName;
		this.deviceOrientation = deviceOrientation;

		MutableCapabilities caps = new MutableCapabilities();

		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("username", USERNAME);
		sauceOptions.put("accessKey", ACCESS_KEY);
		sauceOptions.put("build", "Final Build Cross Device Testing : Eccouncil Learning");
		sauceOptions.put("appiumVersion", "latest");

		if ("Android".equalsIgnoreCase(devicePlatform)) {

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-save-password-bubble");
			chromeOptions.addArguments("--disable-extensions");

			caps.setCapability("platformName", devicePlatform);
			caps.setCapability("appium:deviceName", deviceName);
			caps.setCapability("appium:platformVersion", devicePlatformVersion);
			caps.setCapability("appium:automationName", appiumName);
			caps.setCapability("browserName", browser);
			caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			caps.setCapability("sauce:options", sauceOptions);

			caps.setCapability("appium:deviceOrientation", deviceOrientation);

		} else if ("iOS".equalsIgnoreCase(devicePlatform)) {
			caps.setCapability("platformName", devicePlatform);
			caps.setCapability("appium:deviceName", deviceName);
			caps.setCapability("appium:platformVersion", devicePlatformVersion);
			caps.setCapability("appium:automationName", appiumName);
			caps.setCapability("browserName", "safari");
			caps.setCapability("sauce:options", sauceOptions);

			caps.setCapability("appium:deviceOrientation", deviceOrientation);

		} else {
			throw new IllegalArgumentException("Unsupported device platform: " + devicePlatform);
		}

		// Start the session
		URL url = new URL(URL);
		RemoteWebDriver driver = new RemoteWebDriver(url, caps);
		threadDriver.set(driver);
		logger = Logger.getLogger("SauceDemo");
		PropertyConfigurator.configure("log4j.properties");
	}

	@BeforeMethod
	public void setTestName(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		String fullTestName = "Test: " + testName + " - " + deviceName + " " + devicePlatformVersion + " "
				+ devicePlatform;

		System.out.println("Currently executing test: " + fullTestName);
		logger.info("Currently executing test: " + fullTestName);

		// Update the Sauce Labs test name dynamically
		((RemoteWebDriver) getDriver()).executeScript("sauce:job-name=" + fullTestName);
	}

	@AfterMethod
	public void testStatus(ITestResult result) {
		String status = result.isSuccess() ? "Passed" : "Failed";
		String testName = result.getMethod().getMethodName();
		String fullTestName = "Test: " + testName;

		System.out.println("Test Status: " + status);
		System.out.println("Test Name: " + fullTestName);
	}

	@AfterClass
	public void tearDown() {
		WebDriver driver = getDriver();
		if (driver != null) {
			driver.quit();
			threadDriver.remove();
		}
	}

	@DataProvider(name = "sauceBrowsersLogin")
	public Object[][] sauceBrowserDataProviderLogin() throws IOException {
		String excelPath = System.getProperty("user.dir")
				+ "/src/test/java/com/SauceDemoProject/TestData/CodeRedLogin.xlsx";
		FileInputStream file = new FileInputStream(new File(excelPath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] testData = new Object[rowCount - 1][colCount];

		DataFormatter formatter = new DataFormatter();
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				testData[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}

		workbook.close();
		return testData;
	}

	@DataProvider(name = "sauceBrowsersReg")
	public Object[][] sauceBrowserDataProviderReg() throws IOException {
		String excelPath = System.getProperty("user.dir")
				+ "/src/test/java/com/SauceDemoProject/TestData/CodeRedReg.xlsx";
		FileInputStream file = new FileInputStream(new File(excelPath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] testData = new Object[rowCount - 1][colCount];

		DataFormatter formatter = new DataFormatter();
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				testData[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}

		workbook.close();
		return testData;
	}

	@DataProvider(name = "updatePasswordMinLength")
	public Object[][] updatePasswordMinLength() throws IOException {
		String excelPath = System.getProperty("user.dir")
				+ "/src/test/java/com/SauceDemoProject/TestData/updatePasswordMinLength.xlsx";
		FileInputStream file = new FileInputStream(new File(excelPath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] testData = new Object[rowCount - 1][colCount];

		DataFormatter formatter = new DataFormatter();
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				testData[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}

		workbook.close();
		return testData;
	}

	@DataProvider(name = "changePasswordMinLength")
	public Object[][] changePasswordMinLength() throws IOException {
		String excelPath = System.getProperty("user.dir")
				+ "/src/test/java/com/SauceDemoProject/TestData/ChangePassword.xlsx";
		FileInputStream file = new FileInputStream(new File(excelPath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] testData = new Object[rowCount - 1][colCount];

		DataFormatter formatter = new DataFormatter();
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				testData[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}

		workbook.close();
		return testData;
	}

	@DataProvider(name = "PersonalDetails")
	public Object[][] personalDetails() throws IOException {
		String excelPath = System.getProperty("user.dir")
				+ "/src/test/java/com/SauceDemoProject/TestData/PersonalDetails.xlsx";
		FileInputStream file = new FileInputStream(new File(excelPath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] testData = new Object[rowCount - 1][colCount];

		DataFormatter formatter = new DataFormatter();
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				testData[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}

		workbook.close();
		return testData;
	}

	// URL
	public static void launchUrl() throws InterruptedException {

		getDriver().get(rbn.getString("Url"));

	}

	// Maximize Window
	public static void maxWindow() {
		getDriver().manage().window().maximize();
	}

	// Wait(Thread.sleep)
	public static void toHold(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	// getTitle
	public static void toFetchTitle() {
		String title = getDriver().getTitle();
		System.out.println(title);
	}

	// getCurrentUrl
	public static void toFetchUrl() {
		String url = getDriver().getCurrentUrl();
		System.out.println(url);
	}

	// quit browser
	public static void quitBrowser() {
		getDriver().quit();
	}

	// close browser
	public static void closeBrowser() {
		getDriver().close();
	}

	// sendkeys
//	public static String fillTextBox(WebElement ele,Object object) {
//		ele.sendKeys(object);
//	}
//	
	// click
	public static void toClickButton(WebElement element) {
		element.click();
	}

	// getText
	public static void toFetchText(WebElement elem) {
		String gettxt = elem.getText();
		System.out.println(gettxt);
	}

	// getAttribute
	public static void toFetchAttribute(WebElement elemnt, String value) {
		String txtattribute = elemnt.getAttribute(value);
		System.out.println(txtattribute);
	}

	// Actions
	public static void moveToElement(WebElement elemt) {
		Actions a = new Actions(getDriver());
		a.moveToElement(elemt).perform();
	}

	public static void dragAndDrop(WebElement srcelet, WebElement tarelet) {
		a = new Actions(getDriver());
		a.dragAndDrop(srcelet, tarelet).perform();
	}

	public static void doubleClick(WebElement elent) {
		a = new Actions(getDriver());
		a.doubleClick(elent).perform();
	}

	public static void rightClick(WebElement elemt) {
		a = new Actions(getDriver());
		a.contextClick(elemt).perform();
	}

	public static void keyUpAndDown(WebElement elemdown, String valuedown) {
		a = new Actions(getDriver());
		a.keyDown(Keys.SHIFT).sendKeys(elemdown, valuedown).keyUp(Keys.SHIFT).perform();
	}

	// Robot

	public static void copy() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}

	public static void paste() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

	// alert
	public static void alertAccept() {
		al = getDriver().switchTo().alert();
		al.accept();
	}

	public static void alertDismiss() {
		al = getDriver().switchTo().alert();
		al.dismiss();
	}

	public static void alertGetText() {
		al = getDriver().switchTo().alert();
		String t = al.getText();
		System.out.println(t);
	}

	public static void alertTextBox(String alertvalue) {
		al = getDriver().switchTo().alert();
		al.sendKeys(alertvalue);
	}

	// JavascriptExecutor
	/*
	 * public static void jssendkeys(WebElement elemsendkeys, String val) { js=
	 * (JavascriptExecutor)driver;
	 * js.executeScript("arguments[0].setAttribute('value',+"val"", elemsendkeys); }
	 */

	public static void clkRadioButtons(List<WebElement> radioButtons, String value) {

		String radioButtonToSelect = value;
		for (WebElement radioButton : radioButtons) {
			if (radioButton.getAttribute("value").equals(radioButtonToSelect)) {
				radioButton.click();
				break;
			}
		}
	}

	public static void selectradiobutton(List<WebElement> options, String value) {

		for (WebElement option : options) {
			if (option.getAttribute("id").equals(value)) {
				option.click();
				break;
			}
		}

	}

	public static void selectradiobuttonOption(List<WebElement> options) {

		for (WebElement option : options) {

			String radioButtonValue = option.getAttribute("type");
			if (radioButtonValue.contains("No")) {
				option.click();
				break;
			}
		}

	}

	public static void futureDatePickersDropDown(WebElement dropDown, WebElement dateTable, By locator) {

		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		dropDown.click();
		List<WebElement> dateCells = dateTable.findElements(locator);
		for (WebElement dateCell : dateCells) {
			String cellText = dateCell.getText();
			if (cellText.matches("\\d{1,2}")) {
				int day = Integer.parseInt(cellText);
				LocalDate cellDate = LocalDate.of(currentDate.getYear(), currentDate.getMonthValue(), day);
				if (cellDate.isAfter(currentDate)) {
					dateCell.click();
				}
			}
		}

	}

	public static void presentDatePickersDropDown(WebElement dropDown, WebElement dateTable, By locator) {

		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		dropDown.click();
		List<WebElement> dateCells = dateTable.findElements(locator);
		for (WebElement dateCell : dateCells) {
			String cellText = dateCell.getText();
			if (cellText.matches("\\d{1,2}")) {
				int day = Integer.parseInt(cellText);
				LocalDate cellDate = LocalDate.of(currentDate.getYear(), currentDate.getMonthValue(), day);
				if (cellDate.equals(currentDate)) {
					dateCell.click();
					break;
				}
			}
		}
	}

	public void javascriptexecutor(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void pgDown(WebElement pgdown) {
		js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", pgdown);
	}

	public static void pgUp(WebElement pgup) {
		js = (JavascriptExecutor) getDriver();

		js.executeScript("arguments[0].scrollIntoView(false);", pgup);
	}

	public static void pgDownClick(WebElement pgDown) {
		js = (JavascriptExecutor) getDriver();

		js.executeScript("arguments[0].scrollIntoView(false);", pgDown);
	}

	public static void scrollHeight(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)", "");
	}

	public static void scrollHeightDown() {
		js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
	}

	public static void javascriptExeClick(WebElement clickbutton) {
		js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click()", clickbutton);
	}

	public static void scrollDownToPosition(WebDriver driver) {

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");

	}

	public static void scrollDown() {

		js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,500)", "");

	}

	public static void scrollToMidPosition(WebDriver driver, WebElement ele) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)", ele);

	}

	public static void getElementLocation(WebDriver driver, WebElement ele) {
		Point elementCoordinates = ele.getLocation();
		js.executeScript("window.scrollTo(arguments[0], arguments[1]);", elementCoordinates.x, elementCoordinates.y);

	}

	// visibility check
	public static void isDisplayed(WebElement elemdis) {
		boolean dis = elemdis.isDisplayed();
		System.out.println(dis);

		if (elemdis.isDisplayed()) {
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element is not displayed");
		}
	}

	public static void isEnabled(WebElement elementenable) {
		boolean enable = elementenable.isEnabled();
		System.out.println(enable);

		if (elementenable.isEnabled()) {
			System.out.println("Element is enabled");
		} else {
			System.out.println("Element is not enabled");
		}
	}

	public static void isSelected(WebElement elementselect) {
		boolean select = elementselect.isSelected();
		System.out.println(select);

		if (elementselect.isEnabled()) {
			System.out.println("Element is selected");
		} else {
			System.out.println("Element is not selected");
		}
	}

	// capture screen
	public static String captureScreen(String testName) throws IOException {
		WebDriver driver = getDriver();

		TakesScreenshot ts = (TakesScreenshot) getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String destination = System.getProperty("user.dir") + "\\BaselineImage\\" + testName + "_" + timeStamp + ".png";
		try {
			FileUtils.copyFile(source, new File(destination));
			System.out.println("Screenshot taken");
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage());
		}
		return destination;
	}

	// Navigation commands
	public static void navigateTo(String url) {
		getDriver().navigate().to(url);
	}

	public static void forward() {
		getDriver().navigate().forward();
	}

	public static void back() {
		getDriver().navigate().back();
	}

	public static void toRefresh() {
		getDriver().navigate().refresh();
	}

	// WindowHandling
	// for loop
	public static void windowHandlingForLoop() {
		String ParentId = getDriver().getWindowHandle();
		System.out.println(ParentId);
		Set<String> allWindows = getDriver().getWindowHandles();
		System.out.println(allWindows);

		for (String eachId : allWindows) {
			if (!eachId.equals(ParentId)) {
				getDriver().switchTo().window(eachId);
			}
		}
	}

	// List
	public static void windowHandlingList(int indexvalue) {
		String ParentId = getDriver().getWindowHandle();
		System.out.println(ParentId);
		Set<String> allWindows = getDriver().getWindowHandles();
		System.out.println(allWindows);

		List<String> li = new ArrayList<>();
		li.addAll(allWindows);
		getDriver().switchTo().window(li.get(indexvalue));
	}

	// count
	public static void windowHandlingUsingCount(int indexvalue) {
		String ParentId = getDriver().getWindowHandle();
		System.out.println(ParentId);
		Set<String> allWindows = getDriver().getWindowHandles();
		System.out.println(allWindows);

		int count = 0;
		for (String x : allWindows) {
			count++;

			if (count == 3) {
				getDriver().switchTo().window(x);
				break;
			}
		}
	}

	public static void toGetOutFromWindow() {
		getDriver().switchTo().defaultContent();
	}

	// Frames
	public static void switchToFrameUsingElement(WebElement elem) {
		getDriver().switchTo().frame(elem);
	}

	public static void switchToFrameUsingIndex(int valueindex) {
		getDriver().switchTo().frame(valueindex);
	}

	public static void switchToFrameUsingName(String value) {
		getDriver().switchTo().frame(value);
	}

	public static void comeOutFromFrame() {
		getDriver().switchTo().parentFrame();
	}

	public static void comeOutFromFrameUsingDc() {
		getDriver().switchTo().defaultContent();
	}

	// select dropdowns
	public static void selectByValue(WebElement element, String value) {
		s = new Select(element);
		s.selectByValue(value);
	}

	public static void selectByVisibleText(WebElement elemen, String value) {
		s = new Select(elemen);
		s.selectByVisibleText(value);
	}

	public static void selectByIndex(WebElement element, int indvalue) {
		s = new Select(element);
		s.selectByIndex(indvalue);
	}

	public static void deselectbyindex(WebElement element, int indvalue) {
		s = new Select(element);
		s.deselectByIndex(indvalue);
	}

	public static void deSelectByVisibleText(WebElement elemen, String value) {
		s = new Select(elemen);
		s.deselectByVisibleText(value);
	}

	public static void deSelectByValue(WebElement element, String value) {
		s = new Select(element);
		s.selectByValue(value);
	}

	public static void getOptions(WebElement element) {
		s = new Select(element);
		List<WebElement> alloptions = s.getOptions();
		for (WebElement option : alloptions) {
			String toption = option.getText();
			System.out.println(toption);

		}
	}

	public static void getAllSelectedOptions(WebElement element, String value) {
		s = new Select(element);
		List<WebElement> alloptions = s.getAllSelectedOptions();
		for (WebElement option : alloptions) {
			String toption = option.getText();
			System.out.println(toption);
			Assert.assertEquals(toption, value);
		}
	}

	public static void getFirstSelectedOptions(WebElement element, String value) {
		s = new Select(element);
		WebElement option = s.getFirstSelectedOption();
		String toption = option.getText();
		System.out.println(toption);
		Assert.assertEquals(toption, value);
	}

	public static void getXoption(int indexvalue) {
		List<WebElement> alloptions = s.getOptions();
		WebElement xoption = alloptions.get(indexvalue);
		xoption.click();
	}

	// Waits

	public static void implicitWait(int seconds) {
		getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public static void webDriverWaitAlert(int intvalue) {
		w = new WebDriverWait(getDriver(), Duration.ofSeconds(intvalue));
		w.until(ExpectedConditions.alertIsPresent());
		al = getDriver().switchTo().alert();
		al.accept();

	}

	public static void webDriverWaitElementLocated(int intvalue, By locator) {
		w = new WebDriverWait(getDriver(), Duration.ofSeconds(intvalue));
		w.until(ExpectedConditions.visibilityOfElementLocated(locator));
		// driver.findElement(locator).sendKeys(value);
	}

	public static void webDriverWaitElementToBeClickable(By locator, int intvalue) {
		w = new WebDriverWait(getDriver(), Duration.ofSeconds(intvalue));
		w.until(ExpectedConditions.elementToBeClickable(locator));
		getDriver().findElement(locator).click();
	}

	public static void webDriverWaitVisibilityOfElementClick(WebElement ele, int intvalue) {
		w = new WebDriverWait(getDriver(), Duration.ofSeconds(intvalue));
		w.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
	}

	// RandomString
	public static String generateRandomPassword() {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk" + "lmnopqrstuvwxyz!@#$%&";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(10);
		for (int i = 0; i < 10; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

	public static String generateRandomnameWithOnlyUpCase() {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(10);
		for (int i = 0; i < 10; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

	public static String generateRandomPasswordWithSpchars() {
		String chars = ":;^!@#$%&";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(10);
		for (int i = 0; i < 10; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

	// Random String for emails
//	public static String generateRandomEmail() {
//		String chars = "abcdefghijk";
//		StringBuilder sb = new StringBuilder(10);
//		Random rnd = new Random();
//		while (sb.length() < 10) {
//			int index = (int) (rnd.nextFloat() * sb.length());
//			sb.append(chars.charAt(index));
//		}
//		String str = sb.toString();
//		return str;
//	}

	public static String generateRandomEmailGenerator(int length) {
		String characters = "1234567890";
		StringBuilder sb = new StringBuilder(length);
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

	public static String generateRandomEmail() {
		String randomString = generateRandomEmailGenerator(3);
		String randomName = generateRandomName(2);
		String email = "testqa" + randomString + "@gmail.com";

		return email;
	}

	public static String generateRandomName(int length) {
		String chars = "abcdefghijk";
		StringBuilder sb = new StringBuilder(10);
		Random rnd = new Random();
		for (int i = 0; i < length; i++) {
			int index = rnd.nextInt(chars.length());
			sb.append(chars.charAt(index));
		}
//		while (sb.length() < 10) {
//			int index = (int) (rnd.nextFloat() * sb.length());
//			sb.append(chars.charAt(index));
//		}
		String str = sb.toString();
		return str;
	}

	public static String generateRandomnameWithLessSize() {
		String chars = "abcdefghijk";
		StringBuilder sb = new StringBuilder(7);
		Random rnd = new Random();
		while (sb.length() < 7) {
			int index = (int) (rnd.nextFloat() * sb.length());
			sb.append(chars.charAt(index));
		}
		String str = sb.toString();
		return str;
	}

	public static String generateRandomNameWithOutCaps() {
		String chars = "a1$@#$$2";
		StringBuilder sb = new StringBuilder(10);
		Random rnd = new Random();
		while (sb.length() < 10) {
			int index = (int) (rnd.nextFloat() * sb.length());
			sb.append(chars.charAt(index));
		}
		String str = sb.toString();
		return str;
	}

	public static String generateRandomNameWithOutDig() {
		String chars = "ABCFabcdefghijk#@#$%";
		StringBuilder sb = new StringBuilder(10);
		Random rnd = new Random();
		while (sb.length() < 10) {
			int index = (int) (rnd.nextFloat() * sb.length());
			sb.append(chars.charAt(index));
		}
		String str = sb.toString();
		return str;
	}

	public static String generateRandomNameWithOutSpchars() {
		String chars = "ABCDFRGarsrtyu9878";
		StringBuilder sb = new StringBuilder(10);
		Random rnd = new Random();
		while (sb.length() < 10) {
			int index = (int) (rnd.nextFloat() * sb.length());
			sb.append(chars.charAt(index));
		}
		String str = sb.toString();
		return str;
	}

	public static String generateRandomPhoneNumber() {
		String chars = "9876543210";
		StringBuilder sb = new StringBuilder(10);
		Random rnd = new Random();
		while (sb.length() < 10) {
			int index = (int) (rnd.nextFloat() * sb.length());
			sb.append(chars.charAt(index));
		}
		String str = sb.toString();
		return str;
	}

	public static String generateRandomDigits() {
		String chars = "9876543210";
		StringBuilder sb = new StringBuilder(10);
		Random rnd = new Random();
		while (sb.length() < 10) {
			int index = (int) (rnd.nextFloat() * sb.length());
			sb.append(chars.charAt(index));
		}
		String str = sb.toString();
		return str;
	}

}
