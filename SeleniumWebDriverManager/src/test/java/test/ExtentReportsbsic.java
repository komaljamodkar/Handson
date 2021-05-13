package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsbsic {
	private static WebDriver driver=null;
	public static void main(String[] args) {
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("reports1.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		ExtentTest test1=extent.createTest("facebook page-test","facebook serach page ");
		
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
		 driver=new FirefoxDriver();
		 
		 test1.log(Status.INFO, "Strting test case");
		 driver.get("https://www.facebook.com/");
		 
		 test1.pass("Navigate to facebook.com");
		 
		 driver.findElement(By.id("email")).sendKeys("abc");
		 test1.pass("entered username in username");
		 
			List<WebElement> links=driver.findElements(By.tagName("a"));
			System.out.println("links: "+links.size());
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("abc123");
			test1.pass("entered password in password");
			
			driver.findElement(By.linkText("Sign Up")).click();
			test1.fail("naviate to next page");
			
			driver.close();
		
			test1.pass("close the browser");
			test1.info("Test completed...");
			
			extent.flush();
			
	}

}
