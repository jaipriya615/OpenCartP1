package TestCases;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePage;
import pageObjects.regesterPage;

public class TC_AccountRegTest extends BaseClass {
	
	@Test(groups={"Regression","Master"})
	void regester()
	{   
		logger.info("***********starting TC_AccountRegTest**********");
		try
		{
			HomePage HM=new HomePage(driver);
			HM.myAccount();
			logger.info("Click MyAccount...........");
	
			HM.register();
			logger.info("Click Register...........");
	
			regesterPage RG=new regesterPage(driver);
			
			logger.info("providing customer details...........");
	
			RG.FirstName(randomString().toUpperCase());
			RG.LastName(randomString().toUpperCase());
			RG.gmail(randomString()+"ra@mail.com");
			RG.Phone(randomNumber());
			
			String pw=charcterNumber();
			
			RG.setpassword(pw);
			RG.setconpassword(pw);
			RG.setPrivecyPolicy();
			RG.contiuebut();
	    	
			logger.info("validate the message...........");
	
			String conformMessage=RG.getconformationMsg();
			//Assert.assertEquals(conformMessage,);
		    if(conformMessage.equals("Your Account Has Been Created!")) 
		    {
		    	Assert.assertTrue(true);
		    }
		    else 
		    {
			    Assert.assertTrue(false);
			    logger.error("Test Fail");
		    	logger.debug("Debug log..");
	        }
		}
		    catch(Exception e)
		    {
		    	
		    	Assert.fail();
		    }
	}
	
	

}
