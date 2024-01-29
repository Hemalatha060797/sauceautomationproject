package com.CodeRed.Utilities;

import java.awt.AWTException;
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
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.percy.selenium.Percy;




public class BaseClassNew {

	private static final int count = 0;
	public static WebDriver driver;
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
	public static Percy percy;


	// Drivers
	
	

	@BeforeClass
	public static void setUp() throws InterruptedException {

     //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");	
		
//        ChromeOptions options= new ChromeOptions();
//        options.setCapability("goog:loggingPrefs","{\"performance\":\"ALL\"}");
//		
//		DesiredCapabilities capabilities = DesiredCapabilities.Chrome();
//		 ChromeOptions options= new ChromeOptions();
//		 options.setExperimentalOption("perfLoggingPrefs", "{\"enableNetwork\": true}");
		//ChromeOptions options= new ChromeOptions();
	//	options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	
		
		logger = Logger.getLogger("CODERED");
		PropertyConfigurator.configure("log4j.properties");
		rbn = ResourceBundle.getBundle("config");

	}
	
	
	// URL
	public static void launchUrl() throws InterruptedException {
	
	 
		driver.get(rbn.getString("Url"));
		
			}
	public static void launchUrlQA() throws InterruptedException {
		driver.get(rbn.getString("UrlQA"));
		
			}

	// Maximize Window
	public static void maxWindow() {
		driver.manage().window().maximize();
	}

	// Wait(Thread.sleep)
	public static void toHold(int time) throws InterruptedException {
		Thread.sleep(time);
	}


	// getTitle
	public static void toFetchTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	// getCurrentUrl
	public static void toFetchUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}

	// quit browser
	public static void quitBrowser() {
		driver.quit();
	}

	// close browser
	public static void closeBrowser() {
		driver.close();
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
		Actions a = new Actions(driver);
		a.moveToElement(elemt).perform();
	}

	public static void dragAndDrop(WebElement srcelet, WebElement tarelet) {
		a = new Actions(driver);
		a.dragAndDrop(srcelet, tarelet).perform();
	}

	public static void doubleClick(WebElement elent) {
		a.doubleClick(elent).perform();
	}

	public static void rightClick(WebElement elemt) {
		a.contextClick(elemt).perform();
	}

	public static void keyUpAndDown(WebElement elemdown, String valuedown) {
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
		al = driver.switchTo().alert();
		al.accept();
	}

	public static void alertDismiss() {
		al = driver.switchTo().alert();
		al.dismiss();
	}

	public static void alertGetText() {
		al = driver.switchTo().alert();
		String t = al.getText();
		System.out.println(t);
	}

	public static void alertTextBox(String alertvalue) {
		al = driver.switchTo().alert();
		al.sendKeys(alertvalue);
	}

	// JavascriptExecutor
	/*
	 * public static void jssendkeys(WebElement elemsendkeys, String val) { js=
	 * (JavascriptExecutor)driver;
	 * js.executeScript("arguments[0].setAttribute('value',+"val"", elemsendkeys); }
	 */
	
public static void clkRadioButtons(List< WebElement> radioButtons, String value) {
		
		
		String radioButtonToSelect = value;
		for(WebElement radioButton: radioButtons) {
			if(radioButton.getAttribute("value").equals(radioButtonToSelect)) {
				radioButton.click();
				break;
			}
		}
	}
public static void selectradiobutton(List<WebElement> options, String value) {

	for(WebElement option:options) {
		if(option.getAttribute("id").equals(value)) {
			option.click();
			break;
		}
	}
	

}
public static void selectradiobuttonOption(List<WebElement> options) {

	for(WebElement option:options) {
		
		String radioButtonValue= option.getAttribute("type");
		if(radioButtonValue.contains("No")) {
			option.click();
			break;
		}
	}
	

}
public static void futureDatePickersDropDown(WebElement dropDown, WebElement dateTable, By locator) {

	
	LocalDate currentDate= LocalDate.now();
	System.out.println(currentDate);
	dropDown.click();
	List<WebElement> dateCells = dateTable.findElements(locator);
	for(WebElement dateCell: dateCells) {
		String cellText= dateCell.getText();
		if(cellText.matches("\\d{1,2}")) {	
			int day= Integer.parseInt(cellText);
			LocalDate cellDate= LocalDate.of(currentDate.getYear(),currentDate.getMonthValue(), day);
			if(cellDate.isAfter(currentDate)) {
				dateCell.click();
			}
		}
	}
	

}

//public static void randomDatePickersDropDown(WebElement calenderToDateDropdown, WebElement yearDropDown,WebElement dateTable, By locator) {
//
//	calenderToDateDropdown.click();
//	Thread.sleep(4000);
//	yearDropDown.click();
//	Select s = new Select(yearDropDown);
//	List<WebElement> futureYears = yearDropDown;
//	
//
//}

