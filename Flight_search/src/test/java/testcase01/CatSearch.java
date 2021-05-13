package testcase01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CatSearch {

	WebDriver driver=null;
	@Parameters("browsername")
	@BeforeTest
	public void setUp(String browsername)
	{
		System.out.println("browsesrname :"+browsername);

		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.getProperty("webdriver.chrome.driver","./drivers/chromedriver");
			driver=new ChromeDriver();
		}

		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
			driver=new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
			driver=new FirefoxDriver();

		}
	}
	//website open 
	@Test(priority = 1)
	public void test() throws IOException
	{
		driver.get("https://www.marshallspetzone.com/");
		System.out.println("Website open successfully..");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//getScreenshot("site");


	}
	//select city
	@Test(priority = 2) 
	public void From() throws AWTException, InterruptedException {
		
		
		//mouse over
		Actions action = new Actions(driver);
		WebElement cat = driver.findElement(By.xpath("//*[@id=\'cbp-hrmenu-tab-13\']/a/span"));
		action.moveToElement(cat).perform();
		System.out.println("cat");
		WebElement acce = driver.findElement(By.xpath("//*[@id=\"cbp-hrmenu-tab-13\"]/div/div/div/div[1]/div[6]/div/div/div/div/a"));
		acce.click();
		System.out.println("acce");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='products-sort-nb-dropdown products-sort-order dropdown']//a[@class='select-title expand-more form-control']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Price, low to high')]")).click();
		System.out.println("price low to high");
		Thread.sleep(2000);
	}


	public void getScreenshot(String i) throws IOException 
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshots/" + i + ".png"));
	}

	@AfterTest
	public void tearDown()

	{
		driver.quit();
		System.out.println("Test completed successfully..");
	}


}
