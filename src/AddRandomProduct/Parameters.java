package AddRandomProduct;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

public class Parameters {
	
	WebDriver driver = new ChromeDriver();
	Assertion myAssert = new Assertion();
	Random random = new Random();
	String url = "https://leaders.jo/en/Brands/lg/";
	
	//Screenshot Function
	public void TakeScreenshot() throws IOException {
		
		TakesScreenshot ts = ((TakesScreenshot) driver);
		
		LocalDateTime date =  LocalDateTime.now();
		String filename = date.toString().replace(":", "-");
		
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./src/images/"+filename+".jpg");
		
		srcFile.renameTo(destFile);
		
	}
	
	public void closePopup() throws InterruptedException {
		
		//Close Pop up Message If Displayed  
		Thread.sleep(4000);
		WebElement popup = driver.findElement(By.cssSelector(".elementor.elementor-19907"));
		
		if(popup.isDisplayed()) {
			WebElement closePopup = driver.findElement(By.cssSelector(".motta-svg-icon.motta-svg-icon--close.motta-popup__close"));
			closePopup.click();
		}
	}
}
