package com.automation.qa.testcases;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.qa.base.TestBase;
import com.automation.qa.pages.AddToCartPage;
import com.automation.qa.pages.CartSummaryPage;
import com.automation.qa.pages.CheckOutPage;
import com.automation.qa.pages.CreateAnAccountPage;
import com.automation.qa.pages.EveningDressesPage;
import com.automation.qa.pages.MainPage;
import com.automation.qa.pages.MyaccountPage;
import com.automation.qa.pages.WomenPage;
import com.automation.qa.util.ExcelLib;
import com.automation.qa.util.NoItemException;
import com.automation.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.automation.qa.base.TestBase;
//11111111111111111111111111111111111111111
public class AutomationAssignmentTest extends TestBase
{
	MainPage mainPage;
	EveningDressesPage eveningDressPage;
	AddToCartPage addToCartPage;
	WomenPage womenPage;
	CartSummaryPage cartSummaryPage;
	CreateAnAccountPage createAnAccountPage;
	CheckOutPage checkOutPage;
	MyaccountPage myaccountPage;
	
	
	public AutomationAssignmentTest()
	{
		super();
	}
	
	@Test
	public void test() throws Throwable
	{
		
		mainPage=PageFactory.initElements(driver, MainPage.class);
		eveningDressPage=PageFactory.initElements(driver, EveningDressesPage.class);
		addToCartPage=PageFactory.initElements(driver, AddToCartPage.class);
		womenPage=PageFactory.initElements(driver, WomenPage.class);
		cartSummaryPage=PageFactory.initElements(driver, CartSummaryPage.class);
		createAnAccountPage=PageFactory.initElements(driver, CreateAnAccountPage.class);
		checkOutPage=PageFactory.initElements(driver, CheckOutPage.class);
		myaccountPage=PageFactory.initElements(driver, MyaccountPage.class);
		
		
		ExcelLib excel=new ExcelLib();
		String qunatity=excel.getXlCellValue(TestUtil.TESTDATA_SHEET_PATH, "DataSheet", 2, 2);
		String size=excel.getXlCellValue(TestUtil.TESTDATA_SHEET_PATH, "DataSheet", 2, 3);
		String updatedQunatity=excel.getXlCellValue(TestUtil.TESTDATA_SHEET_PATH, "DataSheet", 2, 4);
		
		String qunatityChiffon=excel.getXlCellValue(TestUtil.TESTDATA_SHEET_PATH, "DataSheet", 3, 2);
		String sizeChiffon=excel.getXlCellValue(TestUtil.TESTDATA_SHEET_PATH, "DataSheet", 3, 3);
		
		String email=excel.getXlCellValue(TestUtil.TESTDATA_SHEET_PATH, "DataSheet", 5, 2);
		String firstName=excel.getXlCellValue(TestUtil.TESTDATA_SHEET_PATH, "DataSheet", 6, 2);
		String lastName=excel.getXlCellValue(TestUtil.TESTDATA_SHEET_PATH, "DataSheet", 7, 2);
		String password=excel.getXlCellValue(TestUtil.TESTDATA_SHEET_PATH, "DataSheet", 8, 2);
		String address=excel.getXlCellValue(TestUtil.TESTDATA_SHEET_PATH, "DataSheet", 9, 2);
		String city=excel.getXlCellValue(TestUtil.TESTDATA_SHEET_PATH, "DataSheet", 10, 2);
		String state=excel.getXlCellValue(TestUtil.TESTDATA_SHEET_PATH, "DataSheet", 11, 2);
		String zip=excel.getXlCellValue(TestUtil.TESTDATA_SHEET_PATH, "DataSheet", 12, 2);
		String phone=excel.getXlCellValue(TestUtil.TESTDATA_SHEET_PATH, "DataSheet", 13, 2);
		
		
		mainPage.selectEveningDress();
		
		eveningDressPage.selectPrintedDressPink();
		eveningDressPage.addToCart(qunatity, size);
		
		addToCartPage.continueShopping();
		
		mainPage.selectWomen();
		
		
		if (womenPage.isDisplayed_PrintedChiffonDress())
		{
			womenPage.selectPrintedChiffonDress();
			eveningDressPage.addToCart(qunatityChiffon, sizeChiffon);
			addToCartPage.proceedToCheckout();
		}
		else
		{
			try {
			throw new NoItemException("No item in stock");
			}
			catch(NoItemException e)
			{
				TestBase.report.log(LogStatus.WARNING, "Selected Item is not listed ");
				System.out.println(e.getMessage());
				
			}
		}
		
		
		
		cartSummaryPage.reducePrintedDressQunatity();
		cartSummaryPage.proceedToCheckout();
		
		createAnAccountPage.clickCreateAccount(email);
		createAnAccountPage.fillMandatroryFields(firstName, lastName,
				password, address, city, state,
				zip, phone);
		createAnAccountPage.clickRegister();
		
		checkOutPage.proceedToCheckout();
		checkOutPage.shippingCheckout();
		checkOutPage.confirmOrder();
		HashMap<String,String> orderDetails=checkOutPage.captureOrderSummary();
		
		mainPage.clickMyacccount();
		
		myaccountPage.validate(orderDetails);
		
		mainPage.logout();
		
	}
}