public static void presentDatePickersDropDown(WebElement dropDown, WebElement dateTable, By locator) {

	
	LocalDate currentDate= LocalDate.now();
	System.out.println(currentDate);
	dropDown.click();
	List<WebElement> dateCells = dateTable.findElements(locator);
	for(WebElement dateCell: dateCells) {
		String cellText= dateCell.getText();
		if(cellText.matches("\\d{1,2}")) {	
			int day= Integer.parseInt(cellText);
			LocalDate cellDate= LocalDate.of(currentDate.getYear(),currentDate.getMonthValue(), day);
			if(cellDate.equals(currentDate)) {
				dateCell.click();
				break;
			}
		}
	}
}
	public void javascriptexecutor(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}

	public static void pgDown(WebElement pgdown) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", pgdown);
	}

	public static void pgUp(WebElement pgup) {
		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(false);", pgup);
	}

	public static void pgDownClick(WebElement pgDown) {
		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(false);", pgDown);
	}
	
	public static void scrollHeight(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)", "");
	}

	public static void scrollHeightDown() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
	}

	public static void javascriptExeClick(WebElement clickbutton) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clickbutton);
	}

	public static void scrollDownToPosition(WebDriver driver) {

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");

	}
	public static void scrollDown() {

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");

	}

	
	public static void scrollToMidPosition(WebDriver driver, WebElement ele) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)", ele);

	}
	
	public static void getElementLocation(WebDriver driver, WebElement ele) {
		Point elementCoordinates = ele.getLocation();
		js.executeScript("window.scrollTo(arguments[0], arguments[1]);", elementCoordinates.x,elementCoordinates.y);

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
	public static String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\BaselineImage\\" + tname + "_" + timeStamp + ".png";
		try {
			FileUtils.copyFile(source, new File(destination));

		} catch (Exception e) {

			e.getMessage();
		}
		return destination;
	}

	// Navigation commands
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void forward() {
		driver.navigate().forward();
	}

	public static void back() {
		driver.navigate().back();
	}

	public static void toRefresh() {
		driver.navigate().refresh();
	}

	// WindowHandling
	// for loop
	public static void windowHandlingForLoop() {
		String ParentId = driver.getWindowHandle();
		System.out.println(ParentId);
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);

		for (String eachId : allWindows) {
			if (!eachId.equals(ParentId)) {
				driver.switchTo().window(eachId);
			}
		}
	}

	// List
	public static void windowHandlingList(int indexvalue) {
		String ParentId = driver.getWindowHandle();
		System.out.println(ParentId);
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);

		List<String> li = new ArrayList<>();
		li.addAll(allWindows);
		driver.switchTo().window(li.get(indexvalue));
	}

	// count
	public static void windowHandlingUsingCount(int indexvalue) {
		String ParentId = driver.getWindowHandle();
		System.out.println(ParentId);
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);

		int count = 0;
		for (String x : allWindows) {
			count++;

			if (count == 3) {
				driver.switchTo().window(x);
				break;
			}
		}
	}

	public static void toGetOutFromWindow() {
		driver.switchTo().defaultContent();
	}

	// Frames
	public static void switchToFrameUsingElement(WebElement elem) {
		driver.switchTo().frame(elem);
	}

	public static void switchToFrameUsingIndex(int valueindex) {
		driver.switchTo().frame(valueindex);
	}

	public static void switchToFrameUsingName(String value) {
		driver.switchTo().frame(value);
	}

	public static void comeOutFromFrame() {
		driver.switchTo().parentFrame();
	}

	public static void comeOutFromFrameUsingDc() {
		driver.switchTo().defaultContent();
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

	public static void sizeOfOptionsAndDuplicate() {
		List<WebElement> alloptions = s.getOptions();
		int size = alloptions.size();
		System.out.println(size);
		Set<WebElement> s1 = new LinkedHashSet<>();
		s1.addAll(alloptions);
		if (alloptions.size() == s1.size()) {
			System.out.println("No Duplicates");
		} else {
			System.out.println("Duplicates present");
		}
	}

	// Waits

	public static void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public static void webDriverWaitAlert(int intvalue) {
		w = new WebDriverWait(driver, Duration.ofSeconds(intvalue));
		w.until(ExpectedConditions.alertIsPresent());
		al = driver.switchTo().alert();
		al.accept();

	}

	public static void webDriverWaitElementLocated(int intvalue, By locator) {
		w = new WebDriverWait(driver, Duration.ofSeconds(intvalue));
		w.until(ExpectedConditions.visibilityOfElementLocated(locator));
		// driver.findElement(locator).sendKeys(value);
	}

	public static void webDriverWaitElementToBeClickable(By locator, int intvalue) {
		w = new WebDriverWait(driver, Duration.ofSeconds(intvalue));
		w.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
	}

	public static void webDriverWaitVisibilityOfElementClick(WebElement ele, int intvalue) {
		w = new WebDriverWait(driver, Duration.ofSeconds(intvalue));
		w.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
	}

	public static void webDriverWaitVisibilityOfElementSend(WebElement ele, int intvalue, String value) {
		w = new WebDriverWait(driver, Duration.ofSeconds(intvalue));
		w.until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys(value);
	}
	public static void webDriverWaitPresenceOfElementLocated(int intvalue, By locator) {
		w = new WebDriverWait(driver, Duration.ofSeconds(intvalue));
		w.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	public static void webDriverWaitVisibilityOfElementLocated(int intvalue, By locator) {
		w = new WebDriverWait(driver, Duration.ofSeconds(intvalue));
		w.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	public static void webDriverWaitPresenceOfAllElementsLocated(int intvalue, By locator) {
		w = new WebDriverWait(driver, Duration.ofSeconds(intvalue));
		w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		
	}

	public static void fluentWait(int intvalue, int intmillis) {
		f = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(intvalue))
				.pollingEvery(Duration.ofMillis(intmillis)).ignoring(Exception.class);
	}

	// WebTable

	public static void togetAllTables(By locator) {
		List<WebElement> alltable = driver.findElements(locator);
		int nooftables = alltable.size();
		System.out.println("No of tables :" + nooftables);
	}

	public static void toGetXdata(By locator, By locaterow, By locatedata, int x) {
		WebElement table = driver.findElement(locator);
		List<WebElement> allRows = table.findElements(locaterow);
		WebElement row = allRows.get(x);
		String trow = row.getText();
		System.out.println(trow);
		List<WebElement> alldata = row.findElements(locatedata);
		for (int i = 0; i < alldata.size(); i++) {
			WebElement data = alldata.get(i);
			System.out.println(data.getText());

		}
	}

	public static void getXvalueFromSingleRow(By locator, By locatorrow, By locatordata, int value, int x, int y) {
		WebElement table = driver.findElement(locator);
		List<WebElement> allRows = table.findElements(locatorrow);
		WebElement row = allRows.get(value);
		List<WebElement> alldata = row.findElements(locatordata);

		for (int i = 0; i < alldata.size(); i++) {
			if (i == x || i == y) {
				WebElement data = alldata.get(i);
				System.out.println(data.getText());
			}

		}
	}

	public static void toPrintAllRowsWithOutHeading(By locator, By locatorrow, By locatordata, int value) {
		WebElement table = driver.findElement(locator);
		List<WebElement> allRows = table.findElements(locatorrow);
		for (int i = 0; i < allRows.size(); i++) {
			WebElement row = allRows.get(value);
			List<WebElement> alldata = row.findElements(locatordata);
			for (int j = 0; j < alldata.size(); i++) {
				WebElement data = alldata.get(i);
				System.out.println(data.getText());
			}
		}
	}

	public static void toFetchAllDataFromRows(By locator) {

		WebElement table = driver.findElement(locator);
		String txt = table.getText();
		System.out.println(txt);
	}

	public static void allDatasUsingLoop(By locator, By locatorrows, By locatorhead, By locdata) {
		WebElement table = driver.findElement(locator);
		List<WebElement> allrows = table.findElements(locatorrows);
		for (WebElement row : allrows) {
			List<WebElement> allhead = row.findElements(locatorhead);
			for (WebElement Heading : allhead) {
				System.out.println(Heading.getText());
				List<WebElement> alldata = row.findElements(locdata);
				for (WebElement data : alldata) {
					System.out.println(data.getText());
				}
			}
		}
	}

	public static void allDatasUsingPagination() {

		WebElement table1 = driver.findElement(By.xpath("//table"));
		List<WebElement> allRows = driver
				.findElements(By.xpath("//table[@class='table tableTheme table-striped']//tbody//tr"));
		int rows = allRows.size();
		System.out.println(rows);
		for (WebElement row : allRows) {
			List<WebElement> allData = row
					.findElements(By.xpath("//table[@class='table tableTheme table-striped']//tbody//tr//td"));
			for (WebElement data : allData) {
				String txt = data.getText();
				System.out.println(txt);
				driver.findElement(By.xpath(
						"//ul[@class='pagination justify-content-center']//descendant::a[contains(@title,'Next')]"))
						.click();
			}

		}

	}

	public static void toFetchXdataFromTwoRows(By locator, By locatorrows, By locatordata, int x, int y) {
		WebElement table = driver.findElement(locator);
		List<WebElement> allrows = table.findElements(locatorrows);

		for (int i = 0; i < allrows.size(); i++) {
			if (i == x || i == y) {
				WebElement row = allrows.get(i);
				List<WebElement> alldata = row.findElements(locatordata);
				for (int j = 0; j < alldata.size(); j++) {
					WebElement data = alldata.get(j);
					System.out.println(data.getText());
				}
			}
		}

	}

	public static void toFetchXdataByText(By locator, By locatorrows, By locatordata, int x, int y, String value) {
		WebElement table = driver.findElement(locator);
		List<WebElement> allrows = table.findElements(locatorrows);

		for (int i = 0; i < allrows.size(); i++) {
			if (i == x || i == y) {
				WebElement row = allrows.get(i);
				List<WebElement> alldata = row.findElements(locatordata);
				for (int j = 0; j < alldata.size(); j++) {
					WebElement data = alldata.get(j);
					String txt = data.getText();
					if (txt.equals(value)) {
						System.out.println("data" + txt);
						System.out.println("Rowno" + i);
						System.out.println("cellno" + j);
					}
				}
			}
		}

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
	public static String generateRandomEmail() {
		String chars = "abcdefghijk";
		StringBuilder sb = new StringBuilder(10);
		Random rnd = new Random();
		while (sb.length() < 10) {
			int index = (int) (rnd.nextFloat() * sb.length());
			sb.append(chars.charAt(index));
		}
		String str = sb.toString();
		return str;
	}

	public static String generateRandomname() {
		String chars = "abcdefghijk";
		StringBuilder sb = new StringBuilder(10);
		Random rnd = new Random();
		while (sb.length() < 10) {
			int index = (int) (rnd.nextFloat() * sb.length());
			sb.append(chars.charAt(index));
		}
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

//	public static void readingDataFromExcel(String fileName, String SheetName, int RowNo, int CellNo)
//			throws IOException {
//
//		File Path = new File(
//				"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files"
//						+ fileName + ".xlsx");
//		FileInputStream ExcelFile = new FileInputStream(Path);
//		ExcelWBook = new XSSFWorkbook(ExcelFile);
//		ExcelWSheet = ExcelWBook.getSheet(SheetName);
//		for (int i = 0; i < ExcelWSheet.getPhysicalNumberOfRows(); i++) {
//			XSSFRow r = ExcelWSheet.getRow(i);
//			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
//				XSSFCell c = r.getCell(j);
//				int type = c.getCellType();
//
//				String input;
//				if (type.equals(1)) {
//					input = c.getStringCellValue();
//					System.out.println(input);
//				} else if (DateUtil.isCellDateFormatted(c)) {
//					Date d = c.getDateCellValue();
//					SimpleDateFormat sim = new SimpleDateFormat("MMM dd,yyyy");
//					input = sim.format(d);
//					System.out.println(input);
//				} else {
//					double num = c.getNumericCellValue();
//					long l = (long) num;
//					input = String.valueOf(l);
//					System.out.println(input);
//				}
//			}
//		}
//	}

	
	@DataProvider(name = "UpdatePasswordMinLen")
	public static Object[][] readDataFromExcel() throws IOException {
 
		String des = System.getProperty("user.dir")+"/src/test/java/com/CodeRed/TestData/CodeRedUpdatePasswordMin.xlsx";
		try {
 
			File Path = new File(des);
				
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));
 
				}
			}
			ExcelWBook.close();
			ExcelFile.close();

 
//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
 
	}
	@DataProvider(name = "UpdatePasswordMaxLen")
	public static Object[][] readDataFromExcel1() throws IOException {
 
		String des = System.getProperty("user.dir")+"/src/test/java/com/CodeRed/TestData/CodeRedUpdatePasswordMaxLen.xlsx";
		try {
 
			File Path = new File(des);
					
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));
 
				}
			}
			ExcelWBook.close();
			ExcelFile.close();

 
