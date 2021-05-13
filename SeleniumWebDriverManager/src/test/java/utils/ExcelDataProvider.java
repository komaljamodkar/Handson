package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.Propertiesfile;

public class ExcelDataProvider {
	WebDriver driver=null;
	@BeforeTest()
	public void setUpTest()
	{
		System.getProperty("webdriver.chrome.driver","./drivers/chromedriver");
			driver=new ChromeDriver();
		
	}
	
	@Test(dataProvider="test1data")
	public void test1(String username,String password) {
		System.out.println(username+"|"+password);
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys(username);
		
		 
			List<WebElement> links=driver.findElements(By.tagName("a"));
			System.out.println("links: "+links.size());
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
			
			
			driver.findElement(By.linkText("Sign Up")).click();
			
			
			

	}

	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
		System.out.println("test completed sucessfully");
		
	}
	
	@DataProvider(name="test1data")
	public  Object[][] getData()
	{
		String filePath = "/home/swati/eclipse-workspace/SeleniumWebDriverManager/testData/data1.xlsx";

		Object data[][] =testData(filePath, "Sheet1");
		return data;

	}

	public  Object[][] testData(String filepath,String sheetName)
	{
		ExcelUtils excel = new ExcelUtils(filepath, sheetName);
		int rowCount = excel.getRowcount();
		int colCount = excel.getColcount();
		//data 10rows 1 row is header total 11 so dec -1
		Object data[][]=new Object[rowCount-1][colCount];

		//get value from row
		for (int row = 1; row < rowCount; row++) {
			for (int col = 0; col < colCount; col++) {
				String cellData = excel.getCellDataString(row, col);
				System.out.print(cellData+"|");
				//index starts at 0
				data[row-1][col]=cellData;
			}
			System.out.println();
		}

		return data;

	}


}
