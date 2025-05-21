package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addpatientpage {
	
	WebDriver driver;

    public Addpatientpage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    }
    
    @FindBy(name= "AddPatientIcon")
    private WebElement registerPatientTile;

    // Patient name fields
    @FindBy(name = "givenName")
    private WebElement givenName;

    @FindBy(name = "middleName")
    private WebElement middleName;

    @FindBy(name = "familyName")
    private WebElement familyName;
    
    @FindBy(name="gender")
    private WebElement genderDropdown;

    @FindBy(xpath = "//option[text()='Female']")
    private WebElement selectFemale;

    @FindBy(name = "birthdateDay")
    private WebElement birthDay;

    @FindBy(name = "birthdateMonth")
    private WebElement birthMonth;

    @FindBy(name = "birthdateYear")
    private WebElement birthYear;

    
    public void clickRegisterPatient() {
        registerPatientTile.click();
    }

    public void enterBasicInfo(String payal, String suresh, String shinde) {
        givenName.sendKeys(payal);
        middleName.sendKeys(suresh);
        familyName.sendKeys(shinde);
    }
    public void selectGender() {
        genderDropdown.click();
        selectFemale.click();
       
    }
    public void enterBirthdate(String day, String month, String year) {
        birthDay.sendKeys(day);
        birthMonth.sendKeys(month);
        birthYear.sendKeys(year);
       
    }




}
