package BaseSetUp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SetUp {
private WebDriver driver;
	
	@Parameters({"browserType", "appUrl"})
	@BeforeClass
	public void initializeBaseTestSetup(String browserType, String appUrl) {
		switch(browserType) {
		case "chrome":
			initChromeDriver(appUrl);
			break;
		case "firefox":
			initFirefoxDriver(appUrl);
			break;
			
		default:
			Reporter.log("Going ahead with the default browser as chrome");
			initChromeDriver(appUrl);
		}
	}
 
	
	
	private void initFirefoxDriver(String appUrl) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	private void initChromeDriver(String appUrl) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
