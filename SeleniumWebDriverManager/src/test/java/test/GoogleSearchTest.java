package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.GoogleSearchPage;

public class GoogleSearchTest {

	private static WebDriver driver=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		googleSearch();

	}

	public static void googleSearch()
	{
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
		driver=new FirefoxDriver();
		driver.get("https://www.google.com");
		
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation step by step");
		GoogleSearchPage.textbox_search(driver).sendKeys(Keys.ENTER);
		GoogleSearchPage.button_search(driver).sendKeys(Keys.ENTER);
		
		driver.close();
		driver.quit();
	}
}
