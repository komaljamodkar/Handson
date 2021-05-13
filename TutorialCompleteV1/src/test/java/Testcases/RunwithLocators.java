package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunwithLocators {

	static WebDriver driver=null;

	public static void main(String[]args)
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver=new ChromeDriver();

		//load new webpage
		driver.get("https://www.goibibo.com");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Sign In")).click();
		System.out.println("clicked");
		//id classname/name xpath cssselector
		//alphanumeric id may vary on every refresh page
		//link object must be in a tag
		//classes should not have any space Compound classess not accepted
		//multiple values selenium indetifies the first one scan from top left
		////*[@id="Login"] convert in java to single //*[@id='Login']
		//try to take xpath from chrome it gives right
		//when xpath starts with html not reliable
		//Customize xpath/css generation
		/*Standart pattern
		 * tag name traverse
		 * regular expression
		 * 
		 * $x("//a[contains(text(),'Forgotten password?')]") paste in console gives element
		 * $("#login_link > a._97w4") for css selector
		 */
		driver.close();
		driver.quit();

	}
}
