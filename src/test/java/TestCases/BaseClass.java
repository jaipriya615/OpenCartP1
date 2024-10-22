package TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseClass{
	
public WebDriver driver;
public Logger logger;
public Properties p;
	
	@BeforeClass(groups= {"sanity","Regression","Master"})
	@Parameters({"os","browser"})
	//void setup(String os,String br) throws IOException
	void setup(@Optional("windows") String os, @Optional("chrome") String br) throws IOException 
	{
		
		//configure file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		//Remote excetion GRID
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities Capabilities =new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows"))
			{
				Capabilities.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				Capabilities.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("Linux"))
			{
				Capabilities.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("No Mathch OS");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome":Capabilities.setBrowserName("chrome");break;
			case "edge":Capabilities.setBrowserName("MicrosoftEdge");break;
			default:System.out.println("No avalable....");
			}
			driver=new RemoteWebDriver(new URL("http://192.168.1.7:4444/wd/hub"),Capabilities);
			
		}
		
		//local execution
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) 
		{
			switch(br.toLowerCase()) {
			case "chrome" :driver=new ChromeDriver();break;
			case "edge" :driver=new EdgeDriver();break;
			case "firefox" :driver=new FirefoxDriver();break;
	        default : System.out.println("invailed browser");return;	
			}
			
		}
			
		//driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"sanity","Regression","Master"})
	void close()
	{
		driver.quit();
	} 
	
	//random num or char
	public String randomString()
	{
		String random=RandomStringUtils.randomAlphabetic(4);
		return random;
	}
	public String randomNumber()
	{
		String number=RandomStringUtils.randomNumeric(10);
		return number;
	}
	
    public String charcterNumber()
    {
    	
    	String number=RandomStringUtils.randomNumeric(3);
		String random=RandomStringUtils.randomAlphabetic(2);
		return(number+"@"+random);

    }
    
    public String ScreenShot(String fname) {
    	
    	String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    	
    	TakesScreenshot tacksScreenshot = (TakesScreenshot) driver;
    	File soure = tacksScreenshot.getScreenshotAs(OutputType.FILE);
    	
    	String targetfilepath=System.getProperty("user.dir")+"\\Screenshorts\\" +fname+ "_"+ timeStamp +".png";
    	File targetFile=new File(targetfilepath);
    	
    	soure.renameTo(targetFile);
    	return targetfilepath;
    	
    	
    	
    }
	

}
