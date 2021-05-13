package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import okio.Options;

/*headless b- doesnt have GUI , Run on linux without using GUI
 * When not to use : not giving proper feedback
 * want visual representation ,need to observe your tets
 * when error not observed
 * ex=HTML unit browser
 * SlimerJS
 *  trifleJS
 *  ZombieJS
 *  Selenium Rc not worked with HTML unit browser
 */

public class Headlessbrow {
	public static void main(String[] args) {
		test();
	}
	public static void test()
	{
		WebDriver driver=null;
		System.getProperty("webdriver.chrome.driver","./drivers/chromedriver");
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1200,800");
		
		driver=new ChromeDriver(options);
		
		
		
		driver.get("https://www.google.com/");
		System.out.println("title :"+driver.getTitle());
	    driver.findElement(By.name("q")).click();
	    driver.findElement(By.name("q")).clear();
	    driver.findElement(By.name("q")).sendKeys("automation testing");
	    driver.findElement(By.id("tsf")).submit();
	    driver.close();
	    System.out.println("completed..");
	}
}
