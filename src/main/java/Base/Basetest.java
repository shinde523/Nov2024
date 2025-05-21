package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Basetest {
	
	WebDriver driver;
	private static ThreadLocal<WebDriver>tLdriver=new ThreadLocal();
	
	public void initializedriver(String browser) {
	
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			tLdriver.set(driver);	
		}else if (browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			tLdriver.set(driver);	
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			tLdriver.set(driver);	
		}else {
			throw new IllegalArgumentException("browser not supported"+browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public static WebDriver getDriver() {
		return tLdriver.get();
	}
	
	public static void geturl(String url)
	{
		getDriver().get(url);
	}
}
