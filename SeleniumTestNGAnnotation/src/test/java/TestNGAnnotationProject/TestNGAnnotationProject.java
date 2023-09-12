package TestNGAnnotationProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGAnnotationProject {

	String baseUrl = "https://www.saucedemo.com/";
	WebDriver driver ;
	
	
//	=========================
//	Browser Open Setup
//	=========================

	@BeforeMethod 

	public void SetUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver(); 
		this.driver.manage().window().maximize();
		this.driver.get(baseUrl);
		Thread.sleep(3000);
	}


	
//	=========================
//	Browser Close Setup
//	=========================

	@AfterMethod
	public void Close() {
		this.driver.quit();
	}
	
	
	
//	=========================
//	URL Verify Process
//	=========================
	
	
	
	@Test(priority = 1)
	public void VerifyUrl() {
//		Actual URL
		String ActualURL = this.driver.getCurrentUrl();
		
//		Expected URL
		String ExpectedURL = baseUrl;
		
//		Condition Use process
		if(ActualURL.equals(ExpectedURL)) {
			System.out.println("URL Valid");
		} else {
			System.out.println("URL Invalid");
		}
		
//		When you don't like the condition then you can apply Assertion way
//		Assert.assertEquals( ActualURL, ExpectedURL, "Condition true");
		
		
		System.out.println("Actual URL is: "+ActualURL);
		System.out.println("Expected URL is: "+ExpectedURL);
		
	}
	
	
	
	
	
//	=========================
//	Title Verify Process
//	=========================


	@Test(priority = 2)
	public void VerifyTitle() {
//		Actual Title
		String actualTitle = this.driver.getTitle();
		
//		Expected Title
		String expectedTitle = ("Swag Labs");
		
//		Condition Use process
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Title Matched");
		} else {
			System.out.println("Title didn't Matched");
		}
		
//		When you don't like the condition then you can apply Assertion way
		
//		Assert.assertEquals("Condition true", actualTitle, expectedTitle);
		
		
//		Actual Title print
		System.out.println("Actual Title is: "+actualTitle);
//		Expected Title print
		System.out.println("Expected Title is: "+expectedTitle);
	}
	
	

	
//	=========================
//	LogIn Process
//	=========================
	
	
	@Test(dataProvider="LoginTestData", dataProviderClass = DataSupplier.class, priority = 3)
	public void TestLogin (String username, String password) throws Exception  {

	
		WebElement UserName = driver.findElement(By.xpath("//input[@id='user-name']"));
		UserName.sendKeys(username);

	
		WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
		Password.sendKeys(password);
		Thread.sleep(3000);

	
		WebElement LoginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
		LoginButton.click();
		Thread.sleep(3000);
		
		
	}
	
	
	
	@Test(priority = 4)
	public void TestProductPurchase() throws InterruptedException {
		WebElement UserName = driver.findElement(By.xpath("//input[@id='user-name']"));
		UserName.sendKeys("standard_user");

	
		WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
		Password.sendKeys("secret_sauce");
		Thread.sleep(3000);

	
		WebElement LoginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
		LoginButton.click();
		Thread.sleep(3000);
		
		
//		==========================
//		@Test Add to Cart
//		==========================
		
		WebElement AddButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
		AddButton.click();
		Thread.sleep(3000);
		

		WebElement CartIcon = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		CartIcon.click();
		Thread.sleep(3000);
		
		
		
		
//		================================
//		@Test Checkout and Checkout Info
//		================================
		
		WebElement CheckoutButton = driver.findElement(By.xpath("//button[@id='checkout']"));
		CheckoutButton.click();
		Thread.sleep(3000);
		

		WebElement FirstName = driver.findElement(By.xpath("//input[@id='first-name']"));
		FirstName.sendKeys("Omar");
		

		WebElement LastName = driver.findElement(By.xpath("//input[@id='last-name']"));
		LastName.sendKeys("Faruk");
		

		WebElement PostCode = driver.findElement(By.xpath("//input[@id='postal-code']"));
		PostCode.sendKeys("1216");
		Thread.sleep(3000);
		
		
		WebElement ContinueButton = driver.findElement(By.xpath("//input[@id='continue']"));
		ContinueButton.click();
		Thread.sleep(3000);
		
		

		WebElement FinishButton = driver.findElement(By.xpath("//button[@id='finish']"));
		FinishButton.click();
		Thread.sleep(3000);
		
		
		WebElement BackHomeButton = driver.findElement(By.xpath("//button[@id='back-to-products']"));
		BackHomeButton.click();
		Thread.sleep(3000);
		
		
		
//		==========================
//		@Test Logout
//		==========================
		
		WebElement MenuButton = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
		MenuButton.click();
		Thread.sleep(3000);
		

		WebElement LogoutButton = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
		LogoutButton.click();
		Thread.sleep(6000);

	}
	}
	
	
	



