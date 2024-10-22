package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import org.testng.annotations.DataProvider;

public class TC003_loginExcel extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=DataProvider.class)
	public void verificyLogin(String email,String pwd,String exp)
	{

        //Homepage
		HomePage HM=new HomePage(driver);
		HM.myAccount();
		HM.getloginPage();
		
		//login
		LoginPage lp=new LoginPage(driver);
		lp.getmail(email);
		lp.getpwd(pwd);
		lp.clicklogin(null);
		
		//myaccount
		MyAccount MA=new MyAccount(driver);
		boolean targetPage=MA.display();
		
		/*vailed mail - login sucess -test pass 
		               login fail-test fail 
		               
		invailed mail   - login sucess -fail
		                  login is fail - pass*/
		
		if(exp.equalsIgnoreCase("valied"))
		{
			if(targetPage==true)
			{
				Assert.assertTrue(true);
				MA.clickLogout();
			}
			else
			{
				Assert.assertTrue(false);
			}
			
			
		    if(exp.equalsIgnoreCase("invalied"))
			{
				if(targetPage==true)
				{
					Assert.assertTrue(true);
					MA.clickLogout();
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
		}
	
	}
	
	
}
