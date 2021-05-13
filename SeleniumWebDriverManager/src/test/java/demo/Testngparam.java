package demo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testngparam {

	@Test
	@Parameters({"Myname"})
	public void test(String name)
	{
		System.out.println("name="+name);
	}
}
