package AddRandomProduct;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddRandomLGProduct extends Parameters{
	
	@BeforeTest
	public void setup() throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		
		closePopup();
	}
	
	@Test(priority = 1)
	public void openRandomProduct() throws InterruptedException {
		
		//Declare Web Element 
		WebElement mainContainer = driver.findElement(By.id("main"));
		WebElement productContainer = mainContainer.findElement(By.cssSelector(".products.product-card-layout-1.columns-4.mobile-col-2.product-list-no-desc-mobile.mobile-show-atc.mobile-featured-icons--hover"));
		List<WebElement> productList = productContainer.findElements(By.className("product-inner"));
		
		System.out.println(productList.size());
		
		int randomNumber = random.nextInt(productList.size());
		
		//Choose Product From List Of Products And Open it 
		productList.get(randomNumber).click();
		
	}
	
	@Test(priority = 2)
	public void chooseQuantityAndAddToCart() throws InterruptedException {
		
		closePopup();
		
		int randomQty = random.nextInt(3) + 1;
		
		System.out.println(randomQty);
		
		WebElement quantityInput = driver.findElement(By.xpath("//input[@name='quantity']"));
		quantityInput.clear();
		quantityInput.sendKeys(String.valueOf(randomQty));
		
		WebElement addToCartButton = driver.findElement(By.xpath("//button[@name='add-to-cart']"));
		addToCartButton.click();
		
		Thread.sleep(5000);
		
		WebElement cartQty = driver.findElement(By.xpath("//span[@class='header-cart__counter header-counter ']"));
		System.out.println(cartQty.getText());
		
	
		int actualQty = Integer.valueOf(cartQty.getText());

	}
}
