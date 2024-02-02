package com.CodeRed.PageObjects;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class AccountRegistrationPage extends Basepage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	public String name = this.randomString();
	
	 
	@FindBy(xpath = "(//a[text()='Get Free Access'])[1]")
	public WebElement getFree ;
	
	@FindBy(xpath = "//a[text()='Create Your Free Account Now']")
	public WebElement createAccount;
	
	@FindBy(xpath ="(//input[@placeholder='First Name'])")
	public WebElement firstName;
	
	@FindBy(xpath ="(//input[@placeholder='Email'])")
	public WebElement email;
	
	@FindBy(xpath ="(//input[@placeholder='Password'])")
	public WebElement psswrd;
	
    @FindBy(xpath = "//span[@title='Country']")
    public WebElement countryId;
    
    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement chkbox;
    
    @FindBy(xpath = "//button[@title='Close']")
    public WebElement closeBtn;
    
    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement submit;
 
    @FindBy(xpath = "//a[@class='navbar-brand w-15 d-md-block d-none mx-4 my-3']")
    public WebElement logo;
    
    @FindBy(xpath = "//h2[@class='text-white py-1 mb-1 font-semi-bold']")
    public WebElement header;
    
    @FindBy(xpath = "//h5[@class='font-regular text-white mb-5 mt-3 w-lg-75 lh-1-8'] ")
    public WebElement header1;
  
    @FindBy(xpath = "//button[text()=' Start ']")
    public WebElement strtBtn;
    
    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement nxtBtn;
    
    @FindBy(xpath = "div.loader")
    public WebElement spinner;
    
    @FindBy(xpath = "//a[text()='Go To Dashboard']")
    public WebElement dashBoard;
    
    @FindBy(xpath = "//h1[@class='text-white py-1 mb-1 font-semi-bold d-none d-md-block']")
    public WebElement thankMsg;
    
    @FindBy(xpath = "//h2[@class='primary font-semi-bold']")
    public WebElement dashboardMsg;
    
    @FindBy(xpath = "//input[@placeholder=\"Email\"]/following-sibling::small //span[@class=\"badge tertiary\"]")
	public WebElement invalidEmail;
    
    @FindBy(xpath = "//span[@patternalidationerror]")
	public WebElement invalidPasswrd;
    
    @FindBy(xpath = "//h4[text()=' Choose up to 4 categories that interest you the most. ']")
    public WebElement subheader;
  
    @FindBy(xpath = "//h4[@class='header-color font-semi-bold fs-14']")
    public WebElement subheader1;
    
    @FindBy(xpath = "//h4[@class='header-color font-semi-bold fs-14']")
    public WebElement subheader2;
  
    @FindBy(xpath = "//h4[@class='header-color font-semi-bold fs-14']")
    public WebElement subheader3;
    
    @FindBy(xpath = "//h5[@class='font-regular text-white mb-5 mt-3 w-lg-75 lh-1-8']")
    public WebElement thanksubheader;
    
    @FindBy(xpath = "//p//span")
	public WebElement popmsg;
  
    
    @FindBy(xpath = "//div[text()=' Intelligence']")
   	public WebElement cat1;
    

    
    @FindBy(xpath = "//div[text()=' Vulnerability Assessment and Pentesting']")
   	public WebElement cat2;
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
	
  	
 
  	
	@FindBy(xpath = "(//label[text()=\" First Name\"])[1]")
	public WebElement firstNameLabel;

	@FindBy(xpath = "(//label[text()=\" Email\"])[1]")
	public WebElement emailLabel;

	@FindBy(xpath = "(//label[text()=\" Password\"])[1]")
	public WebElement password;


		public void img() {
		String text = imgEccouncilLearning.getText();
		System.out.println(text);
	}
  	
  	
  	public void firstName(String uname) {
  		firstName.sendKeys(uname);
  	}
  	
  	public void cat1() {
  		cat1.click();
  	}
  	public void cat2() {
  		cat2.click();
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
		List<WebElement> fpelems = driver.findElements(By.xpath("//div[@class='radius-10 category py-5 light-blue-shadow d-flex justify-content-center align-items-center text-center']"));
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
		List<WebElement> fpelems = driver.findElements(By.xpath("//div[@class='radius-10 category py-5 light-blue-shadow d-flex justify-content-center align-items-center text-center']"));
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
		List<WebElement> fpelems = driver.findElements(By.xpath("//div[@class='ng-star-inserted']"));
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
		List<WebElement> fpelems = driver.findElements(By.xpath("//div[@class='radius-10 category py-5 light-blue-shadow text-center h-100 d-flex justify-content-center align-items-center text-center']"));
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
  		WebElement elemNext = driver.findElement(By.xpath("(//span[text()=' Next '])[1]"));
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
  	
  	
  	
  	
    public void getFreeAccess() {
    	getFree.click();
    }
    

	
    public void checkInvalidPasswordMsg(String text) throws InterruptedException {
		try {
			this.sendKeys(this.psswrd, text);
	    	Thread.sleep(2000);
			this.click(this.firstName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOf(invalidPasswrd));
		} catch(RuntimeException e) {
			System.out.println("Invalid Password Message is not visible");
		}
		String invalidPasswordMsg = this.getText(this.invalidPasswrd);
		Assert.assertEquals(invalidPasswordMsg, "Password should have numbers, special characters, upper case and lower case letters and at minimum the length to be 8 characters");
    }
    
    public void checkInvalidEmailMsg(String text) throws InterruptedException {
    	try {
    	this.sendKeys(this.email, text);
    	Thread.sleep(2000);
		this.click(this.psswrd);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOf(invalidEmail));
		} catch(RuntimeException e) {
			System.out.println("Invalid Email Message is not visible");
		}
		String invalidEmailMsg = this.getText(this.invalidEmail);
		Assert.assertEquals(invalidEmailMsg, " Invalid Email Address ");
    }

    public void clickOption(String option) {
    	driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys(option);
    	List<WebElement> list	= driver.findElements(By.xpath("//li[@role='option']"));
   
    		for(int i=0; i<list.size(); i++) {
    			
    			if(list.get(i).getText().equals(option)){
    				WebDriverWait Mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
    				Mywait.until(ExpectedConditions.elementToBeClickable(list.get(i))).click();
    				break;
    			}
    		}
	}
    
    public void options(int numberofoptions) {
    	List<WebElement> list = driver.findElements(By.xpath("//div[@class='py-2 primary font-semi-bold']"));
    	for(int i=0; i<numberofoptions;i++) {
    		JavascriptExecutor js = (JavascriptExecutor) driver;
    		js.executeScript("arguments[0].scrollIntoView();",list.get(i) );
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(list.get(i))).click();
    	}
    	
    }
    
    public String[] optionsGettext() {
    	List<WebElement> list = driver.findElements(By.xpath("//div[@class='py-2 primary font-semi-bold']"));
    	String[] data = new String[list.size()];
    	for(int i=0; i < list.size();i++) {
    		JavascriptExecutor js = (JavascriptExecutor)driver;
        	js.executeScript("arguments[0].scrollIntoView();",list.get(i));
    		data[i] = list.get(i).getText();
    	}
    	return data;
    }
    
    public void selectCareerGoals(int numOfOptions) {
    	List<WebElement> list = driver.findElements(By.xpath("//label/p"));
    	for(int i=0; i<numOfOptions;i++) {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(list.get(i))).click();
    	}
    }
    
    public void proceedToNextStep() throws InterruptedException {
    	try {
    		String confirm = getText(header);
		    // Checking Message on screen
		    String msg = "Welcome To EC-Council Learning, "+name+"!";
		    Assert.assertEquals(confirm, msg);
		    // Checking title
		    Assert.assertEquals(driver.getTitle(), "Welcome | EC-Council Learning");
			this.click(strtBtn);
			this.spinnerloader();
			// Checking title
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			this.options(4);
			this.click(nxtBtn);
			this.spinnerloader();
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			this.options(1);
			this.click(nxtBtn);
			this.spinnerloader();
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			this.selectCareerGoals(1);
			this.click(nxtBtn);
			this.spinnerloader();
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			this.options(3);
			this.click(nxtBtn);
			this.spinnerloader();
			String thankYouMsg =this.getText(thankMsg);
		    // Checking Message on screen
		    String mesg = "Thank You, "+name+"!";
		    Assert.assertEquals(thankYouMsg, mesg);
			Assert.assertEquals(driver.getTitle(), "Thanks | EC-Council Learning");
			this.click(dashBoard);
			this.spinnerloader();
			String dashboardMssg =this.getText(dashboardMsg);
		    // Checking Message on screen
		    String messg = "Welcome, "+name+"!";
		    Assert.assertEquals(dashboardMssg, messg);
			Assert.assertEquals(driver.getTitle(), "Course | Dashboard | EC-Council Learning");
    	}catch(Exception e){
			System.out.println(e);
			Assert.fail();
		 }
    }
    public void printLogo() throws InterruptedException {
    	String confirm = getText(logo);
	    System.out.println(confirm);
	    Thread.sleep(4000);
    }
    public void assertionHeaders() throws InterruptedException {
    	try {
    		
		//	Assert.assertEquals(this.getText(header).trim(), " Welcome To EC-Council Learning, aass! ​");
			Assert.assertEquals(this.getText(header1).trim(), "Personalize your learning experience on EC-Council Learning. Get recommendations on courses and other learning materials based on your interests and career goals.");
			this.click(startButton);
			this.spinnerloader();
			Assert.assertEquals(this.getText(subheader), "Choose up to 4 categories that interest you the most.");
			Thread.sleep(8000);
			this.categoriesFirstPage();
		
//			driver.findElement(By.xpath("//div[text()=' Intelligence']")).click();
//			Thread.sleep(8000);
//			driver.findElement(By.xpath("//div[text()=' Vulnerability Assessment and Pentesting']")).click();
//			
			
			
	          this.click(nxtBtn);
			this.spinnerloader();
		    Assert.assertEquals(this.getText(subheader1), "What is your level of experience at the previously selected categories?");
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			Thread.sleep(8000);
			this.categoriesSecondPage();
			
			Thread.sleep(3000);
//			String[] leveloption = {"Beginner","Intermediate","Advanced"};
//			String[] levelOptionUi = this.optionsGettext();
//			Assert.assertEquals(levelOptionUi, leveloption);
//			this.options(1);
			this.click(nxtBtn);
			this.spinnerloader();
			
			Assert.assertEquals(this.getText(subheader2), "What is your next career goal?");
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");
			Thread.sleep(8000);
			this.categoriesThirdPage();
			
			Thread.sleep(3000);
			this.click(nxtBtn);
			this.spinnerloader();
			
			Assert.assertEquals(this.getText(subheader3), "Select all the topics you're interested in");
			Assert.assertEquals(driver.getTitle(), "quiz | EC-Council Learning");

			
			Thread.sleep(8000);
			this.categoriesFourthPage();
		
			Thread.sleep(3000);
			this.click(nxtBtn);
			this.spinnerloader();
			Thread.sleep(8000);
			String thankYouMsg =this.getText(thankMsg);
		    // Checking Message on screen
		    String mesg = "Thank You, "+name+"!";
		    Assert.assertEquals(thankYouMsg, mesg);
		    Thread.sleep(8000);
		    String thankheader = "We're now ready to recommend courses for you based on your career goals and interests! You will always find your recommended courses in your dashboard";
		    Assert.assertEquals(this.getText(thanksubheader).trim(), thankheader.trim());
			Assert.assertEquals(driver.getTitle(), "Thanks | EC-Council Learning");
			this.click(dashBoard);
			this.spinnerloader();
			String dashboardMssg =this.getText(dashboardMsg);
		    // Checking Message on screen
		    String messg = "Welcome, "+name+"!";
		    Assert.assertEquals(dashboardMssg, messg);
			Assert.assertEquals(driver.getTitle(), "Course | Dashboard | EC-Council Learning");
    	}
    	catch(Exception e){
			System.out.println(e);
			Assert.fail();
		 }
    }
}
	
	