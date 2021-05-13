package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParenttochildXpath {

	static WebDriver driver=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.getProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver=new ChromeDriver();

		//load new webpage
		
			driver.get("https://www.google.com");
			
		driver.close();
		driver.quit();
		/*
		 * parent to child xpath p--->child define parent/tagname
		 * 
		 *  $x("//div[@class='SDkEP']")
		 *  $x("//div[@class='SDkEP']/div/input") for chrome
		 *  $x("//div[@class='SDkEP']/div/div[2]/input") for contains 2 divs in 1 divclass

			relative xpath doesnt depend on parent node
			parent child in absolute xpath viseversa only possible in xpath not in Css
			
			traverse back to parent node
			(".//*[@id='tablist1-tab1']/parent::ul")
			
			sibling element using xpath
			("//*[@id='tablist1-tab1']/following-sibling::li[1]")
			
			identify objects with text using locators xpath
			
			//*[text()='Round trip'] if space in text copy with space
			 * 
			 * driver.findElement(By.xpath("//ul[@class='responsive-tabs__list']/li[1]/following-sibling::li[2]")).click();

System.out.println(driver.findElement(By.xpath(".//*[@id='tablist1-tab2']/parent::ul")).getAttribute("role"));
//

			 */
		

		
		
	}

}
