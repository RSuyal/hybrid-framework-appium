package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Calc;


public class Calc_TC extends BaseClass {	
	
	static Calc lp;
		 				
	@Test(priority=1)
	public void verifyPreviewResult_Positive()
	{
		lp = new Calc(driver);
		lp.clickNo6();
		logger.info("Clicked on No. 6");
		lp.clickAdd();
		logger.info("Clicked on add button");
		lp.clickNo7();
		Assert.assertEquals(lp.getPreviewResult(),"12");		
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
}
