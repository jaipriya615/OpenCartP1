package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//locator
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath="//input[@value='Login']")
	WebElement log;
	
	//action
	public void getmail(String Mail) {
		Email.sendKeys(Mail);
	}
	public void getpwd(String paword) {
		password.sendKeys(paword);
	}
	public void clicklogin(String Mail) {
		log.click();
		
		
	}
	
		
	
	
	
	

}
