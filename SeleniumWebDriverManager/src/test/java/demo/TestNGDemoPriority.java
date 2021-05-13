package demo;

import org.testng.annotations.Test;

public class TestNGDemoPriority {

	@Test(priority=1)
	public void test1()
	{
		System.out.println("test1");
	}
	@Test(priority=1)
	public void one()
	{
		System.out.println("test1");
	}
	@Test(priority=1)
	public void test3()
	{
		System.out.println("test1");
	}
	//priority same run with function in alphabetical order sequence -1 0 1sequence exceute
	//if not priority then run 1st 
}
