package Extent_manager;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extent_report {

	static ExtentReports reports;
	public static String screenshotpath;
	public static ExtentReports getReports()
	{
		if(reports==null)
		{
			reports=new ExtentReports();
			Date d=new Date();
			String reportpath=System.getProperty("user.dir")+"//report//"+d.toString().replaceAll(":", "_");
			screenshotpath=System.getProperty("user.dir")+"//report"+"//screenshot";
			File f=new File(screenshotpath);
			f.mkdirs();
			ExtentSparkReporter sparks=new ExtentSparkReporter(reportpath);
			sparks.config().setReportName("This is my first project");
			sparks.config().setDocumentTitle("Journey of my life");
			sparks.config().setTheme(Theme.DARK);
			sparks.config().setEncoding("utf-8");
				
			reports.attachReporter(sparks);
		}
		return reports;
	}
}
