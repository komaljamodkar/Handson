package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReddifwithregExp {

	static WebDriver driver=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.getProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver=new ChromeDriver();

		//load new webpage
		try {
			driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
			
			driver.findElement(By.xpath("//input[contains(@id,'login1')]")).sendKeys("jamodkar.swati@gmail.com");
			driver.findElement(By.cssSelector("input[id*='password']")).sendKeys("Qwerty@98");
			
			
			driver.findElement(By.xpath("//input[contains(@name,'remember')]")).click(); //xpath

			driver.findElement(By.cssSelector("input[name*='proce']")).click();
			
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		driver.quit();



	}

}
