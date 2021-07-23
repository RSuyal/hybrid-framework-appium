package testcases;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilities.DriverUtility;
import utilities.ReadConfig;

public class BaseClass {	

	public static ReadConfig readConfiguration=new ReadConfig();
	public String defaultAppiumAutomationName = readConfiguration.getDefaultAppiumAutomationName();
	public String defaultPlatformName = readConfiguration.getDefaultPlatformName();
	public String defaultPlatformVersion = readConfiguration.getDefaultPlatformVersion();
	public String defaultDeviceName = readConfiguration.getDefaultDeviceName();
	public String defaultAppPath = readConfiguration.getDefaultAppPath();
	public String defaultAppPackage = readConfiguration.getDefaultAppPackage();
	public String defaultAppActivity = readConfiguration.getDefaultAppActivity();
	public String defaultAppiumServerUrl = readConfiguration.getDefaultAppiumServerUrl();

	
	public static AppiumDriver<MobileElement> driver;
	public static Logger logger;
	
	/*
	@BeforeClass
	public void setup()
	{
		logger=Logger.getLogger("Appium_Hybrid_Framework");
		PropertyConfigurator.configure("log4j.properties");		
		driver = DriverUtility.setDrive("com.android.settings", "com.android.settings.Settings");
	}	
	*/

	
	@Parameters("actionType")
	@BeforeClass
	public void setup(String at)
	{
		
		logger=Logger.getLogger("Appium_Hybrid_Framework");
		PropertyConfigurator.configure("log4j.properties");

		if (at.equalsIgnoreCase("installandlaunch") ||
				at.equalsIgnoreCase("install") ||
				at.equalsIgnoreCase("install and launch"))
		{
			
			driver= DriverUtility.setDriverAndInstallApp(defaultAppiumAutomationName, defaultPlatformName, defaultPlatformVersion, defaultDeviceName, defaultAppPath, defaultAppiumServerUrl);
		}

		else 
		{

			driver= DriverUtility.setDriverAndLaunchApp(defaultAppiumAutomationName, defaultPlatformName, defaultPlatformVersion, defaultDeviceName, defaultAppPackage, defaultAppActivity, defaultAppiumServerUrl);
		}
	}
	


	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(AppiumDriver<MobileElement> driver, String imageName)
	{
		try
			{
				TakesScreenshot ts =(TakesScreenshot)driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				File target = new File("./screenshots/"+imageName+".png");
				FileUtils.copyFile(source,target);
				System.out.println("screenshot generated");
			}
		catch(Exception e)
			{
				System.out.println("exception genrated");
			}
		}
	
	@AfterMethod
	public void faliurScreenshotMethod(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			captureScreen(driver, result.getName());
		}
	}

}
