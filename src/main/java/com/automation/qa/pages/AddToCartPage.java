package com.automation.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.qa.base.TestBase;
import com.automation.qa.util.GenericKeywords;
import com.relevantcodes.extentreports.LogStatus;

public class AddToCartPage {

	@FindBy(xpath="//span[@title='Continue shopping']")
	WebElement continueShopping_Button;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	WebElement proceedToCheckout_Button;
	
	
	public void continueShopping()
	{
		GenericKeywords g=new GenericKeywords();
		g.click(continueShopping_Button);
		TestBase.report.log(LogStatus.PASS, "Continue Shopping button");
	}
	
	
	
	public void proceedToCheckout()
	{
		GenericKeywords g=new GenericKeywords();
		g.click(proceedToCheckout_Button);
		TestBase.report.log(LogStatus.PASS, "Continue Proceed to Checkout button");
	}
}
