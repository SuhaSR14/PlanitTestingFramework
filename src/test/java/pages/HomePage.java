package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	// WebElements for Home
	//@FindBy(xpath="//*[@id=\"nav-contact\"]/a")
	
	@FindBy(xpath="//a[text()='Contact']")
	private WebElement btnContact;
	
	@FindBy(xpath="//a[text()='Shop']")
	private WebElement btnShop;
	private WebDriver driver = null;
	
	// Constructor to Initialize the Page Factory	
	public HomePage(WebDriver driver) throws Exception 
	{
		super(driver);
		this.driver =  driver;
		if(!isHomePageDisplayed()) throw new Exception("Home Page not displayed");
	}
	
	// Actions to be performed in Home Page	
	public boolean isHomePageDisplayed() 
	{
		return btnContact.isDisplayed();
	}
	
	// Actions to be performed in Home Page

	public void navigateToContactPage()
	{
		btnContact.click();
	}
	
	public void navigateToShopPage() 
	{
		btnShop.click();
		
	}
}