package samsungScreen;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SamsungScreen extends Parameters{
	
		@BeforeTest
		public void mySetup() throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 
		//Close Pop up Message If Displayed  
		Thread.sleep(5000);
		WebElement popup = driver.findElement(By.cssSelector(".elementor.elementor-19907"));
		if(popup.isDisplayed()) {
			WebElement closePopup = driver.findElement(By.cssSelector(".motta-svg-icon.motta-svg-icon--close.motta-popup__close"));
			closePopup.click();
		}
	}
	
	@Test(priority = 1 , enabled = true)
	public void selectTheScreenSection() {
		
		WebElement category = driver.findElement(By.cssSelector("div[class='bapf_body'] span[class='selection']"));
		category.click();
		
		//Choose TV Screen 
		WebElement searchInput = driver.findElement(By.cssSelector("input[role='searchbox']"));
		searchInput.sendKeys("TV screens");
		searchInput.sendKeys(Keys.ENTER);
		
	}
	
	@Test(priority = 2 , enabled = true)
	public void filterPriceFromHighToLow() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement filterContainer = driver.findElement(By.cssSelector("select[name='orderby']"));
		Select filterSelector = new Select(filterContainer);
		filterSelector.selectByIndex(4);
		
		//Declare main container of products 
		WebElement container = driver.findElement(By.id("primary"));
		
		//Declare List of Products
		WebElement productContainer = container.findElement(By.tagName("ul"));
		List<WebElement> products = productContainer.findElements(By.className("product-inner"));
		
		System.out.println(products.size());
		
		//Get Price For First Product 
		Thread.sleep(2000);
		String firstProductPriceString = products.get(0).findElement(By.tagName("bdi")).getText();
		double firstProductPriceDouble = Double.parseDouble(firstProductPriceString.replaceAll("[^\\d.]", ""));

		//Get Price For Last Product 
		Thread.sleep(2000);
		String lastProductPriceString = products.get(products.size()-1).findElement(By.tagName("bdi")).getText();
		double lastProductPriceDouble = Double.parseDouble(lastProductPriceString.replaceAll("[^\\d.]", ""));
	
		//Assertion
		boolean actual = firstProductPriceDouble > lastProductPriceDouble;
		myAssert.assertEquals(actual, true , "First Price is Not Higher than last price");
		
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	
	
}
