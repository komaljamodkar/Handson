package Tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseSetUp.SetUp;
import Utils.ReadExcel;
import Pages.HomePage;



public class PageTest extends SetUp {
	private WebDriver driver;
    HomePage HP;
    String expected =null;
	String actual = null;
	
	private ReadExcel read;
	String filePath = "./DataFile/Register.xlsx";
	String sheetName = "Sheet1";
	
	@BeforeClass
	  public void setUp() {
		  driver = getDriver();
		  HP = new HomePage(driver);
		
	  }
	
	
  @Test(enabled = true, dataProvider = "Form")
  public void registerTest (String fname, String email, String PhoneNo){
	  
	  
	  
	  HP.goToFirstName().sendKeys(fname);
	  HP.goToEmail().sendKeys(email);
	  HP.goToPhone().sendKeys(PhoneNo);
	  
	  HP.goToGender().click();
	  HP.goToHobbies().click();
	  HP.goToCountry();
	  HP.clickOnRefresh().click();
	  
	  expected = "";
	  actual = HP.goToEmail().getText();
	  
	  //To Verify email address is empty(Null)
	  assertTrue(expected.contentEquals(actual));
	  
		
	  
  }
  
  
  //To provide data from excel
  @DataProvider(name = "Form")
	public String[][] getValidData() throws IOException {
		
		return read.readExcel(filePath, sheetName);
	}
}
