package com.automation.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.qa.base.TestBase;
import com.automation.qa.util.GenericKeywords;
import com.automation.qa.util.NoItemException;
import com.relevantcodes.extentreports.LogStatus;

public class WomenPage {

	@FindBy(linkText="Printed Chiffon Dress")
	WebElement printedChiffonDress_Link;
	
	@FindBy(xpath="//a[contains(text(),'Printed Chiffon Dress')]/ancestor::div[1]//span[text()='Add to cart']/..")
	WebElement printedChiffonDressAddToCart_Button;
	
	public boolean isDisplayed_PrintedChiffonDress()
	{
		return printedChiffonDress_Link.isDisplayed();
	}
	public void selectPrintedChiffonDress() throws NoItemException
	{
		GenericKeywords g=new GenericKeywords();
		try {
		g.click(printedChiffonDress_Link);
		}
		catch(Exception e)
		{
			throw new NoItemException("No item in stock");
		}
	}
	
	public void addCartPrintedChiffonDress()
	{
		GenericKeywords g=new GenericKeywords();
		g.click(printedChiffonDressAddToCart_Button);
		TestBase.report.log(LogStatus.PASS, "Add Printed Chiffon Dress ");
	}
	
	
}
