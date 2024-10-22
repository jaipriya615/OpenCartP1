package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class regesterPage extends BasePage {
	
	WebDriver driver;
	
	//contruator
	public regesterPage(WebDriver driver) {
		super(driver);
	}
	
	//location
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement mail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement phone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement conform;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement conform1;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement button;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement cofMessage;
	
	//action
	public void FirstName(String Name) {
		name.sendKeys(Name);
	}
	
	public void LastName(String Lname) {
		lastname.sendKeys(Lname);
	}
	
	public void gmail(String Mail) {
		mail.sendKeys(Mail);
	}
	
	public void Phone(String moblie) {
		phone.sendKeys(moblie);
	}
	
	public void setpassword(String pwd) {
		conform.sendKeys(pwd);
	}
	
	public void setconpassword(String pwds) {
		conform1.sendKeys(pwds);
	}
	
	public void setPrivecyPolicy() {
		 agree.click();
	}

	public void contiuebut() {
		button.click();
	} 
	
	public String getconformationMsg() {
		return(cofMessage.getText());
	}
	
}
