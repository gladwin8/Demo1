package E2E;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Landingpage;
import pageObjects.Loginpage;
import resources.base;

public class Homepage extends base {
	
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeMethod
	public void Open_Browser() throws Exception
	{
		driver=initializedriver(); 
		driver.get(prop.getProperty("url"));
	}
	
	@Test(dataProvider="getData")
	public void homepageNavigation(String Username,String password ,String text) throws Exception
	{
		
		
		
		log.info("Driver Initialised");
		Landingpage lp=new Landingpage(driver);
		lp.login().click();
		Loginpage login=new Loginpage(driver);
		login.email().sendKeys(Username);
		login.continu().click();
		login.password_enter().sendKeys(password);
		log.info(text);
		login.signin().click();
		
		
		
		
	}
	
	@AfterMethod
	public void Browser_close()
	{
		driver.close();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3];
		data[0][0]="primeuser@gmail.com";
		data[0][1]="Test1234";
		data[0][2]="Prime user";
		
		data[1][0]="nonprimeuser@gmail.com";
		data[1][1]="Test1234";
		data[1][2]="NonPrime user";
				
		return data;
	}
	
	
	
}
