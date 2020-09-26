package com.automation.qa.pages;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.qa.base.TestBase;
import com.automation.qa.util.GenericKeywords;
import com.relevantcodes.extentreports.LogStatus;

public class MyaccountPage {

	@FindBy(xpath="//a[@title='Orders']")
	WebElement orderHistory_Button;
	
	@FindBy(xpath="//table//tr[1]/td[1]")
	WebElement reference_Text;
		
	@FindBy(xpath="//table//tr[1]/td[3]")
	WebElement totalPrice_Text;
	

	public void validate(HashMap<String,String> ref)
	{
		GenericKeywords g=new GenericKeywords();
		g.click(orderHistory_Button);
		
		
		
		if (ref.get("Reference").equals(reference_Text.getText()))
		{
			TestBase.report.log(LogStatus.PASS, "Order Reference Matching ");
		}
		else
		{
			TestBase.report.log(LogStatus.FAIL, "Order Reference Matching ");
		}
		
		if (ref.get("Price").equals(totalPrice_Text.getText()))
		{
			TestBase.report.log(LogStatus.PASS, "Payment Amount Matching ");
		}
		else
		{
			TestBase.report.log(LogStatus.FAIL, "Payment Amount Matching ");
		}
	}
	
}
