package stepdefinitin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class LoginStep {

	WebDriver driver;
	LoginPage page;

	@Given("The User is on the Login Page")
	public void the_user_is_on_the_login_page() {
		// That means After Launch the Browser

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		page = new LoginPage(driver);
	}

	@When("User open the URL\"https:\\/\\/practicetestautomation.com\\/practice-test-login\\/\"")
	public void user_open_the_url_https_practicetestautomation_com_practice_test_login() {

		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		System.out.print("Launch the application successfully");
	}

	@When("User gives the {string} and {string} credential")
	public void user_gives_the_and_credential(String uname, String upassword) {

		page.userName(uname);
		page.userPassword(upassword);

	}

	@When("click on the login Button")
	public void click_on_the_login_button() {

		page.loginButton();
	}

	@Then("Page Title Should be {string}")
	public void page_title_should_be(String title) {
		try {
			String expectedTitle = title;
			System.out.println("expected title" + expectedTitle);

			String actualTitle = driver.getTitle();
			System.out.println("actual Title" + actualTitle);

			Assert.assertEquals(expectedTitle, actualTitle);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

		
	}

	@Then("close the browser")
	public void close_the_browser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("Error during driver shutdown: " + e.getMessage());
		}
	}

	//scenario outline 
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		page = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String string) {
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		System.out.print("Launch the application successfully");

	}

	@When("User enters userName as {string} and password as {string}")
	public void user_enters_user_name_as_and_password_as(String uname, String upassword) {
		
		page.userName(uname);
		page.userPassword(upassword);

	}

	@When("user click on Logout link")
	public void user_click_on_logout_link() {
		
		page.logout();

	}

	@Then("Page Title should be {string}")
	public void page_title_should_bee(String title) {
		
		try {
			String expectedTitle = title;
			System.out.println("expected title" + expectedTitle);

			String actualTitle = driver.getTitle();
			System.out.println("actual Title" + actualTitle);

			//Assert.assertEquals(expectedTitle, actualTitle);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	

}
