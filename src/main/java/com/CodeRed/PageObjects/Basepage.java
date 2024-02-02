package com.CodeRed.PageObjects;

import java.time.Duration;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.Keys;

public class Basepage {

	WebDriver driver;

	public Basepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "div.loader")
	public WebElement spinner;

	@FindBy(xpath = "//button[@title='Close']")
	public WebElement closeBtn;

	@FindBy(xpath = "//div[@id=\"navbarSupportedContent\"] //div[@ngbdropdown]")
	public WebElement profileIcon;

	@FindBy(xpath = "//div[@class='btn-group dropleft dropdown']")
	public WebElement profileIconQA;

	@FindBy(xpath = "//button[text()='Log Out']")
	public WebElement logOutbtn;

	@FindBy(xpath = "//input[@placeholder=\"Email\"]/following-sibling::small //span[@class=\"badge tertiary\"]")
	public WebElement invalidEmail;

	@FindBy(xpath = "//input[@placeholder=\"Last Name\"]/following-sibling::small //span[@class=\"badge tertiary\"]")
	public WebElement invalidLastName;

	@FindBy(xpath = "//input[@placeholder=\"First Name\"]/following-sibling::small //span[@class=\"badge tertiary\"]")
	public WebElement invalidFirstName;

	@FindBy(xpath = "//span[@patternalidationerror]")
	public WebElement invalidPasswrd;

	@FindBy(xpath = "(//input[@placeholder='Email'])")
	public WebElement email;

	@FindBy(xpath = "(//input[@placeholder='Password'])")
	public WebElement psswrd;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	public WebElement lastName;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	public WebElement firstName;

	@FindBy(xpath = "(//a[contains(@class,'navbar-brand ')])[1]")
	public WebElement eccouncilIcon;

	@FindBy(xpath = "//input[@placeholder='Enter Email']/following-sibling::small //span[@class='badge tertiary']")
	public WebElement invalidForgotEmail;

	@FindBy(xpath = "(//a[@class='tertiary pointer'])[1]")
	public WebElement resetButton;

	@FindBy(xpath = "//button//span[text()=' Reset ']")
	public WebElement reset;

	public void checkInvalidResetEmailMsg(WebElement element, String text) throws InterruptedException {
		this.sendKeys(element, text);
		Thread.sleep(2000);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(invalidForgotEmail));
		} catch (RuntimeException e) {
			System.out.println("Invalid Email Message is not visible");
			Assert.assertEquals("", " Invalid Email Message is not visible ");
		}
		String invalidEmailMsg = this.getText(this.invalidForgotEmail);
		Assert.assertEquals(invalidEmailMsg, " Invalid Email Address ","For Invalid input "+ text +" message didn't match");
	}

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		return (st + "Aa@" + num);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}

	public void spinnerloader() {
		// waiting for page to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(spinner));
//	    	if(closebtn.isDisplayed()){
//	    		wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
//	    	}
	}

	public void logout() {
		this.moveAndClick(profileIcon);
		this.moveAndClick(logOutbtn);
		this.spinnerloader();
	}

	public void logoutQA() {
		this.moveAndClick(profileIconQA);
		this.moveAndClick(logOutbtn);
		this.spinnerloader();
	}

	public void navigate() {
		driver.get("https://uat-eccl.eccouncil.org/?logged=false");
	}

	public void navigateQA() {
		driver.get("http://172.176.154.11/?logged=false");
	}

	public void click(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void moveAndClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void sendKeys(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
	}

	public void checkInvalidPasswordMsg(WebElement element, String text) throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			wait.until(ExpectedConditions.visibilityOf(invalidPasswrd));
		} catch (RuntimeException e) {
			System.out.println("Invalid Password Message is not visible");
		}
		String invalidPasswordMsg = this.getText(this.invalidPasswrd);
		Assert.assertEquals(invalidPasswordMsg,
				"Password should have numbers, special characters, upper case and lower case letters and at minimum the length to be 8 characters");
	}

	public void checkInvalidEmailMsg(WebElement element, String text) throws InterruptedException {
		this.sendKeys(element, text);
		this.click(this.psswrd);
		Thread.sleep(3000);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(invalidEmail));
		} catch (RuntimeException e) {
			System.out.println("Invalid Email Message is not visible");
		}
		String invalidEmailMsg = this.getText(this.invalidEmail);
		Assert.assertEquals(invalidEmailMsg, " Invalid Email Address ");
	}

	public void checkInvalidFirstNameMsg(WebElement element, String text) throws InterruptedException {
		this.sendKeys(element, text);
		Thread.sleep(3000);
		this.click(this.email);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(invalidFirstName));
		} catch (RuntimeException e) {
			System.out.println("Invalid First Name Message is not visible");
//			Assert.assertEquals("", " First Name Message is not visible");
		}
		String invalidFstNameMsg = this.getText(this.invalidFirstName);
		Assert.assertEquals(invalidFstNameMsg, "First name should have only letters",
				"Invalid First message is not visible");
	}

	public void checkInvalidLastNameMsg(WebElement element, String text) throws InterruptedException {
		this.sendKeys(element, text);
		Thread.sleep(3000);
		this.click(this.email);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(invalidLastName));
		} catch (RuntimeException e) {
			System.out.println("Invalid Last Name Message is not visible");
//			Assert.assertEquals("", " Last Name Message is not visible ");
		}
		String invalidLstNameMsg = this.getText(this.invalidLastName);
		Assert.assertEquals(invalidLstNameMsg, "Last name should have only letters",
				"Invalid last Name message is not visible");
	}

	public String getText(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			return (wait.until(ExpectedConditions.visibilityOf(element)).getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public void isDisable(WebElement element, String mesg) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		Assert.assertEquals(element.isEnabled(), false, mesg);
	}

	public void isEnable(WebElement element, String mesg) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		Assert.assertEquals(element.isEnabled(), true, mesg);
	}

	public void isDisable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		Assert.assertEquals(element.isEnabled(), false);
	}

	public void isEnable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		Assert.assertEquals(element.isEnabled(), true);
	}

	public void clear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element))
				.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}

	public String[] arrayGettext(String xpath) {
		List<WebElement> list = driver.findElements(By.xpath(xpath));
		String[] data = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", list.get(i));
			data[i] = list.get(i).getText();
		}
		return data;
	}

	public WebElement getOption(String xpath, int numberOfOption) {
		List<WebElement> list = driver.findElements(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", list.get(numberOfOption - 1));
		return list.get(numberOfOption - 1);
	}

	public boolean isExisting(String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
			return true; // Element found
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false; // Element not found
		}
	}
}
