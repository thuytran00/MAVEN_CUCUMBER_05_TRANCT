package stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import junit.framework.Assert;
import junit.framework.AssertionFailedError;

public class LoginSteps {
	WebDriver driver;
	static String userID, password, loginPageUrl;

	public LoginSteps() {
		driver = Hooks.openBrowser();
	}

	@When("^I open login page by url$")
	public void iOpenLoginPageByUrl() {
		driver.get("http://demo.guru99.com/V1/index.php");
	}

	@When("^I click to Login button at Register page$")
	public void iClickToLoginButtonAtRegisterPage() {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}

	
	@Then("^I close browser$")
	public void i_close_browser() {
		driver.quit();

	}
	
	@When("^I sleep some times$")
	public void iSleepSomeTime()  {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Given("^I open New Customer page$")
	public void i_open_New_Customer_page() {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
	}

	@SuppressWarnings("deprecation")
	@When("^Input to New Customer form with data$")
	public void input_to_New_Customer_form_with_data(DataTable customerTable) {
		List<Map<String, String>> customer = customerTable.asMaps(String.class, String.class);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(customer.get(0).get("Name"));
		driver.findElement(By.xpath("//input[@name='rad1']")).click();
		driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(customer.get(0).get("DateOfBirth"));
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(customer.get(0).get("Address"));
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(customer.get(0).get("City"));
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(customer.get(0).get("State"));
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(customer.get(0).get("Pin"));
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(customer.get(0).get("Phone"));
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(customer.get(0).get("Email"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(customer.get(0).get("Password"));
		
//		for (Map<String, String> customerLoop : customerTable.asMaps(String.class, String.class)) {
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(),customerLoop.get("Name"));
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(),customerLoop.get("DateOfBirth"));
//		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(),customerLoop.get("Address"));
//		
//		}
	}

	@When("^I click to Submit button at New Customer page$")
	public void i_click_to_Submit_button_at_New_Customer_page() {

	}

	@Then("^Verify message displayed with data \"(.*?)\"$")
	public void verify_message_displayed_with_data(String arg1) {

	}

	@Then("^I verify all above infomation created success$")
	public void i_verify_all_above_infomation_created_success(DataTable arg1) {

	}

	@When("^I get Customer ID at New Customer page$")
	public void i_get_Customer_ID_at_New_Customer_page() {

	}

	public String randomEmail() {
		Random random = new Random();
		String randomEmail = random.nextInt(99999) + "@gmail.com";
		return randomEmail;
	}
}
