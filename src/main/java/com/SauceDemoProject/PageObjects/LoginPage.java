package com.SauceDemoProject.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver ldriver;
	WebDriver driver;
	JavascriptExecutor js;
	public static WebDriverWait wait;
	public static Alert al;

	public LoginPage(WebDriver driver) {
		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// Login Button
	@FindBy(xpath = "//div[@class='col-lg-12 col-md-6 col-12 offset-lg-0 offset-md-3 px-lg-0 px-xl-3 d-xl-block d-none']//a[text()='Login']")
	@CacheLookup
	WebElement loginButton;

	@FindBy(xpath = "//a[@class='text-captiliation text-decoration-none pointer pl-2 primary widget-button']")
	@CacheLookup
	WebElement loginButtonWidget;
	// Username
	@FindBy(xpath = "//input[@type='email']")
	@CacheLookup
	WebElement txtUsername;

	// Password
	@FindBy(xpath = "//input[@type='password']")
	@CacheLookup
	WebElement txtPassword;

//login 
	@FindBy(xpath = "//span[text()=' Login ']")
	@CacheLookup
	WebElement clkLogin;

	@FindBy(xpath = "//img[@class='dropdown-toggle img-fluid pointer ml-md-2 h-100 rounded-circle profile-image ng-star-inserted']")
	@CacheLookup
	WebElement userImage;

	@FindBy(xpath = "//button[@title='Close']")
	@CacheLookup
	WebElement closePopup;

	@FindBy(xpath = "//button[@title='Close']")
	@CacheLookup
	WebElement closeLoginPopup;

	@FindBy(xpath = "//button[@class='dropdown-item py-1-custom pl-2 pr-5 primary font-semi-bold']")
	@CacheLookup
	WebElement btnLogout;

	public void checkAndClickLogin(int intvalue) {
        try {
            wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));

             WebElement widgetLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='text-captiliation text-decoration-none pointer pl-2 primary widget-button']")));           
            if (widgetLink != null) {
               
                js = (JavascriptExecutor) ldriver;
                js.executeScript("arguments[0].click()", widgetLink);
                WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-lg-12 col-md-6 col-12 offset-lg-0 offset-md-3 px-lg-0 px-xl-3 d-xl-block d-none']//a[text()='Login']")));
                js = (JavascriptExecutor) ldriver;
                js.executeScript("arguments[0].click()", loginButton);
                
            } else {
                WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-lg-12 col-md-6 col-12 offset-lg-0 offset-md-3 px-lg-0 px-xl-3 d-xl-block d-none']//a[text()='Login']")));
                js = (JavascriptExecutor) ldriver;
                js.executeScript("arguments[0].click()", loginButton);
            }

        } catch (Exception e) {
            System.out.println("Exception occurred in checkAndClickLogin method: " + e.getMessage());
            
        }
    }

	public void closePopup(int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		WebElement clsPopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Close']")));
		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click()", clsPopup);
	}

	public void closeLoginPopup(int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		WebElement closeLoginPopup1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Close']")));
		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click()", closeLoginPopup1);
	}

	public void clickLoginButton(int intvalue) {

		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		WebElement login1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='col-lg-12 col-md-6 col-12 offset-lg-0 offset-md-3 px-lg-0 px-xl-3 d-xl-block d-none']//a[text()='Login']")));

		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click()", login1);

	}

	public void setUsername(String uname, int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		wait.until(ExpectedConditions.visibilityOf(txtUsername));
		txtUsername.sendKeys(uname);
	}

	public void setPassword(String pwd, int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin(int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		WebElement logClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' Login ']")));
		logClick.click();
	}

	public void userImage(int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		WebElement userImage = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='btn-group dropleft dropdown']/img)[2]")));

		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click()", userImage);

	}

	public void btnLogout(int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		wait.until(ExpectedConditions.elementToBeClickable(btnLogout));
		btnLogout.click();
	}

}
