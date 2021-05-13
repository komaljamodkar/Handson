package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener{
	
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test started :"+result.getName());
	}
	
	public void onTestFinish(ITestResult result)
	{
		
	}
	
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Skipped of test cases :"+result.getName());
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Success of test cases :"+result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Failure of test cases :"+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{  
		 
		 System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	
	public void onFinish(ITestContext context) {  
		  System.out.println("Finished of test cases :"+context.getName());
	  } 
}
