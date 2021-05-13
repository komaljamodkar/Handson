package Testcases;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectorCss {

	static WebDriver driver=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.getProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver=new ChromeDriver();

		//load new webpage
		
			driver.get("https://login.salesforce.com/?locale=eu");
			
			//css is 10x times faster than xpath
			/*
			 * syntax for xpath //tagname[@attribure='value']
			 * //span[@id='idcard-identity']
			 * //div[@id='idcard']
			 * 
			 * if only a one value then remove tagname
			 * //*[@id='idcard'] identify  by *
			 * for CSS remove @ n tagname to
			 * [id='idcard'] remove tagname
			 * $("[id='idcard-identity']")
			 * 
			 * classname in which replace space by .
			 * if it is an id then use# css identified ny #
			 * <input class="input r4 wide mb16 mt8 password" type="password" id="password" name="pw" onkeypress="checkCaps(event)" autocomplete="off" xpath="1">
			 * 
			 * #password //for id 
			 * .input.r4.wide.mb16.mt8.password //for class name replace space with 
			 * 
			 * div id is dyanalic  then select xpath //li[@name='item1']/following-sibling::li
			 * <div id=”name_12”>

<ul>

<li name=”item1”>Xpath</li>

<li name=”item2”>Css</li>

<li name=”item3”>Partial Text</li>

</ul>

</div>


.
			 * */
			
		driver.close();
		driver.quit();
	}
		
}
