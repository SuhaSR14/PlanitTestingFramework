package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage extends BasePage {

	private WebDriver driver = null;
	
	@FindBy(xpath="(//a[@class='btn btn-success']) [6]")
	private WebElement funnyCowBuyBtn;

	@FindBy(xpath="(//a[@class='btn btn-success']) [4]")
	private WebElement fluffyBunnyBuyBtn;

	@FindBy(xpath="//li[@id='nav-cart']")
	private WebElement cartBtn;

	@FindBy(xpath="(//input[@name='quantity'])[1]")
	private WebElement qtyBtn1;

	@FindBy(xpath="(//input[@name='quantity'])[2]")
	private WebElement qtyBtn2;

	@FindBy(xpath="//td[@class='ng-binding' and text()=' Funny Cow' ]")
	private WebElement funnyCowItem;

	@FindBy(xpath="//td[@class='ng-binding' and text()=' Fluffy Bunny' ]")
	private WebElement fluffyBunnyItem;

	// Constructor to Initialize the Page Factory	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	
	// Actions to be performed in Cart Page

	//Cart page validation
	public void validateCartPage() throws InterruptedException  
	{
		funnyCowBuyBtn.click();
		funnyCowBuyBtn.click();
		Thread.sleep(3000);
		fluffyBunnyBuyBtn.click();
		cartBtn.click();
		Thread.sleep(2000);
		Assert.assertTrue(qtyBtn1.isDisplayed()== true);
		Assert.assertTrue(funnyCowItem.isDisplayed()== true);
		Assert.assertTrue(qtyBtn2.isDisplayed()== true);
		Assert.assertTrue(fluffyBunnyItem.isDisplayed()== true);
			
	}

}
