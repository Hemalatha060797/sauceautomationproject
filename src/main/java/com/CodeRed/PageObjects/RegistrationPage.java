package com.CodeRed.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {


	WebDriver ldriver;
	WebDriver driver;
	JavascriptExecutor js;
   
	public RegistrationPage(WebDriver rdriver) {
    	ldriver= rdriver;
		PageFactory.initElements(rdriver, this);	
	}

	//Login Button
	@FindBy(xpath="(//input[@placeholder='First Name'])[1]")
	@CacheLookup
	WebElement firstName;
	
	// Email
	
	@FindBy(xpath="(//input[@placeholder='Email'])[1]")
	@CacheLookup
	WebElement Email;
	
	//password
	@FindBy(xpath="(//input[@placeholder='Password'])[1]")
	@CacheLookup
	WebElement Password;
	
	
	@FindBy(xpath="(//input[@type='checkbox'])[1]")
	@CacheLookup
	WebElement checkBox;
	
	@FindBy(xpath="(//span[text()=' Start Learning Now For Free '])[1]")
	@CacheLookup
	WebElement signUp;
	
	
	
	@FindBy(xpath="//a[text()='Start']")
	@CacheLookup
	WebElement startButton;
	
		
	
	@FindBy(xpath="//div[@class='radius-10 category py-5 light-blue-shadow d-flex justify-content-center align-items-center text-center']")
	@CacheLookup
	List<WebElement> categoriesFirstPage;
	
		
	@FindBy(xpath="//div[@class='radius-10 category py-5 light-blue-shadow d-flex justify-content-center align-items-center text-center']")
	@CacheLookup
	List<WebElement> categoriesSecondPage;
	
	@FindBy(xpath="//div[@class='radius-10 category py-5 light-blue-shadow text-center h-100 d-flex justify-content-center align-items-center text-center']")
	@CacheLookup
	List<WebElement> categoriesFourthPage;
	
	
	
	@FindBy(xpath="//div[@class='ng-star-inserted']")
	@CacheLookup
	List<WebElement> categoriesThirdPage;
	
	
	@FindBy(xpath="(//span[text()=' Next '])[1]")
	@CacheLookup
	WebElement nextButton;
	
			
	@FindBy(xpath="(//span[text()=' Next '])[1]")
	@CacheLookup
	WebElement finishButton;		
	
	
	@FindBy(xpath="//a[text()='Go To Dashboard']")
	@CacheLookup
	WebElement goToDashboard;
	
	
	@FindBy(xpath="(//img[@src='./assets/image/logo-white.png'])[1]")
	@CacheLookup
		WebElement imgEccouncilLearning;
	
	public void img() {
		String text = imgEccouncilLearning.getText();
		System.out.println(text);
	}
	public void firstName(String uname) {
		firstName.sendKeys(uname);
	}
	
	public void email(String uname) {
		Email.sendKeys(uname);
	}
	
	public void password(String uname) {
		Password.sendKeys(uname);
	}
	
	public void checkBox() {
		checkBox.click();
	}
	
	public void signUp() {
		signUp.click();
	}
	
	public void startButton() {
		startButton.click();
	}
	
	public void categoriesFirstPage() {
		List<WebElement> fpelems = ldriver.findElements(By.xpath("//div[@class='radius-10 category py-5 light-blue-shadow d-flex justify-content-center align-items-center text-center']"));
        for(int i =0; i<=fpelems.size();i++) {
		
		if(i==0 || i==2) {
			WebElement data = fpelems.get(i);
		
			String text = data.getText();
			System.out.println(text);
			data.click();
		}
			
}
	
	}
	
	
	
	public void categoriesSecondPage() {
		List<WebElement> fpelems = ldriver.findElements(By.xpath("//div[@class='radius-10 category py-5 light-blue-shadow d-flex justify-content-center align-items-center text-center']"));
        for(int i =0; i<=fpelems.size();i++) {
		
		if(i==0) {
			WebElement data = fpelems.get(i);
		
			String text = data.getText();
			System.out.println(text);
			data.click();
		}
			
}
	
	}
	
	
	public void categoriesThirdPage() {
		List<WebElement> fpelems = ldriver.findElements(By.xpath("//div[@class='ng-star-inserted']"));
        for(int i =0; i<=fpelems.size();i++) {
		
		if(i==0) {
			WebElement data = fpelems.get(i);
		
			String text = data.getText();
			System.out.println(text);
			data.click();
		}
			
}
	
	}
	
	public void categoriesFourthPage() {
		List<WebElement> fpelems = ldriver.findElements(By.xpath("//div[@class='radius-10 category py-5 light-blue-shadow text-center h-100 d-flex justify-content-center align-items-center text-center']"));
        for(int i =0; i<=fpelems.size();i++) {
		
		if(i==1 || i==2) {
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
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}

	public void finishButton() {
		finishButton.click();
	}
	
	public void goToDashboard() {
		goToDashboard.click();
	}
	
	
	
	
	
}
