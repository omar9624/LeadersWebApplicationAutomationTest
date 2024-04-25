package samsungScreen;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

public class Parameters {

	WebDriver driver = new ChromeDriver();
	
	Assertion myAssert = new Assertion();
	
	Random random = new Random();
	
	String url = "https://leaders.jo/en/Brands/samsung/";
}