//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
 
	}
	
	@DataProvider(name = "UpdatePasswordCoderedDataParticipant")
	public static Object[][] readDataFromExcelUpdatePwd() throws IOException {

		String des = System.getProperty("user.dir")+"/src/test/java/com/CodeRed/TestData/CodeRedUpdatePassword.xlsx";
		try {

			File Path = new File(des);

			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	@DataProvider(name = "loginCoderedDataParticipant")
	public static Object[][] readDataFromExce() throws IOException {
		String des = System.getProperty("user.dir")+"/src/test/java/com/CodeRed/TestData/CodeRedLogin.xlsx";
		try {

			File Path = new File(des);
				
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	@DataProvider(name = "loginCoderedDataCaseSensitivityParticipant")
	public static Object[][] readDataFromExcelCaseSensitivity() throws IOException {
		String des = System.getProperty("user.dir")+"/src/test/java/com/CodeRed/TestData/CodeRedLoginCaseSensitivity.xlsx";
		try {

			File Path = new File(des);
					
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	@DataProvider(name = "UpdatePasswordNegativeInvalidCurrent")
	public static Object[][] readDataFromExcel2() throws IOException {
	//	System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png"
		
		String des = System.getProperty("user.dir")+"/src/test/java/com/CodeRed/TestData/CodeRedUpdatePswrdNegativeInvalidCurrentPswrd.xlsx";
		try {
 
			File Path = new File(des);
					
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));
 
				}
			}
			ExcelWBook.close();
			ExcelFile.close();

 
//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
 
	}
	
	
	@DataProvider(name = "PersonalDetails")
	public static Object[][] readDataFromExcel7() throws IOException {
		String des = System.getProperty("user.dir")+"/src/test/java/com/CodeRed/TestData/CodeRedPersonalDetails.xlsx";
		try {
 
			File Path = new File(des);
					
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));
 
				}
			}
			ExcelWBook.close();
			ExcelFile.close();

 
//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
 
	}
	
	@DataProvider(name = "UpdatePasswordNegativeWithNewBelowMin")
	public static Object[][] readDataFromExcel3() throws IOException {
		String des = System.getProperty("user.dir")+"/src/test/java/com/CodeRed/TestData/CodeRedUpdatePswrdNegativeWithNewBelowMin.xlsx";
		try {
 
			File Path = new File(des);
					
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));
 
				}
			}
			ExcelWBook.close();
			ExcelFile.close();

 
