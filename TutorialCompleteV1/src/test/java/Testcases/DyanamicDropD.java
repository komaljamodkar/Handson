package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DyanamicDropD {

	static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*$x("(//a[@value='MAA'])") for depart n ret dropdown in 2nd dropdown it selects 2 value for chennai so
		 * $x("(//a[@value='MAA'])[2]") give ID of 2 
		 * else gives element not visible exception
		 * 
		 * */
		System.getProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver=new ChromeDriver();

		//load new webpage
		
			driver.get("https://www.spicejet.com/");
			//for dynamic dropdown we use select class
			
			Thread.sleep(20000);
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
			
			/*
			 * driver.findElement(By.xpath("//a[@value='BLR']")).click();
			driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); if array index dont want then parent child relationship xpath
			follow
			 * */
			Thread.sleep(20000);
			driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']")).click();
			Thread.sleep(20000);
			driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
			Thread.sleep(20000);
	}

}
