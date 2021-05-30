package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportersNG {
	
	static ExtentReports reports;
	
	public static ExtentReports getReport()
	{
	String path=System.getProperty("user.dir") + "\\reports\\index.html";
	ExtentSparkReporter report=new ExtentSparkReporter(path);
	report.config().setDocumentTitle("Gladwin's Document");
	report.config().setReportName("Gladwin's Report");
	
	reports=new ExtentReports();
	reports.attachReporter(report);
	reports.setSystemInfo("Tester", "Gladwin Isaac S");
	return reports;
	}
}
