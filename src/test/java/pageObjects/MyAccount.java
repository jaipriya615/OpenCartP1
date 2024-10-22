package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TestCases.BaseClass;

public class MyAccount extends BasePage{
	

	public MyAccount(WebDriver driver) {
		super(driver);
	}
	

    @FindBy(xpath="//h2[normalize-space()='My Account']")
    WebElement Acc;
    
    @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement logout;
    
    
    public boolean display() 
    {
    	try
    	{
    	return Acc.isDisplayed();	
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    	
    }
    public void clickLogout()
    {
    	logout.click();
    }


}
