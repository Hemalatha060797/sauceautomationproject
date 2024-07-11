package com.SauceDemoProject.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

	WebDriver ldriver;
	WebDriver driver;
	JavascriptExecutor js;
	public static WebDriverWait wait;
	public static Actions a;

	public RegistrationPage(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[text()='Get Free Access'])[2]")
	@CacheLookup
	WebElement getFreeAccess;
	
	
	@FindBy(xpath = "//a[text()='Create Your Free Account Now']")
	@CacheLookup
	WebElement createFreeAcnt;

	@FindBy(xpath = "//span[@class='select2-selection select2-selection--single']")
	@CacheLookup
	WebElement country;

	@FindBy(xpath = "//input[@type='search']")
	@CacheLookup
	WebElement selectCountrySearchField;

	// Login Button
	@FindBy(xpath = "(//input[@placeholder='First Name'])[1]")
	@CacheLookup
	WebElement firstName;

	// Email

	@FindBy(xpath = "(//input[@placeholder='Email'])[1]")
	@CacheLookup
	WebElement email;

	// password
	@FindBy(xpath = "(//input[@placeholder='Password'])[1]")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	@CacheLookup
	WebElement checkBox;

	@FindBy(xpath = "//span[text()=' Get Started ']")
	@CacheLookup
	WebElement signUp;

	@FindBy(xpath = "//button[text()=' Start ']")
	@CacheLookup
	WebElement startButton;

	@FindBy(xpath = "//div[@class='radius-10 category py-5 light-blue-shadow d-flex justify-content-center align-items-center text-center']")
	@CacheLookup
	List<WebElement> categoriesFirstPage;

	@FindBy(xpath = "//div[@class='radius-10 category py-5 light-blue-shadow d-flex justify-content-center align-items-center text-center']")
	@CacheLookup
	List<WebElement> categoriesSecondPage;

	@FindBy(xpath = "//div[@class='radius-10 category py-5 light-blue-shadow text-center h-100 d-flex justify-content-center align-items-center text-center']")
	@CacheLookup
	List<WebElement> categoriesFourthPage;

	@FindBy(xpath = "//div[@class='ng-star-inserted']")
	@CacheLookup
	List<WebElement> categoriesThirdPage;

	@FindBy(xpath = "(//span[text()=' Next '])[1]")
	@CacheLookup
	WebElement nextButton;

	@FindBy(xpath = "(//span[text()=' Finish '])[1]")
	@CacheLookup
	WebElement finishButton;

	@FindBy(xpath = "//button[text()=' Go To Dashboard ']")
	@CacheLookup
	WebElement goToDashboard;

	@FindBy(xpath = "(//img[@src='./assets/image/logo-white.png'])[1]")
	@CacheLookup
	WebElement imgEccouncilLearning;

	@FindBy(xpath = "//div[@class='btn-group dropleft dropdown']//img[@class='dropdown-toggle img-fluid pointer ml-md-2 h-100 rounded-circle profile-image ng-star-inserted']")
	@CacheLookup
	WebElement userImage;

	@FindBy(xpath = "//button[@title='Close']")
	@CacheLookup
	WebElement closeRegPopup;

	@FindBy(xpath = "//button[@class='dropdown-item py-1-custom pl-2 pr-5 primary font-semi-bold']")
	@CacheLookup
	WebElement btnLogout;

	@FindBy(xpath = "//div[text()='The email has already been taken.']")
	@CacheLookup
	WebElement invalidEmail;

	public WebElement invalidEmail() {
		return invalidEmail;
	}

	

	public void attemptGetStartedEmailExists(int value, String uname) throws InterruptedException {
	   
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(value));
	    boolean emailValid = false;
	    int maxAttempts = 5; // Define the maximum number of attempts to try
	    JavascriptExecutor js = (JavascriptExecutor) ldriver;
	    for (int attempt = 0; attempt < maxAttempts && !emailValid; attempt++) {
	        try {
	            WebElement emailField = ldriver.findElement(By.xpath("(//input[@placeholder='Email'])[1]"));

	            // Check for "The email has already been taken." message
	            try {
	                WebElement emailExistsElement = wait.until(ExpectedConditions
	                        .visibilityOfElementLocated(By.xpath("//div[text()='The email has already been taken.']")));
	                if (emailExistsElement.isDisplayed()) {
	                    System.out.println("Email already exists");
	                    Thread.sleep(5000);
	                    emailField.clear();
	                    emailField.sendKeys(uname);
	                   System.out.println("Passed new email in the EmailField as it already exists");
	                   continue;
	                }
	            } catch (Exception e) {
	                System.out.println("Email does not exist");
	                emailValid = true;
	            }

	            Thread.sleep(5000);

	            // Check for "Email is invalid" message
	            try {
	                WebElement invalidEmailElement = wait.until(ExpectedConditions
	                        .visibilityOfElementLocated(By.xpath("//span[text()='Email is invalid ']")));
	                if (invalidEmailElement.isDisplayed()) {
	                    System.out.println("Invalid email address");
	                    emailField.clear();
	                    emailField.sendKeys(uname); // Retry with the new email
	                    System.out.println("Passed new email in the EmailField as it is Invalid");
	                    continue;
	                }
	            } catch (TimeoutException e1) {
	                // If neither error message is found, proceed as email is valid
	                System.out.println("Email is valid");
	                emailValid = true; // Proceed as email is valid
	            }

	            WebElement getStart = ldriver.findElement(By.xpath("//span[text()=' Get Started ']"));
	            if (getStart.isDisplayed()) {
	                Thread.sleep(10000);
	                getStart.click();
	                System.out.println("Clicked on Get Started");
	                break; // Exit the loop after clicking
	            }
	        } catch (Exception e) {
	            System.out.println("An error occurred while attempting to get started.");
	        }
	    }

	    if (!emailValid) {
	        System.out.println("Failed to get a valid email after " + maxAttempts + " attempts.");
	       
	      
	       
	    }
	    
	   
	}
	
	


	public void closeRegPopup(int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Close']")));
		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click()", closeRegPopup);
	}

	public void img() {
		String text = imgEccouncilLearning.getText();
		System.out.println(text);
	}

	public void firstName(String uname, int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.sendKeys(uname);
	}

	public void getFreeAccess(int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		wait.until(ExpectedConditions.visibilityOf(getFreeAccess));
		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click()", getFreeAccess);
	}
	
	public void clickFreeAccess(int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		wait.until(ExpectedConditions.visibilityOf(createFreeAcnt));
		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click()", createFreeAcnt);
	}
	
	public void countryDropdown() throws InterruptedException {
		Thread.sleep(8000);
		country.click();

		selectCountrySearchField.sendKeys("India");

		List<WebElement> elem = ldriver.findElements(By.xpath("//ul[@class='select2-results__options']//li"));
		if (elem.size() > 1) {
			elem.get(1).click();
		}
	}

