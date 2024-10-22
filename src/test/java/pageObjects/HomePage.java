package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	WebDriver driver;
	
	//constractor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	//location
	@FindBy(xpath="//a[@title='My Account']")
	WebElement Account;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login;
	
	//action
	public void myAccount() {
		Account.click();
	}
	public void register() {
		Register.click();
	}	
    public void getloginPage() {
    	login.click();
    }	
    	
    public void clickUsingJavaScript(WebElement element) {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 js.executeScript("arguments[0].click();", element);
    
	}

}
