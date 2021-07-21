package testcases;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilities.DriverUtility;

public class BaseClass {
	
	public static AppiumDriver<MobileElement> driver;
	
		
	@BeforeClass
	public void setup()
	{
		driver=DriverUtility.setDriver();				
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
