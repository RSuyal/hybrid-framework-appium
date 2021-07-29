package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {

	Properties pro;

	public ReadConfig()
	{
		File src= new File(System.getProperty("user.dir")+"/Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro =new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception cause: "+e.getCause());
			System.out.println("Exception message: "+e.getMessage());
		}		

	}
	
	public String getDefaultAppiumAutomationName()
	{
		String defaultAppiumAutomationName = pro.getProperty("defaultAppiumAutomationName");
		return defaultAppiumAutomationName;

	}
	
	public String getDefaultPlatformName()
	{
		String defaultPlatformName = pro.getProperty("defaultPlatformName");
		return defaultPlatformName;

	}
	
	public String getDefaultPlatformVersion()
	{
		String defaultPlatformVersion = pro.getProperty("defaultPlatformVersion");
		return defaultPlatformVersion;

	}
	
	public String getDefaultDeviceName()
	{
		String defaultDeviceName = pro.getProperty("defaultDeviceName");
		return defaultDeviceName;

	}
	
		
	public String getDefaultAppPath()
	{
		String defaultAppPath = (System.getProperty("user.dir")+pro.getProperty("defaultAppPath"));
		return defaultAppPath;

	}
	
	public String getDefaultAppPackage()
	{
		String defaultAppPackage = pro.getProperty("defaultAppPackage");
		return defaultAppPackage;

	}
	
	public String getDefaultAppActivity()
	{
		String defaultAppActivity = pro.getProperty("defaultAppActivity");
		return defaultAppActivity;

	}

	
	public String getDefaultAppiumServerUrl()
	{
		String defaultAppiumServerUrl = pro.getProperty("defaultAppiumServerUrl");
		return defaultAppiumServerUrl;

	}

	public String getCalculatorAppPath()
	{
		String calculatorAppPath = (System.getProperty("user.dir")+pro.getProperty("calculatorAppPath"));
		return calculatorAppPath;

	}

	public String getSystemSettingAppPackage()
	{
		String systemSettingAppPackage = pro.getProperty("systemSettingAppPackage");
		return systemSettingAppPackage;

	}
	
	public String getSystemSettingAppActivity()
	{
		String systemSettingAppActivity = pro.getProperty("systemSettingAppActivity");
		return systemSettingAppActivity;

	}

	public String getAppiumAutomationName()
	{
		String appiumAutomationName = pro.getProperty("appiumAutomationName");
		return appiumAutomationName;

	}
	
	public String getAndroid11PlatformVersion()
	{
		String android11PlatformVersion = pro.getProperty("android11PlatformVersion");
		return android11PlatformVersion;

	}
	
}