//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
 
	}
	@DataProvider(name = "UpdatePasswordNegativeWithMismatch")
	public static Object[][] readDataFromExcel4() throws IOException {
 
		String des = System.getProperty("user.dir")+"/src/test/java/com/CodeRed/TestData/CodeRedUpdatePswrdNegativeWithMismatch.xlsx";
		try {
 
			File Path = new File(des);
					
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));
 
				}
			}
			ExcelWBook.close();
			ExcelFile.close();

 
//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
 
	}
	
	@DataProvider(name = "loginCoderedDataWhiteSpacesParticipant")
	public static Object[][] readDataFromExcelWhiteSpaces() throws IOException {
		String des = System.getProperty("user.dir")+"/src/test/java/com/CodeRed/TestData/CodeRedLoginWhiteSpaces.xlsx";
		try {

			File Path = new File(des);
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	@DataProvider(name = "announcementProceed")
	public static Object[][] readDataFromExcelAnnouncementProceed() throws IOException {

		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\AnnouncementProceedData.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	@DataProvider(name = "loginDataAdmin")
	public static Object[][] readDataFromExcelLoginAdmin() throws IOException {

		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\Login data.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DataProvider(name = "loginNegativeParticipant")
	public static Object[][] readDataFromExcelLoginNegative() throws IOException {

		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\LoginNegative.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@DataProvider(name = "notificationDataParticipant")
	public static Object[][] readDataFromExcelNotification() throws IOException {

		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\NotificationData.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@DataProvider(name = "STEFREEEXP")
	public static Object[][] readDataFromExcelSTEFreeExp() throws IOException {

		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\STEFreeUser.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@DataProvider(name = "STEFREEEXPADDTIME")
	public static Object[][] readDataFromExcelSTEFreeExpAddTime() throws IOException {

		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\AddTime.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	
	@DataProvider(name = "STEFREEEXPINVALID")
	public static Object[][] readDataFromExcelSTEFreeExpInvalidAnswers() throws IOException {

		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\FlagInValidAnswers.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	@DataProvider(name = "STEFREEEXPALLFLAGS")
	public static Object[][] readDataFromExcelSTEFreeExpAllFlags() throws IOException {

		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\FlagValidAnswers.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	@DataProvider(name = "STEFREEEXPALLFLAGSMASKING")
	public static Object[][] readDataFromExcelSTEFreeExpAllFlagsMasking() throws IOException {

		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\FlagMasking.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	@DataProvider(name = "STEFREEEXPALLFLAGSMASKINGINVALIDDATA")
	public static Object[][] readDataFromExcelSTEFreeExpAllFlagsMaskingInvalidData() throws IOException {

		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\FlagMaskingInvalidData.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	@DataProvider(name = "STEFREEEXPTIMER")
	public static Object[][] readDataFromExcelSTEFreeExpTimer() throws IOException {

		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\FlagTimer.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	@DataProvider(name = "notificationPrevPageParticipant")
	public static Object[][] readDataFromExcelNotificationPrevAndNextPage() throws IOException {

		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\PaginationNextAndPrev.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@DataProvider(name = "notificationFirstAndLastPage")
	public static Object[][] readDataFromExcelNotificationLastAndFirstPage() throws IOException {

		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\PaginationLastAndFirst.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}


	@DataProvider(name = "notificationBoundaryCheck")
	public static Object[][] readDataFromExcelNotificationBoundaryCheck() throws IOException {

		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\BoundaryPagination.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	
	@DataProvider(name = "SelfRegParticipant")
	public static Object[][] readDataFromExcelSelfReg() throws IOException {

		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\Self Registration Data.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@DataProvider(name = "SelfReg")
	public static Object[][] readDataFromExcelSelfRegPositive() throws IOException {

		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\SelfRegistration.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@DataProvider(name = "loginDataAllRoles")
	public static Object[][] readDataFromExcelAllRoles() throws IOException {

		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\LoginForAllRoles.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@DataProvider(name = "URLs")
	public static Object[][] readDataFromExcelUrls() throws IOException {

		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\URLs.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@DataProvider(name = "changePasswordDataParticipant")
	public static Object[][] readDataFromExcelChangePwd() throws IOException {
		try {
			File Path = new File("C:\\Users\\HemalathaManikandan\\GitHub\\Cyberq_Test_Scripts\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\ChangePasswordDataParticipant.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DataProvider(name = "changePasswordParticipantData")
	public static Object[][] readDataFromExcelChangePwdParticipantData() throws IOException {
		try {
			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\GitHub\\Cyberq_Test_Scripts\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\ChangePasswordParticipantData.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DataProvider(name = "changePasswordParticipant")
	public static Object[][] readDataFromExcelChangePwdParticipant() throws IOException {
		try {
			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\ChangePasswordParticipant.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DataProvider(name = "forgotPasswordNegative")
	public static Object[][] readDataFromExcelforgotPwdNegative() throws IOException {
		try {
			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\ForgotPasswordNegative.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

//		for (String[]dataArray: data) {
//			System.out.println(Arrays.toString(dataArray));	
//		}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DataProvider(name = "studioLoginData")
	public static Object[][] readDataFromExcelStudioLogin() throws IOException {
		try {
			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\StudioUserLoginDatas.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DataProvider(name = "ForgotPasswordData")
	public static Object[][] readDataFromExcelForgotPwd() throws IOException {
		try {
			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\ForgotPasswordData.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows][noOfColumns - 1];
			for (int i = 0; i < noOfRows; i++) {
				for (int j = 0; j < noOfColumns - 1; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i).getCell(j + 1));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DataProvider(name = "ExistingEmailAddress")
	public static Object[][] readDataFromExcelExistingEmail() throws IOException {
		try {
			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\ForgotPasswordData.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows][noOfColumns - 1];
			for (int i = 0; i < noOfRows; i++) {
				for (int j = 0; j < noOfColumns - 1; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i).getCell(j + 1));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();

			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DataProvider(name = "EmailWithoutPrefix")
	public static Object[][] readDataFromExcelForgotPwdNegative() throws IOException {
		try {
			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\EmailWithoutPrefix.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows][noOfColumns - 1];
			for (int i = 0; i < noOfRows; i++) {
				for (int j = 0; j < noOfColumns - 1; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i).getCell(j + 1));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DataProvider(name = "ChangePwdData")
	public static Object[][] readDataFromExcelChangePwdNegative() throws IOException {
		try {
			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\ChangePasswordNegative.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DataProvider(name = "ChangePwdDataParticipant")
	public static Object[][] readDataFromExcelChangePwdNegativeAllRoles() throws IOException {
		try {
			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\ChangePasswordDataParticipant.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DataProvider(name = "mergeDataProvider")
	public Object[][] mergeDataProvider(Method method) throws IOException {
		String methodName = method.getName();
		if (methodName.equals("createNewUserEmailIdWithOutPrefix")) {
			return readDataFromExcelEmailWithoutPrefix();
		} else if (methodName.equals("createNewUserEmailIdWithOutPrefix")) {
			return readDataFromExcelLogin();
		} else {
			return new Object[][] { { "No Data is Present" }, { "No Data is Present" } };
		}
	}

	public static Object[][] readDataFromExcelLogin() throws IOException {
		try {

			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\Login data.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows - 1][noOfColumns];
			for (int i = 0; i < noOfRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i + 1).getCell(j));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object[][] readDataFromExcelEmailWithoutPrefix() throws IOException {

		try {
			File Path = new File(
					"C:\\Users\\HemalathaManikandan\\eclipse-workspace\\CyberQ_2.0_Project\\src\\test\\java\\com\\CyberQ\\TestDatas\\Test Data Files\\EmailWithoutPrefix.xlsx");
			System.out.println(Path.exists());
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");
			int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();
			System.out.println(noOfRows);
			int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[][] data = new String[noOfRows][noOfColumns - 1];
			for (int i = 0; i < noOfRows; i++) {
				for (int j = 0; j < noOfColumns - 1; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(ExcelWSheet.getRow(i).getCell(j + 1));

				}
			}
			ExcelWBook.close();
			ExcelFile.close();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
//	@DataProvider(name="mergeDataProvider")
//	public String[][]mergeDataProvide() throws IOException{
//		HashMap<String,String> mp= new HashMap<String,String>();
//		mp.putAll((HashMap<String,String>)readDataFromExcel()[0][0]);
//		mp.putAll((HashMap<String,String>)readDataFromExcelForgotPwdNegative()[0][0]);
//		String [][]o = new String[1][];
//		o[0] = (String[]) new Object[] { mp };
//		return o;
//	}
//	@DataProvider
//	public Object[][] mergeData() throws IOException {
//		List<Object[]>result= Lists.newArrayList();
//		result.addAll(Arrays.asList(readDataFromExcel()));
//		result.addAll(Arrays.asList());
//		return result.toArray(new Object[result.size()][]);
//	   
//	}

//		public void printNoOfRows(By pages) {
//	    List<WebElement> allpages = driver.findElements(pages);
//	     System.out.println(allpages.size()); 	 
//	    	 for(i=0; i<=allpages.size();i++) {
//	    		
//	    	}

	/*
	 * public void allPages(List<WebElement> ele,WebElement allRows, WebElement
	 * activePage, WebElement totalRows, WebElement eleModule, WebElement eleDesc,
	 * WebElement eleDate) { // Total Pages int noOfPages = ele.size();
	 * System.out.println("Total Pages :" + noOfPages); // Read all rows
	 * 
	 * for (int p = 1; p <= noOfPages; p++) { System.out.println("Active page" +
	 * activePage.getText()); activePage.click(); // int rows = allRows.size();
	 * System.out.println("Total Rows:"+rows); System.out.println("Total Rows:" +
	 * rows); for (int r = 1; r <= rows; r++) { String Module = eleModule.getText();
	 * String Description = eleDesc.getText(); String Date = eleDate.getText();
	 * System.out.println(Module + "          " + Description + "     " + Date); }
	 * 
	 * } }
	 */

	public void allPages(List<WebElement> pages, WebElement totalRows, WebElement activePage,
			WebElement tableDataModule, WebElement tableDataDesc, WebElement tableDataDate) {

		// Total Pages
		int noOfPages = pages.size();
		System.out.println("Total Pages :" + noOfPages);
		// Read all rows
		for (int p = 1; p <= noOfPages; p++) {
			System.out.println("Active page" + activePage.getText());
			toRefresh();
			activePage.click();
			String txt = totalRows.getText();
			System.out.println(txt);
			String rowNumber = txt.substring(txt.indexOf(":") + 1);

			System.out.println("Total No of Rows:" + rowNumber);
			int row = Integer.parseInt("34");
			for (int r = 1; r <= row; r++) {
				String Module = tableDataModule.getText();
				String Description = tableDataDesc.getText();
				String Date = tableDataDate.getText();
				System.out.println(Module + "            " + Description + "                           " + Date);
			}
			String pageno = Integer.toString(p + 1);
			driver.findElement(
					By.xpath("//ul[@class='pagination justify-content-center']//descendant::a[contains(@title,'"
							+ pageno + "')]"));

		}
		return;
	}
//Notification Data

	public void dataTables(WebElement nextPage) throws InterruptedException {

		List<WebElement> allData = driver
				.findElements(By.xpath("//table[@class='table tableTheme table-striped']//tbody//tr//td[1]"));
		List<String> datas = new ArrayList<String>();

		for (WebElement data : allData) {
			datas.add(data.getText());
		}

		String nextButton = nextPage.getAttribute("class");
		while (!nextButton.contains("page-item disabled")) {
			
					nextPage.click();
					
			driver.findElements(By.xpath("//table[@class='table tableTheme table-striped']//tbody//tr//td[1]"));
			for (WebElement data : allData) {
				datas.add(data.getText());
			}
			nextButton = nextPage.getAttribute("class");
		}
		for (String printdata : datas) {
			System.out.println(printdata);
		}
		int totalDatas = datas.size();
		System.out.println("Total Datas in Table" + totalDatas);

		String rows = driver.findElement(By.xpath("//*[contains(text(),' Total:')]")).getText();
		System.out.println("Total Rows" + rows);
		Assert.assertEquals(rows, String.valueOf(totalDatas));
		toHold(5000);
	}
	
	
	public void allPageDatas(List<WebElement> pages, List<WebElement> totalRowsPrint,  WebElement activePage,
			WebElement tableDataModule, WebElement tableDataDesc, WebElement tableDataDate)
			throws InterruptedException {
		
		// Total Page
		
		int totalPage = pages.size();
		System.out.println(totalPage);

//		for (int p = 1; p <= totalPage; p++) {
//			toHold(2000);
//			String txtData = activePage.getText();
//			System.out.println("Active Page:" + txtData);
//		
			//int row = totalRows.size();
			for(int currentPage=1; currentPage<=totalPage; currentPage++) {
				toHold(2000);
				String txtData = activePage.getText();
				System.out.println("Active Page:" + txtData);
				int rowCount= totalRowsPrint.size();
				System.out.println("Page"  + currentPage+ "RowCount"+ rowCount);

			for (int r = 1; r <= rowCount; r++) {
				try {
				String dataModule = driver
						.findElement(By
								.xpath("//table[@class='table tableTheme table-striped']//tbody//tr[" + r + "]//td[1]"))
						.getText();
				String dataDesc = driver
						.findElement(By
								.xpath("//table[@class='table tableTheme table-striped']//tbody//tr[" + r + "]//td[2]"))
						.getText();
				
				String dataDate = driver
						.findElement(By
								.xpath("//table[@class='table tableTheme table-striped']//tbody//tr[" + r + "]//td[3]"))
						.getText();
				System.out.println(dataModule + "         " + dataDesc + "                                         "
						+ dataDate + "              ");
				}
			
				catch(Exception e) {
					
					driver
						.findElement(By
								.xpath("//table[@class='table tableTheme table-striped']//tbody//tr[" + r + "]//td[3]"))
						.getText();
					
				}
			}
			
			toHold(12000);
			String pageno = Integer.toString(currentPage + 1);
			int pn= Integer.parseInt(pageno);
			if(pn>totalPage) {
				break;
			}
			
			WebElement ele = driver.findElement(By.xpath("//ul[@class='pagination justify-content-center']//descendant::a[contains(@title,'"+ pageno + "')]"));
			ele.click();
			
			
			
			toHold(10000);
			
		
		
			}
		}	

	public void allPageDatasNew(List<WebElement> pages, List<WebElement> totalRowsPrint, WebElement activePage,
			WebElement tableDataModule, WebElement tableDataDesc, WebElement tableDataDate)
			throws InterruptedException {
		
		// Total Page
		
		int totalPage = pages.size();
		System.out.println(totalPage);

//		for (int p = 1; p <= totalPage; p++) {
//			toHold(2000);
//			String txtData = activePage.getText();
//			System.out.println("Active Page:" + txtData);
//		
			//int row = totalRows.size();
			for(int currentPage=1; currentPage<=totalPage; currentPage++) {
				toHold(2000);
				String txtData = activePage.getText();
				System.out.println("Active Page:" + txtData);
		
				int rowCount= totalRowsPrint.size();
				System.out.println("Page"  + currentPage+ "RowCount"+ rowCount);
				
			for (int r = 1; r <= rowCount; r++) {
				try {
				String dataModule = driver
						.findElement(By
								.xpath("//table[@class='table tableTheme table-striped']//tbody//tr[" + r + "]//td[1]"))
						.getText();
				String dataDesc = driver
						.findElement(By
								.xpath("//table[@class='table tableTheme table-striped']//tbody//tr[" + r + "]//td[2]"))
						.getText();
				
				String dataDate = driver
						.findElement(By
								.xpath("//table[@class='table tableTheme table-striped']//tbody//tr[" + r + "]//td[3]"))
						.getText();
				System.out.println(dataModule + "         " + dataDesc + "                                         "
						+ dataDate + "              ");
				}
			
				catch(Exception e) {
					
					driver
						.findElement(By
								.xpath("//table[@class='table tableTheme table-striped']//tbody//tr[" + r + "]//td[3]"))
						.getText();
					
				}
			}
			
			toHold(12000);
			String pageno = Integer.toString(currentPage + 1);
			int pn= Integer.parseInt(pageno);
			if(pn>totalPage) {
				break;
			}
			
			WebElement ele = driver.findElement(By.xpath("//ul[@class='pagination justify-content-center']//descendant::a[contains(@title,'"+ pageno + "')]"));
			ele.click();
			
			
			
			toHold(10000);
			
		
		
			}
			
		}	

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(12000);
		driver.quit();
	}
}