//	public void selectCountry() throws InterruptedException {
//
//		int s = selectCountry.size();
//		System.out.println(s);
//
//		for (WebElement sel : selectCountry) {
//			WebElement ele = ldriver
//					.findElement(By.xpath("//span[@class='select2-results']//descendant::li[text()=' India ']"));
//			String text = ele.getText();
//			String text1 = sel.getText();
//			if (text1.equals(text)) {
//				js = (JavascriptExecutor) ldriver;
//				js.executeScript("arguments[0].click()", sel);
//				Thread.sleep(10000);
//
//			}
//		}
//
//		Thread.sleep(12000);
//
//	}

	public void email(String uname, int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		wait.until(ExpectedConditions.visibilityOf(email));

		email.sendKeys(uname);
		System.out.println(email.getText());

	}

	public void password(String uname) {
		password.sendKeys(uname);
	}

	public void checkBox() {
		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click()", checkBox);
	}

	public WebElement getStartedButton() {
		return signUp;
	}

	public void signUp(int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		wait.until(ExpectedConditions.visibilityOf(signUp));
		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click()", signUp);

	}

	public void startButton(int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		wait.until(ExpectedConditions.visibilityOf(startButton));
		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click()", startButton);

		// startButton.click();
	}

	public void categoriesFirstPage() {
		List<WebElement> fpelems = ldriver
				.findElements(By.xpath("//div[@class='col-12']//div[@class='py-2 font-semi-bold fs-1-3 unselected']"));
		for (int i = 0; i <= fpelems.size(); i++) {

			if (i == 0 || i == 2) {
				WebElement data = fpelems.get(i);

				String text = data.getText();
				System.out.println(text);
				data.click();
			}

		}

	}

	public void categoriesSecondPage() {
		List<WebElement> fpelems = ldriver
				.findElements(By.xpath("//div[@class='col-12']//div[@class='py-2 font-semi-bold unselected']"));
		for (int i = 0; i <= fpelems.size(); i++) {

			if (i == 0) {
				WebElement data = fpelems.get(i);

				String text = data.getText();
				System.out.println(text);
				data.click();
			}

		}

	}

	public void categoriesThirdPage() {
		List<WebElement> fpelems = ldriver
				.findElements(By.xpath("//div[@class='col-12']//div[@class='py-2 font-semi-bold unselected']"));
		for (int i = 0; i <= fpelems.size(); i++) {

			if (i == 0) {
				WebElement data = fpelems.get(i);

				String text = data.getText();
				System.out.println(text);
				data.click();
			}

		}

	}

	public void categoriesFourthPage() {
		List<WebElement> fpelems = ldriver
				.findElements(By.xpath("//div[@class='col-12']//div[@class='py-2 font-semi-bold fs-1-1 unselected']"));
		for (int i = 0; i <= fpelems.size(); i++) {

			if (i == 1 || i == 2) {
				WebElement data = fpelems.get(i);

				String text = data.getText();
				System.out.println(text);
				data.click();
			}

		}

	}

	public void nextButton() {

		try {
			WebElement elemNext = ldriver.findElement(By.xpath("(//span[text()=' Next '])[1]"));
			elemNext.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void finishButton(int intvalue) throws InterruptedException {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		wait.until(ExpectedConditions.visibilityOf(finishButton));

		finishButton.click();
		Thread.sleep(10000);

	}

	public void goToDashboard(int intvalue) {
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(intvalue));
		wait.until(ExpectedConditions.visibilityOf(goToDashboard));
		goToDashboard.click();
	}

}
