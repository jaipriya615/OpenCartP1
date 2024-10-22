package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;

public class TC002_login extends BaseClass{
	
	@Test(groups={"sanity","Master"})
	public void verificyLogin()
	{
		logger.info("*******************start TC002_login page************");
		try {
			
		
		//homepage
		HomePage HM=new HomePage(driver);
		HM. myAccount();
		HM.getloginPage();
		
		//login
		LoginPage lp=new LoginPage(driver);
		lp.getmail(p.getProperty("email"));
		lp.getpwd(p.getProperty("pwd"));
		lp.clicklogin(null);
		
		//myaccount
		MyAccount MA=new MyAccount(driver);
		boolean targetPage=MA.display();
		Assert.assertTrue(targetPage);
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("**************End TC002_login page************");		
	}

}
