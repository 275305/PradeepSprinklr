package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver rdriver) {
		
		driver=rdriver;
		
		PageFactory.initElements(rdriver,this);
		
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement userPassword;
	
	@FindBy(xpath = "//button[@id='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logout;
	
	public void userName(String uname) {
		
		userName.sendKeys(uname);
	}
	
	public void userPassword(String upassword) {
		
		userPassword.sendKeys(upassword);
		
	}
	
	public void loginButton() {
		
		loginButton.click();
	}
	
	public void logout() {
		
		logout.click();
		
	}
	
}
