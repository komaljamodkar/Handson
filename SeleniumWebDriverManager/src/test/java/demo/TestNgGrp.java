package demo;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

@Test(groups= {"AllClassTests"})
public class TestNgGrp {

	@Test(groups= {"smoke"})
	public void test1()
	{
		System.out.println("test1");
	}
	@Test(groups= {"sanity"})
	public void test2()
	{
		System.out.println("test2");
	}
	@Test(groups= {"smoke","sanity"})
	public void test3()
	{
		System.out.println("test3");
	}
	//if exclude regression but included smoke then it run , if only regression then it excluded
	@Test(groups= {"smoke","regression"})
	public void test4()
	{
		System.out.println("test4");
	}
	@Test(groups= {"windows.regression"})
	public void test5()
	{
		System.out.println("test5");
	}
	
	
}
