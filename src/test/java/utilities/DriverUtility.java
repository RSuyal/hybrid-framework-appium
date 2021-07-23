package utilities;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverUtility {
	
	static AppiumDriver<MobileElement> localDriver;

	public static AppiumDriver<MobileElement> setDriverAndLaunchApp(String automationName, String platformName, String platformVersion, String deviceName, String appPackage, String appActivity, String serverUrl)
	{
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
			System.out.println("PLATFORM_NAME");
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
			System.out.println("DEVICE_NAME");
			dc.setCapability("appPackage", appPackage);
			dc.setCapability("appActivity", appActivity);
			System.out.println(automationName+platformName+platformVersion+deviceName+appPackage+appActivity+serverUrl);
			URL url = new URL(serverUrl);
			
			localDriver = new AppiumDriver<MobileElement>(url, dc);
			System.out.println("localDriver");
		} catch (Exception e) {

			System.out.println("Cause is: "+e.getCause());
			System.out.println("Message is: "+e.getMessage());
		}
		return localDriver;
	}

	public static AppiumDriver<MobileElement> setDriverAndInstallApp(String automationName, String platformName, String platformVersion, String deviceName, String appPath, String serverUrl)
	{
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			dc.setCapability(MobileCapabilityType.APP, appPath);
			URL url = new URL(serverUrl);		
			localDriver = new AppiumDriver<MobileElement>(url, dc);
		} catch (Exception e) {

			System.out.println("Cause is: "+e.getCause());
			System.out.println("Message is: "+e.getMessage());
		}
			return localDriver;		
	}
	
	public static AppiumDriver<MobileElement> setDriver(String appNameWithExtension)
	{
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
			dc.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"//apps//"+appNameWithExtension);
			URL url= new URL("http://127.0.0.1:4723/wd/hub");
			localDriver = new AppiumDriver<MobileElement>(url, dc);
			}
		catch(Exception exc) {
			System.out.println("Cause is: "+exc.getCause());
			System.out.println("Message is: "+ exc.getMessage());
		}
		return localDriver;
	}
	
	public static AppiumDriver<MobileElement> setDrive(String appPackage,  String appActivity)
	{
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
			dc.setCapability("appPackage", appPackage);
			dc.setCapability("appActivity", appActivity);
			URL url= new URL("http://127.0.0.1:4723/wd/hub");
			localDriver = new AppiumDriver<MobileElement>(url, dc);
			}
		catch(Exception exc) {
			System.out.println("Cause is: "+exc.getCause());
			System.out.println("Message is: "+ exc.getMessage());
		}
		return localDriver;
	}

}
