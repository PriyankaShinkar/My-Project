package Yellow_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacebookTests {

WebDriver driver;
	
@BeforeClass(alwaysRun=true)
	public void setUp() {
		System.setProperty("webdriver.firefox.marionette", "/Users/priy2849/Desktop/plugins/geckodriver");
		driver = new FirefoxDriver();
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups="P1")
	public void navigateFB(){
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
	}
	
	@Test(dependsOnMethods="navigateFB")
	public void enterEmail() {
		String stringemail = "priya@gmail.com";
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys(stringemail);
		Assert.assertEquals(emailField.getAttribute("value"), stringemail);
	}
	
	@Test(dependsOnMethods="enterEmail")
	public void enterPwd(){
		String stringpwd = "priya";
		WebElement pwdField = driver.findElement(By.id("pass"));
		pwdField.sendKeys(stringpwd);
	}
	
	@Test(dependsOnMethods="enterPwd")
	public void login(){
		WebElement loginButtonElement = driver.findElement(By.id("u_0_o"));
		loginButtonElement.click();
	}
}
