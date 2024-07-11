package com.SauceDemoProject.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalDetailsPage2 {

	WebDriver ldriver;
	WebDriver driver;
	JavascriptExecutor js;
	public static WebDriverWait wait;

	public PersonalDetailsPage2(WebDriver driver) {
		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// UserProfile
	@FindBy(xpath = "(//div[@class='btn-group dropleft dropdown']//img)[2]")
	@CacheLookup
	WebElement userProfile;

	@FindBy(xpath = "(//button[@class='dropdown-item py-2 pl-2 pr-5 primary font-semi-bold drop-border'])[1]")
	@CacheLookup
	WebElement profile;

	// Personal Details
	@FindBy(xpath = "//span[text()='Personal Details']")
	@CacheLookup
	WebElement personaldetails;

	// First Name
	@FindBy(xpath = "//input[@placeholder='First Name']")
	@CacheLookup
	WebElement firstname;

	// Last Name
	@FindBy(xpath = "(//input[@type='text'])[2]")
	@CacheLookup
	WebElement lastname;

	// Email
	@FindBy(xpath = "//input[@placeholder='Email']")
	@CacheLookup
	WebElement emailid;

	// Mobile
	@FindBy(xpath = "//input[@placeholder='Mobile']")
	@CacheLookup
	WebElement mobilenum;

	@FindBy(xpath = "//select[@class='form-control form-control-lg custom-option radius-5 placholder-color ng-untouched ng-pristine ng-valid']")
	@CacheLookup
	WebElement clkDropDown;

	@FindBy(xpath = "//select[@class='form-control form-control-lg custom-option radius-5 placholder-color ng-untouched ng-pristine ng-valid']//option")
	@CacheLookup
	List<WebElement> selectDropDown;

	// Verify your current password
	@FindBy(xpath = "//input[@placeholder='enter your password ...']")
	@CacheLookup
	WebElement currentpassword;

	// Save Changes Button
	@FindBy(xpath = "//span[text()=' Save Changes ']")
	@CacheLookup
	WebElement savechangesBtn;

	// Logout
	@FindBy(xpath = "(//button[text()='Log Out'])[2]")
	@CacheLookup
	WebElement btnLogout;

	public WebElement countryDropdwn() {
		return clkDropDown;
	}

	public void clickLoginNew(int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		WebElement logClick1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' Login ']")));
		logClick1.click();
	}

	public void clickLoginButtonNew(int intvalue) {

		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		WebElement loginch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='col-lg-12 col-md-6 col-12 offset-lg-0 offset-md-3 px-lg-0 px-xl-3 d-xl-block d-none']//a[text()='Login']")));

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", loginch);

	}

	public void userPro(int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		WebElement usP = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//div[@class='btn-group dropleft dropdown']/img)[2]")));
		usP.click();
	}

	public void profile(int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		WebElement prof = wait.until(ExpectedConditions.elementToBeClickable(profile));
		prof.click();

	}
	
	public void closePopup(int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		WebElement clsPopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Close']")));
		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click()", clsPopup);
		}

	public void personalDetails() {
		personaldetails.click();
	}

	public void firstName(String fstname, int intvalue) {

		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		wait.until(ExpectedConditions.visibilityOf(firstname));
		firstname.clear();
		firstname.sendKeys(fstname);
	}

	public void lastName(String lstname) {
		lastname.clear();
		lastname.sendKeys(lstname);
	}

	public void emailId(String email) {
		emailid.clear();
		emailid.sendKeys(email);
	}

	public void mobileNum(String mobile, int intvalue) {

		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		WebElement mobileph = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Mobile']")));
		mobileph.clear();
		mobileph.sendKeys(mobile);
	}

	public void countryName() throws InterruptedException {
		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click()", clkDropDown);
	
		for (WebElement selC : selectDropDown) {
			String text = selC.getText();
			if (text.equals("India")) {
				selC.click();
			} else {
				System.out.println("India is not available");
			}
		}

	}

//	public void displayname(String oldpass) {
//		countryname.sendKeys(oldpass);
//	}

	public void currentPassword(String crntpass) {
		currentpassword.sendKeys(crntpass);
	}

	public void savechangesBtn() {
		savechangesBtn.click();
	}

	public void btnLogout() {
		btnLogout.click();
	}

}
