package com.fanniemae.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance(){
		
		if(extent==null){
			
			//save the extent reports at this location
			extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
			
			//fetch the configuration as how the extend report should be from this config file settings
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extentreportsconfig\\ReportsConfig.xml"));
			
		}
		
		return extent;
		
	}

}
