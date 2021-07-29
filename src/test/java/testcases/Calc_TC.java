package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.Calc;


public class Calc_TC extends BaseClass {	
	
	static Calc lp;
	
	// this test verify preview result functionality with valid data		 				
	@Test(priority=1, dataProvider="verifyPreviewResult_td")	
	public void verifyPreviewResult_VD(String ExpectedPR)
	{
		lp = new Calc(driver);
		lp.clickNo6();
		logger.info("Clicked on No. 6");
		lp.clickAdd();
		logger.info("Clicked on add button");
		lp.clickNo7();
		Assert.assertEquals(lp.getPreviewResult(),ExpectedPR);		
	}
	
	@Test(priority=2)
	public void verifyCalculationScreen()
	{
		lp.clickdelete();
		lp.clickdelete();
		lp.clickdelete();
		logger.info("Clicked on delete button to clear all");
		lp.clickNo6();
		logger.info("Clicked on no. 6");
		lp.clickNo7();
		logger.info("Clicked on no. 7");
		lp.clickNo7();
		logger.info("Clicked on no. 6");
		
		Assert.assertEquals(lp.getCalculationScreen(), "677");
		
	}
	
	@DataProvider(name="verifyPreviewResult_td")
	public String[][] verifyPreviewResult_td() {
		String[][] excelData = excelFileReader(getProjectPath()+"/testdata/calc_testdata.xlsx","Sheet1");
		return excelData;
	}
}
