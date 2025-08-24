package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmpTest {
	
	WebDriver driver;

	@Test(priority = 1)
	public void getBrowser() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
	}
	
	@Test(priority = 2)
	public void getGUIElement() {
		
	WebElement name=driver.findElement(By.cssSelector("input[placeholder=\"Enter Name\"]"));
		
		name.sendKeys("Pradeep");
		
		
		WebElement email = driver.findElement(By.cssSelector("input[placeholder=\"Enter EMail\"]"));
	         email.sendKeys("pradeepmatrix2@gmail.com");
	}
	
	@AfterClass
	public void getquit() {
		driver.quit();
	}

}
