package com.automation.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.qa.base.TestBase;
import com.automation.qa.util.GenericKeywords;
import com.relevantcodes.extentreports.LogStatus;

public class CreateAnAccountPage {

	@FindBy(id="email_create")
	WebElement emailCreate_TextField;
	
	
	@FindBy(id="SubmitCreate")
	WebElement createAnAccount_TextField;
	
	@FindBy(id="customer_firstname")
	WebElement firstName_TextField;

	@FindBy(id="customer_lastname")
	WebElement lastName_TextField;
	
	@FindBy(id="passwd")
	WebElement password_TextField;
	
	@FindBy(id="firstname")
	WebElement firstNameAd_TextField;
	
	@FindBy(id="lastname")
	WebElement lastNameAd_TextField;
	
	
	@FindBy(id="address1")
	WebElement address_TextField;

	@FindBy(id="city")
	WebElement city_TextField;
	
	@FindBy(id="id_state")
	WebElement state_Dropdown;
	
	@FindBy(id="postcode")
	WebElement post_TextField;
	
	
	@FindBy(id="phone_mobile")
	WebElement mobile_TextField;
	
	
	@FindBy(id="alias")
	WebElement aliasAddress_TextField;
	
	
	@FindBy(id="submitAccount")
	WebElement register_Button;
	
	public void clickCreateAccount(String email) throws Throwable
	{
		GenericKeywords g=new GenericKeywords();
		g.setValue(emailCreate_TextField, email);
		g.click(createAnAccount_TextField);
		TestBase.report.log(LogStatus.PASS, "Creating an Account");
	}
	
	public void fillMandatroryFields(String firstName, String lastname, String password,
			String address, String city, String state, String zip, String phone) throws Throwable
	{
		GenericKeywords g=new GenericKeywords();
		g.setValue(firstName_TextField, firstName);
		g.setValue(lastName_TextField, lastname);
		g.setValue(password_TextField, password);
		g.setValue(address_TextField, address);
		g.setValue(city_TextField, city);
		g.setValue(state_Dropdown, state);
		g.setValue(post_TextField, zip);
		g.setValue(mobile_TextField, phone);
		TestBase.report.log(LogStatus.PASS, "Fill mandatory fields");
	}
	
	public void clickRegister()
	{
		GenericKeywords g=new GenericKeywords();
		g.click(register_Button);
	}
	
	
}
