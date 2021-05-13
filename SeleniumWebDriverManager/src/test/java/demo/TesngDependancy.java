package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
//@Ignore
public class TesngDependancy {

	@Test(dependsOnMethods= {"test2","test3"},priority=1)
	//dependsOnGroups={"sanity"}
	//Ignore it ignores the test case
	public void test1()
	{
		System.out.println("test1");
	}
	@Test(priority=2/*groups={"sanity"}*/)
	public void test2()
	{
		System.out.println("test2");
	}
	@Test(priority=3)
	public void test3()
	{
		System.out.println("test3");
	}
	//execute test2 1st set by dependancy is 1st and priority is on 2nd.
	//implicit wait -it is used to define time until when webdriver should wait before throwing NO such Element exception
}//Explicit wait- can be set for specific elements
//wait until elements is clickable

//WebDriverWait wait= new WebDriverWait(driver,10);
//WebElement element= waituntil(ExpectedConditions.elementToBeClickable(By.id("abc")));

//fluent wait-a class in selenium api 
