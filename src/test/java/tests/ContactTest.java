package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import pages.CartPage;
import pages.ContactPage;
import pages.HomePage;


public class ContactTest extends TestBase{
	
	HomePage home =null;
	ContactPage contact = null;
	CartPage cart = null;
	
	//TC1: Contact form mandatory fields validation
	@Test(priority=0)
	public void verifyContact() throws Exception {
		home = new HomePage(getDriver());
		home.navigateToContactPage();
		Thread.sleep(1000);
		contact = new ContactPage(getDriver());
		contact.validateContactPage();

	}
	
	//TC2: Contact form submission is given last priority as it takes time to submit 
	@Test(priority=3)
	public void verifyContactSubmit() throws Exception 
	{
		home = new HomePage(getDriver());
		home.navigateToContactPage();
		contact = new ContactPage(getDriver());
		contact.validateContactPageSubmit();
		Thread.sleep(4000);

	}

    //TC3:Populate mandatory details with invalid data and validate error message
	@Test(priority=1)
	public void verifyContactInvalidData() throws Exception 
	{
		home = new HomePage(getDriver());
		home.navigateToContactPage();
		contact = new ContactPage(getDriver());
		contact.validateContactInvalidData();
	}
	
	//TC4: Add to cart validation
	@Test(priority=2)
	public void verifyCart() throws Exception 
	{  
		home= new HomePage(getDriver());
		home.navigateToShopPage();
		cart = new CartPage(getDriver());
		cart.validateCartPage();
			
	}
}