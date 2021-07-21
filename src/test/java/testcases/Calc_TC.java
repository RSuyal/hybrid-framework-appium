package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Calc;


public class Calc_TC extends BaseClass{	
	@Test
	public void verifyPreviewResult_Positive()
	{
		Calc lp= new Calc(driver);
		lp.clickNo6();
		lp.clickAdd();
		lp.clickNo7();
		if (lp.viewPreviewResult().equals("13"))
		{
			Assert.assertTrue(true);			
		}
	    else
		{
			Assert.assertTrue(false);
		}
	
	}
}
