package Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.Basetest;
import Config.ConfigReader;
import Page.LoginPage;
import junit.framework.Assert;
import listener.TestListener;
@Listeners(TestListener.class)
//LoginTest class
public class LoginTest extends Basetest {

	WebDriver driver;
	LoginPage login;
	SoftAssert soft;
	
	@Parameters("browser")
	@BeforeMethod
	public void prerequisite(@Optional("chrome")String browser) {
		initializedriver(browser);
		driver = getDriver();
		String url = ConfigReader.getProperty("url");
		geturl(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		login = new LoginPage(driver);
		soft=new SoftAssert();
	}
	@Test(priority=1,groups= {"sanity"},enabled=true)
	
	public void test_IsusernameDisplayed() throws InterruptedException {
		boolean username=login.checkUsernameTodisplay();
		Thread.sleep(3000);
		Assert.assertTrue(username);
		System.out.println("Username is displayed is:"+username);
	}
	
	@Test(priority=3,groups= {"regression"},enabled=true)
	public void test_InvalidLogin() throws InterruptedException {
		login.loginToapp("qwerty", "qwerty123");
		String expectedurl="https://o3.openmrs.org/openmrs/spa/login";
		String actualurl=driver.getCurrentUrl();
		boolean username=login.checkUsernameTodisplay();
		Assert.assertTrue(username);
		Thread.sleep(3000);
		System.out.println(username);
		soft.assertAll(" soft Assert Executed");
	}
	
	
	@Test(priority=2,dependsOnMethods={"test_IsusernameDisplayed"},groups= {"sanity","regression"},enabled=true)
	public void test_LoginToApplication() throws InterruptedException {
		login.loginToapp(ConfigReader.getProperty("loginid"),ConfigReader.getProperty("password"));
		Thread.sleep(3000);
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
