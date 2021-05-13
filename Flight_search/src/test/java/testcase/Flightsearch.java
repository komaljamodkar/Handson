package testcase;

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
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utils.ExcelUtils;



public class Flightsearch {

	WebDriver driver=null;
	@Parameters("browsername")
	@BeforeTest
	public void setUp(String browsername)
	{
		System.out.println("browsesrname :"+browsername);

		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
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

	//fail conditions

	@Test(priority = 2)
	public void failcond() throws AWTException, InterruptedException, IOException {

		WebElement btn=driver.findElement(By.id("gi_search_btn"));
		btn.click();
		WebElement msg=driver.findElement(By.xpath("//span[@class='status_cont red ico13']"));
		String err_msg=msg.getText();
		System.out.println("msg="+err_msg);
		Assert.assertEquals(err_msg,"Please enter a valid Source");

		//screenshot for blank input
		getScreenshot("blank_i/pmsg");

		WebElement travellerselect = driver.findElement(By.xpath("//div[@id='pax_link_common']"));
		travellerselect.click();
		for (int i = 0; i < 4; i++){
			driver.findElement(By.id("infantPaxPlus")).click();
			Thread.sleep(1000);
		}

		WebElement inf_msg=driver.findElement(By.xpath("//span[contains(text(),'Number of infants cannot be more than adults')]"));
		String infmsg=inf_msg.getText();
		System.out.println("msg="+infmsg);
		Assert.assertEquals(infmsg,"Number of infants cannot be more than adults");

		//screenshot for infrants more than adults
		getScreenshot("errormsg");

		System.out.println("Traveller selected..");

		getScreenshot("infrant_error");



	}



	// select from location
	@Test(priority = 3,dataProvider="test1data")
	public void From(String fromloc, String toloc) throws AWTException, InterruptedException, IOException {

		driver.navigate().refresh();
		WebElement from = driver.findElement(By.xpath("//*[@id=\"gosuggest_inputSrc\"]"));
		from.sendKeys(fromloc);
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		System.out.println("From location Entered..");

		WebElement to = driver.findElement(By.xpath("//*[@id=\"gosuggest_inputDest\"]"));
		to.sendKeys(toloc);
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

		WebElement inf_msg=driver.findElement(By.xpath("//span[contains(text(),'Maximum of 9 travellers allowed')]"));
		String infmsg=inf_msg.getText();
		System.out.println("msg="+infmsg);
		Assert.assertEquals(infmsg,"Maximum of 9 travellers allowed");

		//screenshot for max no of travellers
		getScreenshot("errormsgmax_traveller");

		WebElement travellerselect = driver.findElement(By.xpath("//div[@id='pax_link_common']"));
		travellerselect.click();
		for (int i = 0; i < 4; i++){
			driver.findElement(By.id("infantPaxMinus")).click();
			Thread.sleep(1000);
		}

		System.out.println("Traveller selected..");
		getScreenshot("traveller");
		System.out.println("the Screenshot is taken");
		System.out.println("Execution completed");
	}

	//flight search button
	@Test(priority = 5) 
	public void Search() throws AWTException, InterruptedException, IOException {
		WebElement search = driver.findElement(By.xpath("//*[@id='gi_search_btn']"));
		search.click();
		Thread.sleep(2000);
		System.out.println("Search button clicked..");
		driver.findElement(By.id("PRICE")).click();
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor)driver;  
		js.executeScript("window.scrollBy(0,1000)", "");
		//((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		getScreenshot("5lowestflight");
		Thread.sleep(4000);

		System.out.println("Execution completed");
	}

	//Displays Flight name with price with low to high
	@Test(priority = 6) 
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

	//screenshot method
	public void getScreenshot(String i) 
	{
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./screenshots/" + i + ".png"));
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//take excel data using dataprovider 

	@DataProvider(name="test1data")
	public  Object[][] getData()
	{
		String filePath = "./DataFile/Data.xlsx";

		Object data[][] =testData(filePath, "Sheet1");
		return data;

	}

	public  Object[][] testData(String filepath,String sheetName)
	{
		ExcelUtils excel = new ExcelUtils(filepath, sheetName);
		int rowCount = excel.getRowcount();
		int colCount = excel.getColcount();

		Object data[][]=new Object[rowCount-1][colCount];

		//get value from row
		for (int row = 1; row < rowCount; row++) {
			for (int col = 0; col < colCount; col++) {
				String cellData = excel.getCellDataString(row, col);

				data[row-1][col]=cellData;
			}
			System.out.println();
		}

		return data;

	}


	@AfterTest
	public void tearDown()

	{
		driver.quit();
		System.out.println("Test completed successfully..");
	}

}


