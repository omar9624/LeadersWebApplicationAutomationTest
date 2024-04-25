package AddRandomProduct;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignupTest extends Parameters{
	
	String currentPassword = "Omar!123?$%4567";
	
	@BeforeTest
	public void setup() throws InterruptedException {
		driver.get("https://leaders.jo/en/my-account/");
		driver.manage().window().maximize();
		
		closePopup();
	}
	
	@Test(priority = 1)
	public void signupProcess() throws InterruptedException, IOException {
		
		//Navigate to Create Account Page
		WebElement createAccountButton = driver.findElement(By.cssSelector("h2[class='register']"));
		createAccountButton.click();
		
		//Declare WebElement
		WebElement emailInput = driver.findElement(By.id("reg_email"));
		WebElement passwordInput = driver.findElement(By.id("reg_password"));
		WebElement registerButton = driver.findElement(By.cssSelector("button[value='Register']"));
		
		int randomNum = random.nextInt(1000);
		emailInput.sendKeys("ibrahim"+randomNum+"@gmail.com");
		passwordInput.sendKeys(currentPassword);
		registerButton.click();	
		
		Thread.sleep(3000);
		
	}
	
	@Test(priority = 2)
	public void changePassword() throws InterruptedException {
		
		//Navigate to Account Details
		WebElement accountButton = driver.findElement(By.cssSelector(".woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--edit-account"));
		accountButton.click();
		
		System.out.println("Current Password : "  + currentPassword);
		
		//Declare WebElement
		WebElement firstNameInput = driver.findElement(By.id("account_first_name"));
		WebElement lastNameInput = driver.findElement(By.id("account_last_name"));
		WebElement currentPasswordInput = driver.findElement(By.id("password_current"));
		WebElement newPasswordInput = driver.findElement(By.id("password_1"));
		WebElement confirmPasswordInput = driver.findElement(By.id("password_2"));
	    WebElement saveChangeButton = driver.findElement(By.xpath("//button[@value='Save changes']"));
		
	    //Generate New Password
	    int randomnumber = random.nextInt(5000);
		String newPassword = currentPassword+randomnumber;
		System.out.println("New Password : "  + newPassword);
		
		//Fill Inputs Field 
		firstNameInput.sendKeys("Ibrahim");
		lastNameInput.sendKeys("Ali");
		currentPasswordInput.sendKeys(currentPassword);
		newPasswordInput.sendKeys(newPassword);
		confirmPasswordInput.sendKeys(newPassword);
		
		saveChangeButton.click();
		
		Thread.sleep(3000);
		
		//Assertion
		WebElement successfullyChangeMsg = driver.findElement(By.className("woocommerce-message"));
		String actualMsg = successfullyChangeMsg.getText();
		myAssert.assertEquals(actualMsg, "Account details changed successfully.");
		
		Thread.sleep(3000);
		
		driver.quit();
	}
}
