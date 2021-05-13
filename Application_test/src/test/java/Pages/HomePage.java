package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HomePage {
	private WebDriver driver ;
	private By FirstName  = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input") ;
	private By Email = By.xpath("//*[@id=\"eid\"]/input");
	private By Phone = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input");
	private By gender = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input");
	private By hobbies = By.xpath("//*[@id=\"checkbox1\"]");
	//private By country = By.xpath("//*[@id=\"countries\"]");
	private By refresh = By.xpath("//*[@id=\"Button1\"]");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement goToFirstName() {
		return driver.findElement(FirstName);
		
	}
	public WebElement goToEmail() {
		return driver.findElement(Email);
		
	}
	public WebElement goToPhone() {
		return driver.findElement(Phone);
		
	}
	public WebElement goToGender() {
		return driver.findElement(gender);
		
	}
	public WebElement goToHobbies() {
		return driver.findElement(hobbies);
		
	}
	public void goToCountry() {
		Select countries = new Select(driver.findElement(By.id("countries")));
		countries.selectByValue("India");
	}
	
	public WebElement clickOnRefresh() {
		return driver.findElement(refresh);
	}
	

}
