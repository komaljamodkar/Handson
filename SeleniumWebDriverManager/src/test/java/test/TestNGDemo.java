package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.Propertiesfile;
import demo.Log4jDemo;

public class TestNGDemo {
	WebDriver driver=null;
	public static String browserName=null;
	private static Logger logger =LogManager.getLogger(Log4jDemo.class);
	
	@BeforeTest()
	public void setUpTest()
	{
		Propertiesfile.getProperties();
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.getProperty("webdriver.chrome.driver","./drivers/chromedriver");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
			 driver=new FirefoxDriver();
		}
		
	}
	
	@Test
	public void test()
	{
		driver.get("https://www.google.com");
		logger.info("naviagte to google.com");
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		System.out.println("test completd successfully");
		Propertiesfile.setProperties();
	}
}
