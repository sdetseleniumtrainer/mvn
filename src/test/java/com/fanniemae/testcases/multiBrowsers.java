package com.fanniemae.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class multiBrowsers {
	WebDriver driver;

	@Test
	public void getalllinksOnHomePage() {

		System.out.println("Code to getAllLinksOnHomePage will come here");

		// System.setProperty("webdriver.gecko.driver",
		// System.getProperty("user.dir") +
		// "\\src\\test\\resources\\executables\\geckodriver.exe");

		// System.setProperty("webdriver.firefox.marionette","c:\\geckodriver.exe");
		// driver = new FirefoxDriver();

		String BrowserToRun = "webdriver.chrome.chromedriver";
		String BrowserDriverLocation = "C:\\SeleniumJAVATraining\\Softwares\\chromedriver_win32\\chromedriver.exe";

	   //	System.setProperty("webdriver.chrome.driver","C:\\SeleniumJAVATraining\\Softwares\\chromedriver_win32\\chromedriver.exe");
	   //	driver = new ChromeDriver();
		
		
		System.setProperty("webdriver.ie.driver",
				"C:\\SeleniumJAVATraining\\Softwares\\IEDriverServer\\32bit\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.sdettraining.com");

	}

}
