package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class provides implementation to ITestListener interface of TestNG
 *@author pooja
 */
public class ListenersImplementation implements ITestListener {

	 //For Extent Report
    ExtentReports report;
    ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+" - @Test execution Started");
		
		//Create Test in Extent Report
		test=report.createTest(MethodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+" - @Test PASS");
		
		//Log the status PASS in extent report
		test.log(Status.PASS,MethodName+" - @Test PASS" );
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+" - @Test FAIL");
		System.out.println(result.getThrowable());
		
		//Log the status FAIL in Extent Report
		
		test.log(Status.FAIL, MethodName+" - @Test FAIL");
		test.log(Status.WARNING, result.getThrowable());
		
		//Capture Screenshot
		SeleniumUtilities sUtil = new SeleniumUtilities();
		JavaUtility jUtil = new JavaUtility();
		
		String screenshotName = MethodName+"-"+jUtil.getSystemDataInFormat();
		
		
		
		try {
			String path = sUtil.captureScreenShot(BaseClass.sdriver, screenshotName);
			
        /*Attach the screenshot in extent report*/
			
			test.addScreenCaptureFromPath(path);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+" - @Test SKIP");
		
		//Capture
		System.out.println(result.getThrowable());
		
		//Log the status FAIL in Extent Report
	    test.log(Status.SKIP, MethodName+" - @Test SKIP");
	    test.log(Status.WARNING, result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("Suite excution Started");
		
		//Basic configuration of Extent Report
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report - "+new JavaUtility().getSystemDataInFormat()+".html");
		esr.config().setDocumentTitle("SWAGS LABS Execution Report");
		esr.config().setReportName("Execution Build version 1.12");
		esr.config().setTheme(Theme.DARK);
		
		/*Feed the configuration to Extent reports class*/
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Environment", "Test Env");
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Paltform", "windows Family");
		report.setSystemInfo("Base URL", "https://www.saucedemo.com/");
		report.setSystemInfo("Reporter Name", "Pooja");
	}

	@Override
	public void onFinish(ITestContext context) {
		
     System.out.println("Suite excution Finished");
     
     /*Generate the extent Report*/
     report.flush();//flush means END OF EXECUTION,WITHOUT THIS WILL NOT GENERATE THE REPORT
	}

}
