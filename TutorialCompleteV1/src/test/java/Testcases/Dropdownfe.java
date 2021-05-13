package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdownfe {

	static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.getProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver=new ChromeDriver();

		//load new webpage
		
			driver.get("https://www.spicejet.com/");
			//for static dropdown we use select class
			
			Thread.sleep(20000);
			Select drop=new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
			drop.selectByIndex(2);
			String txt1=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).getText();
			
			System.out.println("name:"+txt1);
			driver.findElement(By.id("divpaxinfo")).click();
			Thread.sleep(20000);
			Select drop1=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
			drop1.selectByIndex(2);
			/*for(int i=0;i<3;i++){
				driver.findElement(By.id("ctl00_mainContent_ddl_Adult")).click();
				
			}
			*/
String txt2=driver.findElement(By.id("ctl00_mainContent_ddl_Adult")).getText();
			
			System.out.println("name:"+txt2);
			
			
			Thread.sleep(20000);
		driver.close();
		driver.quit();
		
	}

}
