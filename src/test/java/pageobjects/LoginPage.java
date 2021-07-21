package pageobjects;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.cache.annotation.Cacheable;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage{

	AppiumDriver<MobileElement> ldriver;
	
	public LoginPage(AppiumDriver<MobileElement> rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(new AppiumFieldDecorator(rdriver),this);
	}
	
	
	
	
		

}
