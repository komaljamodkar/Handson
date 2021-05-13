import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {

	public static void main(String[] args) {
		/*WebDriverManager.chromedriver().version("81.0").setup();
		WebDriver driver=new ChromeDriver();*/
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.google.com");
		driver.close();
		driver.quit();
	}
	
}
