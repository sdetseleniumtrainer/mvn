package com.fanniemae.draft;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {

		System.out.println("Project directory path: " + System.getProperty("user.dir"));
		
		//Using Properties Class from core Java
		Properties config = new Properties();
		Properties OR = new Properties();
		
		//Using FileInputStream Class from core Java
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);

		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);

		System.out.println("Browser used: " + config.getProperty("browser"));

		// driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		System.out.println(OR.getProperty("bmlBtn"));
	}

}
