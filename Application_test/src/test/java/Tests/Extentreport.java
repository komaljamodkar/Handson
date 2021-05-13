package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extentreport {

	
	
	
		ExtentHtmlReporter htmlReporter;
		ExtentReports extent;
		WebDriver driver;
		@BeforeSuite
		public void setUp()
		{
			htmlReporter=new ExtentHtmlReporter("./test-output/"+"report2"+".html");
			extent=new ExtentReports();
			extent.attachReporter(htmlReporter);
			
			
			 
		}
		@BeforeTest
		public void setUpTest()
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
			 driver=new FirefoxDriver();
		}
		@Test
		public void test1() throws IOException
		{
			ExtentTest test=extent.createTest("facebook page-test","facebook serach page ");
			test.log(Status.INFO, "This step shows usage of log(status, details)");

			test.log(Status.INFO, "Strting test case");
			 driver.get("https://www.facebook.com/");
			 
			 test.pass("Navigate to facebook.com");
	        // info(details)
	        test.info("This step shows usage of info(details)");
	        
	        // log with snapshot
	        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	         
			test.addScreenCaptureFromPath("screenshot.png");
		}
		
		@Test
		public void test2() throws IOException
		{
			ExtentTest test=extent.createTest("facebook page-test","facebook serach page ");
			test.log(Status.INFO, "This step shows usage of log(status, details)");

	        // info(details)
	        test.info("This step shows usage of info(details)");
	        
	        // log with snapshot
	        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	         
			test.addScreenCaptureFromPath("screenshot.png");
		}
		
		@Test
		public void test3() throws IOException
		{
			ExtentTest test=extent.createTest("facebook page-test","facebook serach page ");
			test.log(Status.INFO, "This step shows usage of log(status, details)");

	        // info(details)
	        test.info("This step shows usage of info(details)");
	        
	        // log with snapshot
	        test.error("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	         
			test.addScreenCaptureFromPath("screenshot.png");
		}
		
		@Test
		public void test4() throws IOException
		{
			ExtentTest test=extent.createTest("facebook page-test","facebook serach page ");
			test.log(Status.INFO, "This step shows usage of log(status, details)");

	        // info(details)
	        test.info("This step shows usage of info(details)");
	        
	        // log with snapshot
	        test.skip("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	         
			test.addScreenCaptureFromPath("screenshot.png");
		}
		
		@Test
		public void test5() throws IOException
		{
			ExtentTest test=extent.createTest("facebook page-test","facebook serach page ");
			test.log(Status.INFO, "This step shows usage of log(status, details)");

	        // info(details)
	        test.info("This step shows usage of info(details)");
	        
	        // log with snapshot
	        test.info("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	         
			test.addScreenCaptureFromPath("screenshot.png");
		}
		
		@AfterTest
		public void tearDownTest()
		{
			driver.close();
			System.out.println("test case completed successfully");
		}
		
		@AfterSuite
		public void tearDown()
		{
			extent.flush();
		}
	}


