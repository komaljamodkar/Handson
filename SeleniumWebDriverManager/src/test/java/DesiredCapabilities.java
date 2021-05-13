import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DesiredCapabilities {

	public static void main(String[] args) {
		DesiredCapabilities caps=new DesiredCapabilities();
		
		System.getProperty("webdriver.opera.driver","./drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		
driver.get("https://www.google.com");
		
driver.findElement(By.name("q")).sendKeys("Automation step by step");
driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN);
driver.close();
driver.quit();
		 
	}
}
