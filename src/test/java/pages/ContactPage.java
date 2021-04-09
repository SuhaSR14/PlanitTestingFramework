package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactPage extends BasePage{
	
	// WebElements for Contact
	@FindBy(xpath="//a[text()='Submit']")
	private WebElement btnSubmit;
	
	@FindBy(xpath="//input[@id ='forename']")
	private WebElement txtForename;
	
	@FindBy(xpath="//span[@id ='forename-err']")
	private WebElement errForename;


	@FindBy(xpath="//input[@id ='email']")
	private WebElement txtEmail;

	@FindBy(xpath="//span[@id ='email-err']")
	private WebElement errEmail;

	@FindBy(xpath="//textarea[@id ='message']")
	private WebElement txtMessage;

	@FindBy(xpath="//span[@id ='message-err']")
	private WebElement errMessage;

	@FindBy(xpath="//strong[@class='ng-binding']")
	private WebElement submitMessage;

	@FindBy(xpath="//span[@id ='email-err']")
	private WebElement invEmail;

	
	private WebDriver driver = null;
	
	// Constructor to Initialize the Page Factory	
	public ContactPage(WebDriver driver) throws InterruptedException 
	{
		super(driver);
		this.driver =  driver;
	}
	

	// Actions to be performed in Contact Page

	//Validates the mandatory field error messages
	public void validateContactPage() throws InterruptedException 
	{
		btnSubmit.click();
		String actual_ForenameError = errForename.getText();
		String expected_ForenameError = "Forename is required";
		Assert.assertEquals(actual_ForenameError, expected_ForenameError);
		
		String actual_EmailError = errEmail.getText();
		String expected_EmailError = "Email is required";
		Assert.assertEquals(actual_EmailError, expected_EmailError);
		
		String actual_MessageError = errMessage.getText();
		String expected_MessageError = "Message is required";
		Assert.assertEquals(actual_MessageError, expected_MessageError);
		
		txtForename.sendKeys("Test");
		txtEmail.sendKeys("Test@Example.com");
		txtMessage.sendKeys("Hello");
		
		System.out.println("Validation errors are gone");
	}
	
	//Validates the contact page submission	
	public void validateContactPageSubmit() throws InterruptedException 
	{
	
		txtForename.sendKeys("Test");
		txtEmail.sendKeys("Test@Example.com");
		txtMessage.sendKeys("Hello");
		btnSubmit.click();
		Thread.sleep(2000);

		Assert.assertTrue(submitMessage.isDisplayed()== true,"Submission is not successful");
		System.out.println("Submission is successful");	
		
	}
	
	//Validates the Invalid data error message validation
	public void validateContactInvalidData() throws InterruptedException 
	{		
		txtForename.sendKeys("Test");
		txtEmail.sendKeys("Test");
		txtMessage.sendKeys("Hello");
	
		Assert.assertTrue(invEmail.isDisplayed()==true, "Invalid data validation is not done");
		
		System.out.println("Invalid data validated");
		Thread.sleep(2000);		
	}
}