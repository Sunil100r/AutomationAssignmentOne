package com.automation.qa.pages;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.qa.base.TestBase;
import com.automation.qa.util.GenericKeywords;
import com.relevantcodes.extentreports.LogStatus;

public class CheckOutPage {

	@FindBy(name="processAddress")
	WebElement proceedToCheckOutAdd_Button;
	
	
	
	@FindBy(id="cgv")
	WebElement terms_Checkbox;
	String tId="cgv";
	
	@FindBy(name="processCarrier")
	WebElement proceedToCheckOutCarr_Button;
	
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	WebElement PayByBankWire_Button;
	
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]/..")
	WebElement confirmMyOrder_Button;
	
	
	@FindBy(xpath="//span[@class='price']/strong")
	WebElement price_Text;
	
	
	@FindBy(xpath="(//*[@id='center_column']/div)")
	WebElement orderSummary_Text;
	public void proceedToCheckout()
	{
		GenericKeywords g=new GenericKeywords();
		g.click(proceedToCheckOutAdd_Button);
		TestBase.report.log(LogStatus.PASS, "Proceed To Checkout Button");
	}
	
	public void shippingCheckout() throws Exception
	{
		GenericKeywords g=new GenericKeywords();
		g.jsClickById(tId);
		g.click(proceedToCheckOutCarr_Button);
		TestBase.report.log(LogStatus.PASS, "Proceed To Checkout Button");
	}
	
	
	public void confirmOrder()
	{
		GenericKeywords g=new GenericKeywords();
		g.click(PayByBankWire_Button);
		g.click(confirmMyOrder_Button);
		TestBase.report.log(LogStatus.PASS, "Confirmed the Order");
		
	}
	
	public HashMap<String, String> captureOrderSummary()
	{
		String referance=orderSummary_Text.getText().split("reference")[1].trim().split(" ")[0];
		String price=price_Text.getText();
		HashMap<String, String> orderSummary=new HashMap<String,String>();
		orderSummary.put("Reference", referance);
		orderSummary.put("Price", price);
		
		System.out.println(orderSummary);
		TestBase.report.log(LogStatus.PASS, "Captured order summary");
		return orderSummary;
		
		
	}
}
