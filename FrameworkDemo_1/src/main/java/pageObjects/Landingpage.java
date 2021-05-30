package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	
	public WebDriver driver;
	
	By Loginlink=By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
	By Homepagelabels1=By.xpath("//div[@id='nav-main']");
	
	
	public Landingpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement login()
	{
		return driver.findElement(Loginlink);
	}
	
	public WebElement label_categories()
	{
		return driver.findElement(Homepagelabels1);
		
	}
	
}
