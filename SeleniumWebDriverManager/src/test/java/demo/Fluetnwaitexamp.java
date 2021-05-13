package demo;


import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Fluetnwaitexamp {
	WebDriver driver=null;
	@Test
	public void test()
	{
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
		driver=new FirefoxDriver();
		driver.get("https://www.google.com/");
	    driver.findElement(By.name("q")).click();
	    driver.findElement(By.name("q")).clear();
	    driver.findElement(By.name("q")).sendKeys("automation testing");
	    driver.findElement(By.id("tsf")).submit();
	   
	 // Waiting 30 seconds for an element to be present on the page, checking
	    // for its presence once every 5 seconds.
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);

	    WebElement elementclick = wait.until(new Function<WebDriver, WebElement>(){
	    	
			public WebElement apply(WebDriver driver ) {
				WebElement element= driver.findElement(By.linkText("It might be child of svg/pseudo element/comment/iframe from different src. Currently ChroPath doesn't support for them."));
				if(element.isEnabled())
				{
					System.out.println("Element found");
				}
				return element;
			}
		});
	    elementclick.click();
	   
	  
	    driver.close();
	}
}
