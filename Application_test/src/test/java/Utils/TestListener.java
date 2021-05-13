package Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{
	public void onStart(ITestContext context) {
		
		   System.out.println("Test Started");
		  }
		
		public void onTestStart(ITestResult result) {
		    
			System.out.println("Running Test Name :- " + result.getName());
		  }

		public void onTestSuccess(ITestResult result) {
			
			System.out.println("Test Success Name :- " + result.getName());
		    
		  }
		
		public void onTestFailure(ITestResult result) {
			
			System.out.println("Test Failure Name :- " + result.getName());
			ITestContext context = result.getTestContext();
			
			String methodName = result.getName();
			WebDriver driver = (WebDriver)context.getAttribute("webdriver");
			getScreenshot(methodName, driver);
		  
		  }


	public void getScreenshot(String methodName, WebDriver driver) {
			
			String filePath = ".\\Screenshot\\";
			String destFileName = filePath + methodName + ".jpg";
			File destFile = new File(destFileName);
			TakesScreenshot scrShot = (TakesScreenshot) driver;
			File scrShotFile = scrShot.getScreenshotAs(OutputType.FILE);
			
			try {
				Files.copy(scrShotFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
		}
		public void onFinish(ITestContext context) {
			
			System.out.println("Test Finish");
		  }
	

}
