package com.fanniemae.testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class multiBrowsers {
	WebDriver driver;
	public static String screenshotName;

	@Test(enabled=true)
	public void getalllinksOnHomePage() throws IOException {

		System.out.println("Code to getAllLinksOnHomePage will come here");

		// System.setProperty("webdriver.gecko.driver",
		// System.getProperty("user.dir") +
		// "\\src\\test\\resources\\executables\\geckodriver.exe");

	//	 System.setProperty("webdriver.firefox.marionette","c:\\geckodriver.exe");
	//	 driver = new FirefoxDriver();

		String BrowserToRun = "webdriver.chrome.chromedriver";
		String BrowserDriverLocation = "C:\\SeleniumJAVATraining\\Softwares\\chromedriver_win32\\chromedriver.exe";

	//   	System.setProperty("webdriver.chrome.driver","C:\\SeleniumJAVATraining\\Softwares\\chromedriver_win32\\chromedriver.exe");
	//   	driver = new ChromeDriver();
		
	//   	System.setProperty("webdriver.chrome.driver",
	//			System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
	//	driver = new ChromeDriver();
		
		System.setProperty("webdriver.ie.driver","C:\\SeleniumJAVATraining\\Softwares\\IEDriverServer\\32bit\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.sdettraining.com");
		
//		captureScreenshot();
		
		// ReportNG
/*		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
					Reporter.log("<br>" + "Test PASSED : Attached Test Results Screenshot.<br>");
			    	Reporter.log("<a target=\"_blank\" href=" + screenshotName + "><img src=" + screenshotName	+ " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");
*/		
       //  Assert.fail("FORCIBLY FAIL for Listeners");
	}
	
	@Test
	public void IEHomePage() throws IOException {
		// Assert.fail("IEHomePage FORCIBLY FAIL for Listeners");
			}
	
	@Test
	public void ChromeHomePage() throws IOException {
		 //Assert.fail("Chrome HomePage FORCIBLY FAIL for Listeners");
			}
	
	@Test
	public void FirefoxHomePage() throws IOException {
		 //Assert.fail("FF HomePage FORCIBLY FAIL for Listeners");
			}
	

	public void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}
	
	

}
