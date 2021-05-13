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



public class CatcheValidation {

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


