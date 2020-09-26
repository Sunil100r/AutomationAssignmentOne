package com.automation.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.qa.base.TestBase;
import com.automation.qa.util.GenericKeywords;
import com.relevantcodes.extentreports.LogStatus;


public class MainPage {

	@FindBy(xpath="(//a[@title='Dresses'])[2]")
	WebElement dresses_Link;
	
	@FindBy(linkText="Evening Dresses")
	WebElement eveningDresses_Link;
	
	@FindBy(linkText="Women")
	WebElement women_Link;
	
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement customerAccount_Link;
	
	
	@FindBy(xpath="//a[@title='Log me out']")
	WebElement logout_Link;
	
	
	public void selectEveningDress()
	{
		GenericKeywords g=new GenericKeywords();
		g.click(dresses_Link);
		g.click(eveningDresses_Link);
		TestBase.report.log(LogStatus.PASS, "Select Evening Dress");
	}
	
	public void selectWomen()
	{
		GenericKeywords g=new GenericKeywords();
		g.click(women_Link);
		TestBase.report.log(LogStatus.PASS, "Select Women Link");
	}
	
	public void clickMyacccount()
	{
		GenericKeywords g=new GenericKeywords();
		g.click(customerAccount_Link);
		TestBase.report.log(LogStatus.PASS, "Navigate to Myaccount");
	}
	
	public void logout()
	{
		GenericKeywords g=new GenericKeywords();
		g.click(logout_Link);
		TestBase.report.log(LogStatus.PASS, "Logout from app");
	}
	
	
	
	
	
	
}
