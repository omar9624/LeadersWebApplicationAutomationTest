package SignUpProcess;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignupProcess extends Parameters{
	
	@BeforeTest
	public void setup() throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		
		//Close Pop up Message If Displayed  
		Thread.sleep(4000);
		WebElement popup = driver.findElement(By.cssSelector(".elementor.elementor-19907"));
		if(popup.isDisplayed()) {
			WebElement closePopup = driver.findElement(By.cssSelector(".motta-svg-icon.motta-svg-icon--close.motta-popup__close"));
			closePopup.click();
		}
	}
	
	@Test(enabled = true)
	public void signupProcess() throws InterruptedException, IOException {
		
		WebElement createAccountButton = driver.findElement(By.cssSelector("h2[class='register']"));
		createAccountButton.click();
		
		WebElement emailInput = driver.findElement(By.id("reg_email"));
		WebElement passwordInput = driver.findElement(By.id("reg_password"));
		WebElement registerButton = driver.findElement(By.cssSelector("button[value='Register']"));
		
		int randomNum = random.nextInt(1000);
		emailInput.sendKeys("ibrahim"+randomNum+"@gmail.com");
		passwordInput.sendKeys("Omar!123?$%4567");
		registerButton.click();	
		
		Thread.sleep(3000);
		
		TakeScreenshot();
		
		driver.quit();
	}
}
