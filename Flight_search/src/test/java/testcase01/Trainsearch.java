package testcase01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Trainsearch {

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
		driver.get("https://www.goibibo.com/trains/");
		System.out.println("Website open successfully..");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getScreenshot("site");
	}

	// select from location
	@Test(priority = 2) 
	public void From() throws AWTException, InterruptedException {
		
		WebElement from=driver.findElement(By.xpath("//*[@id=\"gosuggest_inputL\"]")); 
		from.sendKeys("Chennai"); //Selecting from city
		Thread.sleep(2000);
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform(); 
	
		System.out.println("From location Entered..");

	}

	// select to location
	@Test(priority = 3) 
	public void To() throws AWTException, InterruptedException {
		
		WebElement to=driver.findElement(By.xpath("//div[@class='homeContainerInner']//div[2]//input[1]"));
		to.sendKeys("Delhi");//selecting TO city
		Thread.sleep(2000);
		Actions a1=new Actions(driver);
		a1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		System.out.println("To location Entered..");
	}

	//select date of journey
	@Test(priority = 4) 
	public void Date() throws AWTException, InterruptedException, IOException {
		driver.findElement(By.xpath("//input[@class='form-control inputTxtLarge widgetCalenderTxt']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@aria-label='Sun Sep 27 2020']")).click();//selecting the calender
		Thread.sleep(2000);
		System.out.println("Date selected..");

		getScreenshot("data");
		WebElement search = driver.findElement(By.id("gi_search_btn"));
		search.click();
		
		System.out.println("the Screenshot is taken");
		System.out.println("Execution completed");
	}

	//train search button
	@Test(priority = 4) 
	public void Search() throws AWTException, InterruptedException, IOException {
		
WebElement list = driver.findElement(By.xpath("//section[@class='srpCardWrap']//*[@class='srpCard']"));	//Fetch the train details
		
		List<WebElement> productdetailsName = list.findElements(By.xpath("//section[@class='srpCardWrap']//*[@class='srpCard']//div[@class='padB20']"));
		
		
		int n=productdetailsName.size();
		System.out.println(n);
		String name;
			for (int i = 0; i <n; i++)
			{
				//j=i+1;
				name = productdetailsName.get(i).getText();
				System.out.println(name);
		
	}
		System.out.println("the Screenshot is taken");
		System.out.println("Execution completed");
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
