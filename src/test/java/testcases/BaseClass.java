package testcases;
import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilities.DriverUtility;
import utilities.ReadConfig;

public class BaseClass {	

	public static ReadConfig readConfiguration= new ReadConfig();
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
	public static String[][] excelDataArray;


	// Here we are initializing driver based on user preferences 
	@Parameters("actionType")
	@BeforeTest
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

		logger.info("driver is set");
	}

	
	// Here we are closing driver
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		logger.info("execution completed and driver closed");

	}

	// here we are taking the screenshots
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

	//here we are taking the screenshots
	@AfterMethod
	public void faliurScreenshotMethod(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			logger.info(result.getName()+ " test case failed" );
			captureScreen(driver, result.getName());
		}
	}	

	// here we are reading the excel Files(xls/xlsx)
	
	
	public String[][] excelFileReader(String filePath, String sheetName)
	{
		try {
			File f= new File(filePath);
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(sheetName);
			int lastCellNo= sheet.getRow(0).getLastCellNum();
			int lastRowNo= sheet.getLastRowNum();
			excelDataArray = new String[lastRowNo][lastCellNo]; 
			for(int i=0; i<sheet.getLastRowNum(); i++)
			{
				for(int j=0; j<lastCellNo; j++)
				{
					excelDataArray[i][j] = sheet.getRow(i+1).getCell(j).toString();						
				}
			}			
			wb.close();
		}
		catch (Exception e) {
			e.getStackTrace();
			System.out.println("exception Cause: "+e.getCause());
			System.out.println("exception Message: "+e.getMessage());		
		}	
		return excelDataArray;
	}
	

	// here we are getting the project directory path 
	public String getProjectPath()
	{
	String path=System.getProperty("user.dir");

	return path;

	}

	}
