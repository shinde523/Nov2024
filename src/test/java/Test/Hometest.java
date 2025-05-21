package Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.Basetest;
import Config.ConfigReader;
import Page.Homepage;
import Page.LoginPage;
import junit.framework.Assert;
//Hometest class
public class Hometest extends Basetest {
		WebDriver driver;
		LoginPage login;
		Homepage home;
		SoftAssert soft;
		
		@Parameters("browser")
		@BeforeMethod
		public void prerequisite(@Optional("chrome")String browser) {
			initializedriver(browser);
			driver = getDriver();
			String url = ConfigReader.getProperty("url");
			geturl(url);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
			home=new Homepage(driver);
			login = new LoginPage(driver);
			login.loginToapp(ConfigReader.getProperty("loginid"),ConfigReader.getProperty("password"));
			soft=new SoftAssert();
		}
		@Test
		public void test_verifyTitle() throws InterruptedException {
			String actualTitle=home.getPageTile();
			String expectedTitle="OpenMRS";
			System.out.println(actualTitle);
			Assert.assertEquals(expectedTitle,actualTitle);
			Thread.sleep(3000);
		}
		@AfterMethod
		public void teardown() {
			//driver.quit();
		}
}
