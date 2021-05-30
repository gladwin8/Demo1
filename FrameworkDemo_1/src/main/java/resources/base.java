package resources;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;	
	public WebDriver initializedriver() throws Exception
	{
		prop=new Properties();
		FileInputStream file =new FileInputStream("G:\\ProjectJava\\Eclipse\\FrameworkDemo_1\\src\\main\\java\\resources\\data.properties");
		prop.load(file);
		String browsername=prop.getProperty("browser");
		
		System.out.println(browsername);
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Softwares\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Softwares\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	
	}
	
	public void getScreenshot(String testcaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"\\reports\\" +testcaseName+ ".png";
		FileUtils.copyFile(src, new File(dest));
	}
}
