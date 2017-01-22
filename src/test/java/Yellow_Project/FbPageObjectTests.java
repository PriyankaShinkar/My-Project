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

import pages.FacebookmainPage;
import data.DataProviderClass;

public class FbPageObjectTests {

WebDriver driver;
FacebookmainPage fbpage;

@BeforeClass(alwaysRun=true)
	public void setUp() {
		System.setProperty("webdriver.firefox.marionette", "/Users/priy2849/Desktop/plugins/geckodriver");
		driver = new FirefoxDriver();
		fbpage = new FacebookmainPage(driver);
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups="P1", dataProvider="pages", dataProviderClass=DataProviderClass.class)
	public void navigateFB(String url, String title){
		driver.get(url);
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	@Test(dependsOnMethods="navigateFB")
	public void enterEmail() {
		String stringemail = "priya@gmail.com";
		fbpage.enterEmail(stringemail);
	}
	
	@Test(dependsOnMethods="enterEmail")
	public void enterPwd(){
		String stringpwd = "priya";
		fbpage.enterPwd(stringpwd);
	}
	
	@Test(dependsOnMethods="enterPwd")
	public void login(){
		fbpage.clickLogin();
	}
}
