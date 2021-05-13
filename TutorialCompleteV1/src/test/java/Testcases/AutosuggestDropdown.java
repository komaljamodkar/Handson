package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestDropdown {

	static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.getProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver=new ChromeDriver();

		//load new webpage
		
			driver.get("https://www.goindigo.in//");
			WebElement src1=driver.findElement(By.className("form-control or-src-city"));
			src1.click();
			src1.sendKeys("ko");
			Thread.sleep(20000);

	}

}
