package utilities;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverUtility {

	protected static AppiumDriver<MobileElement> localDriver;
	protected static DesiredCapabilities dc = new DesiredCapabilities();


	public static AppiumDriver<MobileElement> setDriver()
	{
		try {
			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
			dc.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"//apps//Calculator.apk");

			URL url= new URL("http://127.0.0.1:4723/wd/hub");
			localDriver = new AppiumDriver<MobileElement>(url, dc);
		}
		catch(Exception exc) {
			System.out.println("Cause is: "+exc.getCause());
			System.out.println("Message is: "+ exc.getMessage());
		}
		return localDriver;
	}

	public static AppiumDriver<MobileElement> setDriver(String platformName, String deviceName, String platformVersion, String appPackage, String appActivity)
	{
		try {
			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
			dc.setCapability("appPackage", appPackage);
			dc.setCapability("appActivity", appActivity);
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			localDriver = new AppiumDriver<MobileElement>(url, dc);

		} catch (Exception e) {

			System.out.println("Cause is:"+e.getCause());
			System.out.println("Message is"+e.getMessage());
		}
		return localDriver;
	}

	public static AppiumDriver<MobileElement> setDriver(String platformName, String platformVersion, String deviceName)
	{
		try {
			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			dc.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"//apps//Calculator.apk");
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			localDriver = new AppiumDriver<MobileElement>(url, dc);

		} catch (Exception e) {

			System.out.println("Cause is:"+e.getCause());
			System.out.println("Message is"+e.getMessage());
		}
		return localDriver;
	}

}
