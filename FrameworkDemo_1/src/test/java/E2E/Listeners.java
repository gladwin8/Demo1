package E2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportersNG;
import resources.base;

public class Listeners extends base implements ITestListener{

	ExtentTest test;
	
	ExtentReports reports=ExtentReportersNG.getReport();
 
	public void onTestStart(ITestResult result) {
		 
		test= reports.createTest(result.getMethod().getMethodName()); 
		
		
	}
	public void onTestFailure(ITestResult result) {
				
		test.log(Status.FAIL, "Purposely failed, Bro!!");
		test.fail(result.getThrowable());
		WebDriver driver =null;
		String testMethodName =result.getMethod().getMethodName();
		
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		{
			
		}
		try {
			getScreenshot(testMethodName,driver);
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}  
		
		
	}

	

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Testcase passed as described");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		reports.flush();
	}

	
	
}
