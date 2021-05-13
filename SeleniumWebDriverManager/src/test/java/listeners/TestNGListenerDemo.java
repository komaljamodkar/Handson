package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {
	@Test
	public void test1()
	{
		System.out.println("in test 1");
	}
	@Test
	public void test2()
	{
		System.out.println("in test 2");
		Assert.assertEquals("abc", "abcs");
	}
	@Test
	public void test3()
	{
		System.out.println("in test 3");
		throw new SkipException("test is skipped");
	}
	@Test
	public void test4()
	{
		System.out.println("in test 4");
		
	}

}
