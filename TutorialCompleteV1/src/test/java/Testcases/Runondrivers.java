package Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Runondrivers {

	static WebDriver driver=null;
	
	public static void main(String[]args)
	{
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
	driver=new ChromeDriver();
	
	//load new webpage
	driver.get("https://www.goibibo.com");
	
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	System.out.println(driver.getPageSource());
	System.out.println(driver.toString());
	driver.navigate().forward();
	driver.navigate().back();
	driver.navigate().refresh();
	driver.navigate().to("");
	driver.navigate().notifyAll();
	driver.navigate().notify();
	try {
		driver.navigate().wait(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.close();
	driver.quit();
	
	}
	
}
