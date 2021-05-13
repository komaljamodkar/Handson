package testcase01;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.List;
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



public class Flightsearch {

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
		driver.get("https://www.goibibo.com/");
		System.out.println("Website open successfully..");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getScreenshot("site");
	}

	// select from location
	@Test(priority = 2) 
	public void From() throws AWTException, InterruptedException {
		WebElement from = driver.findElement(By.xpath("//*[@id=\"gosuggest_inputSrc\"]"));
		from.sendKeys("London");
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		System.out.println("From location Entered..");

	}

	// select to location
	@Test(priority = 3) 
	public void To() throws AWTException, InterruptedException {
		WebElement to = driver.findElement(By.xpath("//*[@id=\"gosuggest_inputDest\"]"));
		to.sendKeys("New York");
		Thread.sleep(2000);
		Actions a1 = new Actions(driver);
		a1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		System.out.println("To location Entered..");
	}

	//select date of journey
	@Test(priority = 4) 
	public void Date() throws AWTException, InterruptedException, IOException {
		WebElement traveldate = driver.findElement(By.xpath("//div[@class='DayPicker DayPicker--en']//div[@class='DayPicker-Month']//div[@class='DayPicker-Week']//div[@id='fare_20201014']"));
		traveldate.click();
		System.out.println("Date selected..");

		WebElement traveller = driver.findElement(By.xpath("//div[@id='pax_link_common']"));
		traveller.click();
		for (int i = 0; i < 5; i++){
			driver.findElement(By.id("childPaxPlus")).click();
			Thread.sleep(1000);
		}

		System.out.println("Traveller selected..");
		
		getScreenshot("traveller");
		System.out.println("the Screenshot is taken");
		System.out.println("Execution completed");
	}

	//flight search button
	@Test(priority = 4) 
	public void Search() throws AWTException, InterruptedException, IOException {
		WebElement search = driver.findElement(By.xpath("//*[@id='gi_search_btn']"));
		search.click();
		Thread.sleep(2000);
		System.out.println("Search button clicked..");
		driver.findElement(By.id("PRICE")).click();
		Thread.sleep(2000);
		
		getScreenshot("pricelist");
		System.out.println("the Screenshot is taken");
		System.out.println("Execution completed");
	}

	//Displays Flight name with price with low to high
	@Test(priority = 5) 
	public void Flights() throws AWTException, InterruptedException {

		WebElement Flights = driver.findElement(By.xpath("//div[@class='marginB10']//div[@class='clr']"));
		List<WebElement> FlightName = Flights.findElements(By.xpath("//*[@class='ico13 padR10 padL5']"));
		List<WebElement> FlightPrice = Flights.findElements(By.xpath("//*[@class='alignItemsCenter dF padT2']"));

		System.out.println("FlightName and Its Price list ..");
		String name;
		String price;
		int j=0;
		for (int i = 0; i <5; i++) {
			j = i + 1;
			name = FlightName.get(i).getText();
			price = FlightPrice.get(i).getText();
			System.out.println(j + "\t" + name + "\t\t" + price);
		}
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


