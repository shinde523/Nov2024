package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Basetest;

public class Homepage {
	
	WebDriver driver;
	
	public Homepage(WebDriver driver)
	{
		driver=Basetest.getDriver();
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public String getPageTile() {
		return driver.getTitle();
	}
}