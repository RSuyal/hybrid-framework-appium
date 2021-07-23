package pageobjects;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Calc {
	
AppiumDriver<MobileElement> ldriver;
	
	public Calc(AppiumDriver<MobileElement> rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(new AppiumFieldDecorator(rdriver),this);
	}
	
	
	@FindBy(id="com.google.android.calculator:id/digit_7")
	@CacheLookup
	MobileElement buttonNo7;
			
	@FindBy(id="com.google.android.calculator:id/digit_6")
	@CacheLookup
	MobileElement buttonNo6;
	
	@FindBy(id="com.google.android.calculator:id/op_mul")
	@CacheLookup
	MobileElement buttonMultiply;
	
	@FindBy(id="com.google.android.calculator:id/op_add")
	@CacheLookup
	MobileElement buttonAdd;
	
	@FindBy(id="com.google.android.calculator:id/eq")
	@CacheLookup
	MobileElement buttonEqualsto;
	
	@FindBy(id="com.google.android.calculator:id/result_preview")
	@CacheLookup
	MobileElement resultPreview;
	
	@FindBy(id="com.google.android.calculator:id/result_final")
	@CacheLookup
	MobileElement resultFinal;
	
	@FindBy(id="com.google.android.calculator:id/formula")
	@CacheLookup
	MobileElement dispalCalculation;
	
	@FindBy(id="com.google.android.calculator:id/del")
	@CacheLookup
	MobileElement delete;
	
	public void clickdelete()
	{
		delete.click();
	}
	
	public String getCalculationScreen()
	{
		return dispalCalculation.getText();
	}
	
	public void clickNo7()
	{
		buttonNo7.click();
	}
	
	public void clickNo6()
	{
		buttonNo6.click();
	}
	
	public void clickMultiply()
	{
		buttonMultiply.click();
	}
	
	public void clickEqualsto()
	{
		buttonEqualsto.click();
	}
	
	public void clickAdd()
	{
		buttonAdd.click();
	}
	
	public String getPreviewResult()
	{
		return resultPreview.getText();
	}
	
	public String getFinalResult()
	{
		return resultFinal.getText();
	}
	
}
