package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Basetest;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		driver=Basetest.getDriver();
		PageFactory.initElements(driver,this);	
	}
	
	@FindBy(xpath="//label[text()='Username']")
	private WebElement usernamelbl;
	
	@FindBy(id="username")
	private WebElement userid;
	
	@FindBy(xpath="//button[@type='button'][text()='Continue']")
	private WebElement continueBtn;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit'][text()='Log in']")
	private WebElement loginbtn;
	
	
	public boolean checkUsernameTodisplay() {
		return usernamelbl.isDisplayed();
	}
	
	public void loginToapp(String id, String passwd) {
		
		userid.sendKeys(id);
		continueBtn.click();
		password.sendKeys(passwd);
		loginbtn.click();
	}
}
