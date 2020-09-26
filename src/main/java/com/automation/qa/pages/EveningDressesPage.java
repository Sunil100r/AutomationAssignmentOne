package com.automation.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.qa.base.TestBase;
import com.automation.qa.util.GenericKeywords;
import com.relevantcodes.extentreports.LogStatus;


public class EveningDressesPage 
{
	
	@FindBy(xpath="//a[contains(text(),'Printed Dress')]/ancestor::div[1]//a[@id='color_43']")
	WebElement printedDressPink_Link;
	
	@FindBy(id="quantity_wanted")
	WebElement qunatity_TextField;
	
	@FindBy(id="group_1")
	WebElement size_Dropdown;
	
	
	@FindBy(xpath="//span[text()='Add to cart']/..")
	WebElement addToCart_Button;

	String pinkId="color_43";
	
	public void selectPrintedDressPink() throws Exception
	{
		GenericKeywords g=new GenericKeywords();
		g.waitUntilElementrVisible(printedDressPink_Link);
		g.waitUntilElementrClickable(printedDressPink_Link);
		g.jsClickById(pinkId);
		TestBase.report.log(LogStatus.PASS, "Select Printed Dress Pink Color");
		
	}
	
	public void addToCart(String quantity, String size) throws Exception
	{
		GenericKeywords g=new GenericKeywords();
		g.setValue(qunatity_TextField, quantity);
		g.setValue(size_Dropdown, size);
		
		g.click(addToCart_Button);
		TestBase.report.log(LogStatus.PASS, "Added to Cart");
	}
	
}
