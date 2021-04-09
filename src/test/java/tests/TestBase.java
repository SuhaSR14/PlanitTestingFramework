package tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import core.DriverFactory;
import core.TestConfig;

public class TestBase {
	
	private WebDriver driver;

	
	private Properties properties;
	private final String propertyFilePath= "config//config.test.properties";
	public TestBase()
	{
		this.getConfig();
	}
	public void getConfig()
	{
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.test.properties not found at " + propertyFilePath);
		}	
	}
	
	
	@Parameters("browser")
	@BeforeClass
	public void initDriver(String browser) 
	{
		driver =  new DriverFactory().getDriver(browser);
	}
	
	public WebDriver getDriver() 
	{
		return driver;
	}
	
	@BeforeMethod
	public void launchApp() 
	{
		//initialise config	
		// driver.get("https://jupiter.cloud.planittesting.com/#/home");
		
		//URL is read from config.test.properties file 
		String url = properties.getProperty("appBaseURL");
		driver.get(url);
		if(url != null) return ;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");		
	}
	
	@AfterClass
	public void cleanUp() 
	{
		if(driver!=null) {
			driver.quit();
		}
	}
	

}