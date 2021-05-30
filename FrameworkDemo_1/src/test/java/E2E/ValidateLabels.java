package E2E;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Landingpage;
import resources.base;

public class ValidateLabels extends base {
	
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void Open_Browser() throws Exception
	{
		driver=initializedriver(); 
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(2500);
		log.info("Driver Initialized");
	}
	
	@Test
	public void Labelsvalidation() throws Exception
	{
		
		Landingpage l=new Landingpage(driver);
		Assert.assertFalse(l.label_categories().isDisplayed());
		String ll=l.label_categories().getText();
		System.out.println(ll);
		log.info("Categories label validated");	
	}
	
	@AfterTest
	public void Browser_close()
	{
		driver.close();
	}
	
}
