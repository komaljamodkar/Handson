package demo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestMultibrowser {
	
	WebDriver driver=null;
	@Parameters("browsername")
	@BeforeTest
	public void setUp(String browsername)
	{
		System.out.println("browsesrname :"+browsername);
		System.out.println("Threadname :"+Thread.currentThread().getId());
		System.out.println("Threadname :"+Thread.currentThread().getName());
		System.out.println("Threadname :"+Thread.currentThread().getPriority());
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.getProperty("webdriver.chrome.driver","./drivers/chromedriver");
			driver=new ChromeDriver();
		}
		
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.getProperty("webdriver.gecko.driver","./drivers/geckodriver");
			driver=new FirefoxDriver();
		}
	}
	
	@Test
	public void test()
	{
		driver.get("http://www.tinyupload.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String path=("/home/swati/Desktop/d1.csv");
		
		driver.findElement(By.name("uploaded_file")).sendKeys(path);
	}
	

	@AfterTest
	public void tearDown()
	
	{
		driver.quit();
		System.out.println("test completed successfully");
	}

}
