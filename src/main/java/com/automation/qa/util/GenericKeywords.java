package com.automation.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.automation.qa.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class GenericKeywords {

public WebElement waitUntilElementrVisible(WebElement el)	{
		
		return TestBase.wait.until(ExpectedConditions.visibilityOf(el));
	}
	
	public WebElement waitUntilElementrClickable(WebElement el)	{
		
		return TestBase.wait.until(ExpectedConditions.elementToBeClickable(el));
	}
	
	public void setValue(WebElement el, String str) throws Exception
	{
		if (el.getTagName().equalsIgnoreCase("input"))
		{
			el.clear();
			el.sendKeys(str);
		}
		else if (el.getTagName().equalsIgnoreCase("select"))
		{
			Select sel=new Select(el);
			sel.selectByVisibleText(str);
		}
		else
		{
			throw new Exception("invalid tag");
		}
		
	}
	
	public void click(WebElement el)
	{
		waitUntilElementrVisible(el);
		waitUntilElementrClickable(el);
		el.click();
		
	}
	
	public void mouseClick(WebElement el) throws Exception
	{
		Actions builder= new Actions(TestBase.driver);
		builder.moveToElement(el).clickAndHold();
		
		builder.moveToElement(el).release();
	}
	
	public void jsClickById(String id) throws Exception
	{
		
		JavascriptExecutor js=(JavascriptExecutor)TestBase.driver;
		js.executeScript("document.getElementById('"+id+"').click();");		
		//color_43
	}
}
