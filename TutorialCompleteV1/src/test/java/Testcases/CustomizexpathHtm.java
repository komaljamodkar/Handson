package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomizexpathHtm {
	
	static WebDriver driver=null;

	public static void main(String[]args)
	{
		System.getProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver=new ChromeDriver();

		//load new webpage
		driver.get("https://www.goibibo.com");
		driver.findElement(By.xpath("//span[contains(@id,'roundTrip')]")).click(); //xpath

		driver.findElement(By.cssSelector("span[id*='multi']")).click();
		
		/*Generating xpath from customized html
		 * <input class="button r4 wide primary" type="submit" id="Login" name="Login" value="Log In">
		 *  //tagName[@attribute='value']
		 *  //input[@value='Log In']
		 *   //input[@type='email']
		 *   
		 *   for css
		 *   <input class="input r4 wide mb16 mt8 username" type="email" value="apexswati@abc.com" name="username" id="username" aria-describedby="error" style="display: block;" xpath="1">
		 *   //tagName[attribute='value']
		 *   tagName#id
		 *   input#username
		 *   
		 *   tagName.className
		 *   
		 *   regular expression to manage constant xpath 
		 *   //tagName[@contains(@attribute,'value')] -xpath
		 *   //input[contains(@name,'username')]
		 *   
		 *   for css
		 *   tagName[attribute*='value']
		 *   input[name*='username']
		 */
		driver.close();
		driver.quit();

	}

}
