package testcase;

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

public class Hotel_search {

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
	//select city
	@Test(priority = 2) 
	public void From() throws AWTException, InterruptedException {
		driver.findElement(By.xpath("//i[contains(@class, 'icon-gostays ')]")).click();

		driver.findElement(By.xpath("//h4[text()='India']")).click();

		driver.findElement(By.xpath("//input[contains(@placeholder, 'Landmark ')]")).click();
		WebElement city=driver.findElement(By.xpath("//input[contains(@placeholder, 'Landmark ')]"));
		city.sendKeys("Mumbai");
		Thread.sleep(2000);
		city.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		city.sendKeys(Keys.ENTER);
		System.out.println("location Entered..");


	}

	//select date
	@Test(priority = 3) 
	public void Date() throws AWTException, InterruptedException, IOException {
		WebElement calender = driver.findElement(By.xpath("//div[@data-testid='openCheckinCalendar']"));
		calender.click();
		Thread.sleep(1000);

		System.out.println("Calender date Entered..");
		WebElement nextmonth = driver.findElement(By.xpath("//div[@data-testid='calendarRightArrowBtn']"));
		nextmonth.click();
		System.out.println("Calender Nextdate Entered..");
		Thread.sleep(1000);
		WebElement checkin = driver.findElement(By.xpath("(//ul[@class='dcalendarstyles__DateWrapDiv-r2jz2t-7 epkfcn']) //li //span[text()='17']"));
		checkin.click();
		Thread.sleep(1000);
		WebElement checkout = driver.findElement(By.xpath("(//ul[@class='dcalendarstyles__DateWrapDiv-r2jz2t-7 epkfcn']) //li //span[text()='20']"));
		checkout.click();
		Thread.sleep(1000);
		getScreenshot("date");
		getScreenshot("date selected ");

	}
	//Guest and rooms
	@Test(priority = 4) 
	public void Search() throws AWTException, InterruptedException, IOException {
		WebElement room = driver.findElement(By.xpath("//input[@value='2 Guests in 1 Room ']"));
		room.click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//span[text()='-'])[2]")).click();

		WebElement donebtn=driver.findElement(By.xpath("//button[text()='Done']"));
		Thread.sleep(1000);
		donebtn.click();
		System.out.println("Guest and room count entered..");
		getScreenshot("info");
		WebElement search=driver.findElement(By.xpath("//button[@data-testid='searchHotelBtn']"));
		search.click();

		System.out.println("searching..");
	}

	//Displays Hotels name with price with low to high
	@Test(priority = 5) 
	public void Flights() throws AWTException, InterruptedException, IOException {

		WebElement sortprice=driver.findElement(By.xpath("//span[text()='Price (Low to High)']"));
		sortprice.click();
		System.out.println("Test executed..");
		getScreenshot("result");
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


