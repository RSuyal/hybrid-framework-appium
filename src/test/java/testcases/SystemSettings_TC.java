package testcases;

import org.testng.annotations.Test;

public class SystemSettings_TC extends BaseClass{
	
	@Test
	void handleScrollbars()
	{
		logger.info("Setting system app is launched");
		driver.findElementByXPath("//*[@class='android.widget.LinearLayout'][6]").click();
		logger.info("Clicked on volume tab");
		try {
			driver.navigate().wait(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
