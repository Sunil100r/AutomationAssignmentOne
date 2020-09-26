package com.automation.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.qa.base.TestBase;
import com.automation.qa.util.GenericKeywords;
import com.relevantcodes.extentreports.LogStatus;

public class CartSummaryPage {

	@FindBy(xpath="//a[contains(text(),'Printed Dress')]/ancestor::tr[1]//a[@title='Subtract']")
	WebElement reducePrintedDressQty_Button;
	
	@FindBy(xpath="//p//a[@title='Proceed to checkout']")
	WebElement proceedToCheckout_Button;

	public void proceedToCheckout()
	{
		GenericKeywords g=new GenericKeywords();
		g.click(proceedToCheckout_Button);
		TestBase.report.log(LogStatus.PASS, "Proceed To Checkout Button");
	}
	
	public void reducePrintedDressQunatity()
	{
		reducePrintedDressQty_Button.click();
	}
}
