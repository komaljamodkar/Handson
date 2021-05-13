package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase01 {
	WebDriver driver=null;
	
	@BeforeTest
	public void setUp()
	{
		/*System.getProperty("webdriver.chrome.driver","./drivers/chromedriver");
		WebDriver driver=new ChromeDriver();*/
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
		 driver=new FirefoxDriver();
		
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void run()
	{
		
		driver.findElement(By.id("email")).sendKeys("abc");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("links: "+links.size());
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("abc123");
		driver.findElement(By.linkText("Sign Up")).click();
		
		
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
		System.out.println("test completed sucessfully");
		
	}
}

