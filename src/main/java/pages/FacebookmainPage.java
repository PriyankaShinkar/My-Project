package pages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FacebookmainPage {

	WebDriver driver;
	public static final String URL = "https://www.facebook.com";
	public static final String TITLE = "Facebook";
	
	public FacebookmainPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver = driver; 
}
	String Field_email_SignIn = "#email";
	String Field_pwd_SignIn = "#pass";
	String Field_Login = "#u_0_o";
	
	public void enterEmail(String text) {
		WebElement email = driver.findElement(By.cssSelector(Field_email_SignIn));
		email.sendKeys(text);
		Assert.assertEquals(email.getAttribute("value"), text);
	}
	
	public void enterPwd(String text) {
		WebElement password = driver.findElement(By.cssSelector(Field_pwd_SignIn));
		password.sendKeys(text);
		Assert.assertEquals(password.getAttribute("value"), text);
	}
	
	public void clickLogin() {
		WebElement login = driver.findElement(By.cssSelector(Field_Login));
		login.click();
	}
	
}
