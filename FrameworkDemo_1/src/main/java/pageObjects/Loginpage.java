package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {

public WebDriver driver;
	
	By email=By.cssSelector("[id='ap_email']");
	//primeuser@gmail.com
	By contin_ue=By.cssSelector("span[id='continue']");
	
	By password=By.xpath("//input[@id='ap_password']");
	
	By signin=By.xpath("//input[@id='signInSubmit']");
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement email()
	{
		return driver.findElement(email);
	}
	
	public WebElement continu()
	{
		return driver.findElement(contin_ue);
		
	}
	
	public WebElement password_enter()
	{
		return driver.findElement(password);
		
	}
	
	public WebElement signin()
	{
		return driver.findElement(signin);
		
	}
	
}
