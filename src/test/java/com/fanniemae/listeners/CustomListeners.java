package com.fanniemae.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.fanniemae.base.TestBase;
import com.fanniemae.testcases.multiBrowsers;
import com.relevantcodes.extentreports.LogStatus;



public class CustomListeners extends TestBase implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		
		
		test.log(LogStatus.FAIL, arg0.getName().toUpperCase()+" Failed with exception : "+arg0.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture("C:\\SeleniumJAVATraining\\sdettraining\\screenshots"));
		
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<br>" + "Test FAILED : Attached FAILING Test Screenshot.<br>");
    	//Reporter.log("<a target=\"_blank\" href=" + multiBrowsers.screenshotName + "><img src=" + multiBrowsers.screenshotName	+ " height=200 width=200></img></a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		test = rep.startTest(arg0.getName().toLowerCase());
		
	}

	public void onTestSuccess(ITestResult arg0) {
		test.log(LogStatus.PASS, arg0.getName().toUpperCase()+" PASS");
		rep.endTest(test);
		rep.flush();
		
	}

}
